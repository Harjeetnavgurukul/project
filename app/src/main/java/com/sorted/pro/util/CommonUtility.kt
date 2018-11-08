package com.sorted.pro.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sorted.pro.R

abstract class CommonUtility() : AppCompatActivity() {
    var mContext: Context? = null
//    var createDialog:CreateDialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun  initializeContext(context: Context) {
        this.mContext = context
//        createDialog = CreateDialog(context)
    }

    fun goNext(mContext: Context, class1: Class<*>) {
        val mIntent = Intent(mContext, class1)
        startActivity(mIntent)
        finish()
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left)
    }

}