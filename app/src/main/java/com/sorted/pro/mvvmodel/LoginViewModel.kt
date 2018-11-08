package com.sorted.pro.mvvmodel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.view.View

import assure.mw.com.interfaces.LoginInputValidationCallback
import com.sorted.pro.model.User

class LoginViewModel(private val mDataListener: LoginInputValidationCallback) : ViewModel() {
    private val user: User


    //    @BindingAdapter("android:addTextChangeListener")
    //    public static void  setText(EditText edit, String val){
    //
    //    }
    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                user.email = editable.toString()
            }
        }

    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun afterTextChanged(editable: Editable) {
                user.password = editable.toString()
            }
        }

    init {
        user = User("user457@assure.com", "12345678")
    }


    fun onLoginClicked(view: View) {
        checkDataValidity()
    }

    private fun checkDataValidity() {
        if (user.isInputDataValid)
            mDataListener.onSuccess("Login was successful")



        else {
            mDataListener.onError("Email or Password not valid")
        }
    }

    fun getUser(): User {
        return user;
    }

}
