package javiercastellanos.com.example.abc.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javiercastellanos.com.example.abc.model.LoginDTO
import javiercastellanos.com.example.abc.repository.RemoteUsuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    private val _isLogged = MutableLiveData<Boolean>()
    val isLogged: LiveData<Boolean> = _isLogged
    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var remoteUsuario: RemoteUsuario = RemoteUsuario()

    fun onEmailChanged(email: String) {
        _email.value = email
    }
    fun onPasswordChanged(password: String) {
        _password.value = password
    }
    fun onLoginClicked() {
        val loginDTO = LoginDTO(
            contrasena = _password.value!!,
            email = _email.value!!
        )
        uiScope.launch {
            try {
                //remoteUsuario.login(loginDTO)
                val response = remoteUsuario.login(loginDTO)
                _email.value = ""
                _password.value = ""
                if(response.code().equals(200)) {
                    _isLogged.value = true
                }

            } catch (e: Exception) {

            }
        }
    }

}