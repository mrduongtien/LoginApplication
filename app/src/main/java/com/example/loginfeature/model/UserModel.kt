package com.example.loginfeature.model

import android.text.TextUtils
import android.util.Patterns

data class UserModel(var email: String, var password: String) {
    companion object {
        const val WRONG_EMAIL_EMPTY = 0;
        const val WRONG_EMAIL_PATTERN = 1
        const val WRONG_PASSWORD_LENGTH = 2
        const val DATA_VALID = -1
    }

    fun isDataValid(): Int {
        return if (TextUtils.isEmpty(email)) {
            WRONG_EMAIL_EMPTY
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            WRONG_EMAIL_PATTERN
        } else if (password.length < 7) {
            WRONG_PASSWORD_LENGTH
        } else {
            DATA_VALID
        }
    }
}