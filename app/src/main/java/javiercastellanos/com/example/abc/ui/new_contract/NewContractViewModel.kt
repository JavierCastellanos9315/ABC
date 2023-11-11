package javiercastellanos.com.example.abc.ui.new_contract

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javiercastellanos.com.example.abc.repository.RemoteUsuario
import javiercastellanos.com.example.abc.ui.utils.ComboOption
import javiercastellanos.com.example.abc.ui.utils.SharePreference
import javax.inject.Inject
@HiltViewModel
class NewContractViewModel @Inject constructor(private val remoteUsuario: RemoteUsuario) : ViewModel() {
    private val _applicant = MutableLiveData<List<ComboOption>>()
    val applicant: LiveData<List<ComboOption>> = _applicant
    private val _company = MutableLiveData<List<ComboOption>>()
    val company: LiveData<List<ComboOption>> = _company
    private val _project = MutableLiveData<List<ComboOption>>()
    val project: LiveData<List<ComboOption>> = _project
    private val _rol = MutableLiveData<List<ComboOption>>()
    val rol: LiveData<List<ComboOption>> = _rol
    private val _applicantSelected = MutableLiveData<List<ComboOption>>()
    val applicantSelected: LiveData<List<ComboOption>> = _applicantSelected
    private val _companySelected = MutableLiveData<List<ComboOption>>()
    val companySelected: LiveData<List<ComboOption>>? = _companySelected
    private val _projectSelected = MutableLiveData<List<ComboOption>>()
    val projectSelected: LiveData<List<ComboOption>>? = _projectSelected
    private val _rolSelected = MutableLiveData<List<ComboOption>>()
    val rolSelected: LiveData<List<ComboOption>>? = _rolSelected

    fun onApplicantChanged(applicant: List<ComboOption>) {
        _applicantSelected.value = applicant
    }
    fun onCompanyChanged(company: List<ComboOption>) {
        _companySelected.value = company
    }
    fun onProjectChanged(project: List<ComboOption>) {
        _projectSelected.value = project
    }
    fun onRolChanged(rol: List<ComboOption>) {
        _rolSelected.value = rol
    }
    fun getInfoInicial( sharePreference: SharePreference) {
    }

    fun onSaveInfoClicked(onSaveSuccess: () -> Unit) {

    }
}