package com.sorted.pro.activity

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.sorted.pro.util.CommonUtility
import com.sorted.pro.R

class SplashActivity : CommonUtility() {
    var logo_IV: ImageView? = null
    private var animation1: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initializeViewVariable()
        initializeVariable()
        initializeView()
    }


    private fun initializeViewVariable() {
        logo_IV = findViewById(R.id.logo_IV) as ImageView
    }

    private fun initializeVariable() {
        animation1 = AnimationUtils.loadAnimation(this,
                R.anim.fade)
        mContext = this
    }

    private fun initializeView() {
        logo_IV!!.startAnimation(animation1)
        animation1!!.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                goNext(mContext!!, LoginActivity::class.java)
            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })
    }


}
