package com.example.loginfeature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginfeature.interfaces.LoginResultCallbacks

class LoginViewModelFactory(private val listener: LoginResultCallbacks) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}
