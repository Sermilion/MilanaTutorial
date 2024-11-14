package io.readian.milanatutorial.feature.app

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SignUpScreenViewModel : ViewModel() {
    var username = mutableStateOf("")
        private set
    var email = mutableStateOf("")
        private set
    var password = mutableStateOf("")
        private set
    var confirmPassword = mutableStateOf("")
        private set

    fun onUsernameChange(newUsername: String) {
        username.value = newUsername
    }

    fun onEmailChange(newEmail: String) {
        email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    fun onConfirmPasswordChange(newConfirmPassword: String) {
        confirmPassword.value = newConfirmPassword
    }

    fun onSignUpClick() {
        if (password.value != confirmPassword.value) {
            println("Passwords do not match")
            return
        }

        viewModelScope.launch {
            println("Signing up with:")
            println("Username: ${username.value}")
            println("Email: ${email.value}")
            println("Password: ${password.value}")
        }
    }
    }

