package com.sorted.pro.mvvmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.sorted.pro.model.NotificationModel

class NotifiViewModel(private val mNotificationModel: NotificationModel, private val mContext: Context) : ViewModel() {

    val dateMonth: String
        get() = mNotificationModel.date

    val weekdays: String
        get() = mNotificationModel.date

    val notification: String
        get() = mNotificationModel.message

    val color: String
        get() = mNotificationModel.colorCode


}