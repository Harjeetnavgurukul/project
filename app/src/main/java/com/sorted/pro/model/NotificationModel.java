package com.sorted.pro.model;

import android.databinding.BaseObservable;

public class NotificationModel extends BaseObservable {
    private String message;
    private String date;
    private String colorCode;

    public NotificationModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyChange();
    }

    public String getDate() {
        return date;

    }

    public void setDate(String date) {
        this.date = date;
        notifyChange();
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
        notifyChange();
    }

    public NotificationModel(String message, String date, String colorCode) {
        this.message = message;
        this.date = date;
        this.colorCode = colorCode;
    }
}
