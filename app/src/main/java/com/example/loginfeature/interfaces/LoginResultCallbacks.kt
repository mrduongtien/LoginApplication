package com.example.loginfeature.interfaces


interface LoginResultCallbacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}