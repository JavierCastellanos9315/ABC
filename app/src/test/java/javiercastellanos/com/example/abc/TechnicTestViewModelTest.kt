package javiercastellanos.com.example.abc

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.mockk
import javiercastellanos.com.example.abc.model.PosiblesRespuesta
import javiercastellanos.com.example.abc.model.QuestionOutDTO
import javiercastellanos.com.example.abc.model.TestResponseDTOItem
import javiercastellanos.com.example.abc.repository.RemoteUsuario
import javiercastellanos.com.example.abc.ui.tecnic_test.TechnicTestViewModel
import javiercastellanos.com.example.abc.ui.utils.SharePreference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit.*
import org.mockito.junit.MockitoRule

class TechnicTestViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mockitoRule: MockitoRule = rule()

    @Mock
    lateinit var remoteUsuario: RemoteUsuario

    @Mock
    lateinit var applicationContext: Context

    @Mock
    lateinit var sharePreference: SharePreference

    @Mock
    lateinit var observerListTests: Observer<List<TestResponseDTOItem>>

    @Mock
    lateinit var observerQuestion: Observer<QuestionOutDTO>

    @Mock
    lateinit var observerSelectedOption: Observer<PosiblesRespuesta>

    @Mock
    lateinit var observerButtonLabel: Observer<String>

    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var viewModel: TechnicTestViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = TechnicTestViewModel(remoteUsuario, applicationContext)
        viewModel.listTests?.observeForever(observerListTests)
        viewModel.question?.observeForever(observerQuestion)
        viewModel.selectedOption.observeForever(observerSelectedOption)
        viewModel.buttonLabel.observeForever(observerButtonLabel)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `setSelectedOption sets the value in _selectedOption`() {
        // Arrange
        val selectedOption = mockk<PosiblesRespuesta>()

        // Act
        viewModel.setSelectedOption(selectedOption)

        // Assert
        assert(viewModel.selectedOption.value == selectedOption)
        verify(observerSelectedOption).onChanged(selectedOption)
    }


}