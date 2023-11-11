package javiercastellanos.com.example.abc.ui.interview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javiercastellanos.com.example.abc.model.ExperienciaOut
import javiercastellanos.com.example.abc.repository.RemoteUsuario
import javiercastellanos.com.example.abc.ui.utils.SharePreference
import javax.inject.Inject
@HiltViewModel
class InterviewViewModel @Inject constructor(private val remoteUsuario: RemoteUsuario) : ViewModel() {

    private val _listInterviews = MutableLiveData<List<ExperienciaOut>>()
    val listInterviews: LiveData<List<ExperienciaOut>>? = _listInterviews
    private val _isDetail = MutableLiveData<Boolean>()
    val isDetail: LiveData<Boolean> = _isDetail
    fun getInitialData(sharePreference: SharePreference){
        sharePreference.getUserLogged()?.let {
            _isDetail.value = it.id_tipo_usuario == 2
    }
    }
}