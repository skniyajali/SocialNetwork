package com.niyaj.socialnetwork.presentation.register


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {
    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _showPasswordToggle = mutableStateOf(false)
    val showPasswordToggle: State<Boolean> = _showPasswordToggle

    private val _usernameError = mutableStateOf<String>("")
    val usernameError: State<String> = _usernameError

    private val _passwordError = mutableStateOf<String>("")
    val passwordError: State<String> = _passwordError

    private val _emailError = mutableStateOf<String>("")
    val emailError: State<String> = _emailError

    fun setUsernameText(username: String){
        _usernameText.value = username
    }

    fun setPasswordText(password: String){
        _passwordText.value = password
    }

    fun setEmailText(email: String){
        _emailText.value = email
    }

    fun setShowPasswordToggle(showPassword: Boolean){
        _showPasswordToggle.value = showPassword
    }
    fun setIsUsernameError(error: String){
        _usernameError.value = error
    }

    fun setIsEmailError(error: String){
        _emailError.value = error
    }

    fun setIsPasswordError(error: String){
        _passwordError.value = error
    }
}
