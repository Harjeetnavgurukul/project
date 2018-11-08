package com.sorted.pro.activity

import android.app.ProgressDialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import assure.mw.com.interfaces.LoginInputValidationCallback
import com.sorted.pro.util.CommonUtility
import com.sorted.pro.mvvmodel.LoginViewModel
import com.sorted.pro.R
import com.sorted.pro.databinding.ActivityLoginBinding

class LoginActivity : CommonUtility(), LoginInputValidationCallback {
    //    var mLogin: Login? = null;
    var activityMainBinding: ActivityLoginBinding? = null
    var mLoginViewModel: LoginViewModel? = null
    var progress: ProgressDialog? = null

    override fun onSuccess(s: String) {
        Toast.makeText(this, "Data Validated is success", Toast.LENGTH_SHORT).show()
//        var intent = Intent(this, ChoiceActivity::class.java)
//        startActivity(intent)
        goNext(this,ChoiceActivity::class.java)
    }

    override fun onError(s: String) {
        Toast.makeText(this, "Please enter correct email and password", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//        setSupportActionBar(toolbar)

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
        mLoginViewModel = LoginViewModel(this)
        activityMainBinding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        activityMainBinding!!.setVml(mLoginViewModel)
    }
}

//}
