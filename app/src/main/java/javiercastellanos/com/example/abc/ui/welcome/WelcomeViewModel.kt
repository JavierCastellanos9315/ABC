package javiercastellanos.com.example.abc.ui.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel: ViewModel() {
    private val _toLogged = MutableLiveData<Boolean>()
    val toLogged: LiveData<Boolean> = _toLogged
    private val _toSignUp = MutableLiveData<Boolean>()
    val toSignUp: LiveData<Boolean> = _toSignUp

    fun setToLogged(){
        _toLogged.value = true
    }
    fun setToSignUp(){
        _toSignUp.value = true
    }
}