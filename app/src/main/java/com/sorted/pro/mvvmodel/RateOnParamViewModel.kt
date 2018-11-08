package com.sorted.pro.mvvmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.widget.RatingBar
import com.sorted.pro.fragement.RateOnParameter
import com.sorted.pro.model.RatingParameters

class RateOnParamViewModel(private val mRatingParameters: RatingParameters, private val mContext: Context) : ViewModel() {


    val paramName: String
        get() = mRatingParameters.parameterTitle

    val rate: Int
        get() = mRatingParameters.value

    val onRatingChanged: RatingBar.OnRatingBarChangeListener
        get() = object : RatingBar.OnRatingBarChangeListener {
            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
                mRatingParameters.value = rating.toInt()
            }


        }
}