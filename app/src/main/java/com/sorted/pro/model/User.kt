package com.sorted.pro.model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns

class User(private var mEmail: String, private var mPassword: String) : BaseObservable() {

    var email: String
        get() = mEmail
        set(email) {
            mEmail = email
            notifyChange()
        }

    var password: String
        get() = mPassword
        set(password) {
            mPassword = password
            notifyChange()
        }

    val isInputDataValid: Boolean
        get() = !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 5
}
