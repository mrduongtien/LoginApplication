package com.example.loginfeature.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.loginfeature.interfaces.LoginResultCallbacks
import com.example.loginfeature.model.UserModel

class LoginViewModel(private val listener: LoginResultCallbacks) : ViewModel() {
    private lateinit var user: UserModel

    init {
        this.user = UserModel("", "")
    }

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                p0.toString().also { user.email = it }
            }

        }

    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                p0.toString().also { user.password = it }
            }

        }

    fun onLoginClicked(v: View) {
        when (user.isDataValid()) {
            UserModel.WRONG_EMAIL_EMPTY -> {
                listener.onError("Email must not be null")
            }
            UserModel.WRONG_EMAIL_PATTERN -> {
                listener.onError("Wrong email pattern")
            }
            UserModel.WRONG_PASSWORD_LENGTH -> {
                listener.onError("Password length must greater than 6")
            }
            else -> {
                listener.onSuccess("Logged in successfully")
            }
        }
    }
}