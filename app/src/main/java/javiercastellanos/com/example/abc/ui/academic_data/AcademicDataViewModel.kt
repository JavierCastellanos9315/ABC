package javiercastellanos.com.example.abc.ui.academic_data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javiercastellanos.com.example.abc.model.AcademicaDTO
import javiercastellanos.com.example.abc.model.InformacionAcademicaIn
import javiercastellanos.com.example.abc.model.InformacionAcademicaOut
import javiercastellanos.com.example.abc.repository.RemoteUsuario
import javiercastellanos.com.example.abc.ui.utils.ComboOption
import javiercastellanos.com.example.abc.ui.utils.SharePreference
import javiercastellanos.com.example.abc.ui.utils.getActualYear
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AcademicDataViewModel @Inject constructor() : ViewModel() {
    private val _instituteEducation = MutableLiveData<String>()
    val instituteEducation: LiveData<String> = _instituteEducation
    private val _carrer = MutableLiveData<String>()
    val carrer: LiveData<String> = _carrer
    private val _startYear = MutableLiveData<String>()
    val startYear: LiveData<String> = _startYear
    private val _finalYear = MutableLiveData<String>()
    val finalYear: LiveData<String> = _finalYear
    private val _inProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> = _inProgress
    private val _listAcademic = MutableLiveData<List<InformacionAcademicaOut>>()
    val listAcademic: LiveData<List<InformacionAcademicaOut>>? = _listAcademic
    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var remoteUsuario: RemoteUsuario = RemoteUsuario()
    private var idCandidato: Int? = null

    fun onCarrerChanged(carrer: String) {
        _carrer.value = carrer
    }

    fun onStartYearChanged(startYear: String) {
        _startYear.value = startYear
    }

    fun inProgressChanged(checked: Boolean) {
        _finalYear.value = getActualYear().toString()
        _inProgress.value = checked
    }

    fun onInstituteEducationChanged(instituteEducation: String) {
        _instituteEducation.value = instituteEducation
    }

    fun onFinalYearChanged(finalYear: String) {
        _finalYear.value = finalYear
    }

    fun onSaveClicked( onSucess: () -> Unit, onSaveFailed: () -> Unit) {
        if (_instituteEducation.value.isNullOrEmpty() || _carrer.value.isNullOrEmpty() || _startYear.value.isNullOrEmpty() || _finalYear.value.isNullOrEmpty()) {
            onSaveFailed()
        } else {
            val academicaDTO = AcademicaDTO(
                id_candidato = idCandidato!!,
                informacionAcademica = InformacionAcademicaIn(
                    institucion = _instituteEducation.value?: "",
                    titulo = _carrer.value?: "",
                    fecha_fin = _finalYear.value?: "",
                    fecha_inicio = _startYear.value?: "",
                    en_curso = inProgress.value!!
                )
            )
            uiScope.launch {
                try {
                    val response = remoteUsuario.saveInformacionAcademica(academicaDTO)
                    if (response.code() == (200)) {
                        onSucess()
                    } else {
                        onSaveFailed()
                    }
                } catch (e: Exception) {

                }
            }
        }

    }

    fun getInfoUser(sharePreference: SharePreference) {
        uiScope.launch {
            try {
                val response = remoteUsuario.getCandidato(sharePreference.getUserLogged()!!.usuario)
                if (response.code()==(200)) {
                    idCandidato = response.body()!!.id
                    _listAcademic.value = response.body()!!.informacionAcademica
                }
            } catch (e: Exception) {

            }
        }
    }
}