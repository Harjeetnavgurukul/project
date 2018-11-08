package com.sorted.pro.model;

import android.databinding.BaseObservable;

public class RatingParameters extends BaseObservable {

    private String parameterTitle;
    private int value;

    public RatingParameters(String parameterTitle, int value) {
        this.parameterTitle = parameterTitle;
        this.value = value;
    }

    public String getParameterTitle() {
        return parameterTitle;
    }

    public void setParameterTitle(String parameterTitle) {
        this.parameterTitle = parameterTitle;
        notifyChange();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyChange();
    }
}
