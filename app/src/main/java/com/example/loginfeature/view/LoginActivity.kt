package com.example.loginfeature.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.loginfeature.R
import com.example.loginfeature.databinding.ActivityLoginBinding
import com.example.loginfeature.interfaces.LoginResultCallbacks
import com.example.loginfeature.viewmodel.LoginViewModel
import com.example.loginfeature.viewmodel.LoginViewModelFactory

class LoginActivity : AppCompatActivity(), LoginResultCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityLoginBinding = DataBindingUtil
            .setContentView<ActivityLoginBinding>(this, R.layout.activity_login)

        activityLoginBinding.viewModel = ViewModelProvider(this,
            LoginViewModelFactory(this))[LoginViewModel::class.java]
    }

    override fun onSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}