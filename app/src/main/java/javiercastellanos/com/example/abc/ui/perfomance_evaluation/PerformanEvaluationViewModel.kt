package javiercastellanos.com.example.abc.ui.perfomance_evaluation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javiercastellanos.com.example.abc.model.ExperienciaOut
import javiercastellanos.com.example.abc.repository.RemoteUsuario
import javiercastellanos.com.example.abc.ui.utils.ComboOption
import javiercastellanos.com.example.abc.ui.utils.SharePreference
import javax.inject.Inject

@HiltViewModel
class PerformanEvaluationViewModel@Inject constructor(private val remoteUsuario: RemoteUsuario) : ViewModel()  {
    private val _listPerformanceEvaluations = MutableLiveData<List<ExperienciaOut>>()
    val listPerformanceEvaluations: LiveData<List<ExperienciaOut>>? = _listPerformanceEvaluations

    private val _applicant = MutableLiveData<List<ComboOption>>()
    val applicant: LiveData<List<ComboOption>> = _applicant
    private val _applicantSelected = MutableLiveData<List<ComboOption>>()
    val applicantSelected: LiveData<List<ComboOption>> = _applicantSelected
    private val _description = MutableLiveData<String>()
    val description: LiveData<String> = _description
    fun onApplicantChanged(applicant: List<ComboOption>) {
        _applicantSelected.value = applicant
    }
    fun onDescriptionChanged(description: String) {
        _description.value = description
    }

    fun getInfoInicial(sharePreference: SharePreference){

    }

    fun getInfoCandidate(sharePreference: SharePreference)
    {
        /*uiScope.launch {
            try {
                val response = remoteUsuario.getPerformanceEvaluation()
                if (response.code().equals(200)) {
                    _listPerformanceEvaluations.value =
                        response.body()!!.experiencias.toComboOptions()
                }
            } catch (e: Exception) {
                println("error")
            }
        }*/
    }

    fun onSaveInfoClicked(onSaveSuccess: () -> Unit) {

    }
}