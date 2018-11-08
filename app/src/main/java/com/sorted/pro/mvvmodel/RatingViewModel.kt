package com.sorted.pro.mvvmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.RatingBar
import com.sorted.pro.model.RatingModel

class RatingViewModel(private val mRatingModel: RatingModel, private val mContext: Context) : ViewModel() {

    val name: String
        get() = mRatingModel.name

    val description: String
        get() = mRatingModel.description

    val subject: String
        get() = mRatingModel.subject

    val rate: Int
        get() = mRatingModel.rate

    val onRatingChanged: RatingBar.OnRatingBarChangeListener
        get() = object : RatingBar.OnRatingBarChangeListener {
            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
                mRatingModel.rate = rating.toInt()
            }


        }
}