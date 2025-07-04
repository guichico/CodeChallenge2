package com.apphico.codechallenge2.ui.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

// TODO Move to model module
data class User(
    val userName: String = "guilherme",
    val password: String = "123456"
)

@HiltViewModel
class LoginViewModel @Inject constructor (

) : ViewModel() {
    val user = MutableStateFlow(User())

    // TODO Create a state class
    val isUserLogged = MutableStateFlow(false)

    fun onUserNameChange(userName: String) {
        user.value = user.value.copy(userName = userName)
    }

    fun onPasswordChange(password: String) {
        user.value = user.value.copy(password = password)
    }

    fun login() {
        with(user.value) {
            if (userName.isNotEmpty() && password.isNotEmpty()) {
                if(userName == "guilherme" && password == "123456") {
                    isUserLogged.value = true
                } else {
                    // TODO Show error
                }
            }
        }
    }
}