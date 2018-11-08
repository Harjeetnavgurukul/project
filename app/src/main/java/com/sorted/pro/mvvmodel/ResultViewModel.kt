package com.sorted.pro.mvvmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.sorted.pro.model.ResultModel

class ResultViewModel constructor(private val mResultModel:ResultModel, private val mContext: Context): ViewModel() {



    val testSeries: String
        get() = mResultModel.testSeriesNumber

    val scheduleDate: String
        get() = mResultModel.scheduledDate

    val subject: String
        get() = mResultModel.subjectName

    val status: String
        get() = mResultModel.status

    val marks:String
           get() = (mResultModel.obtainedMarks.toString()+ " / "+mResultModel.totalMarks.toString())


}