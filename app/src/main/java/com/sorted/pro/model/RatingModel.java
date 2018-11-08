package com.sorted.pro.model;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RatingModel extends BaseObservable {

    private String name;
    private String description;
    private int rate;
    private String subject;
    @NotNull
    private ArrayList<RatingParameters> mRatingParameters;

    public RatingModel(String name, String description, int rate, String subject, @NonNull ArrayList<RatingParameters> mRatingParameters) {
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.subject = subject;
        this.mRatingParameters = mRatingParameters;
    }

    public RatingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyChange();
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
        notifyChange();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
        notifyChange();
    }

    public ArrayList<RatingParameters> getRatingParameters() {
        return mRatingParameters;
    }

    public void setRatingParameters(ArrayList<RatingParameters> ratingParameters) {
        mRatingParameters = ratingParameters;
        notifyChange();
    }
}
