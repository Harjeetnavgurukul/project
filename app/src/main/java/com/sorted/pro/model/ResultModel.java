package com.sorted.pro.model;

import android.databinding.BaseObservable;

public class ResultModel extends BaseObservable {
    private double percentage;
    private String subjectName;
    private String scheduledDate;
    private double obtainedMarks;
    private double totalMarks;
    private String testSeriesNumber;
    private String status;
    public ResultModel() {

    }

//    public ResultModel(double percentage, String subjectName, String scheduledDate, double obtainedMarks, double totalMarks) {
//        this.percentage = percentage;
//        this.subjectName = subjectName;
//        this.scheduledDate = scheduledDate;
//        this.obtainedMarks = obtainedMarks;
//        this.totalMarks = totalMarks;
//    }

    public ResultModel(String subjectName, String scheduledDate, double obtainedMarks, double totalMarks, String testSeriesNumber, String status) {
        this.subjectName = subjectName;
        this.scheduledDate = scheduledDate;
        this.obtainedMarks = obtainedMarks;
        this.totalMarks = totalMarks;
        this.testSeriesNumber = testSeriesNumber;
        this.status = status;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public double getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(double obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getTestSeriesNumber() {
        return testSeriesNumber;
    }

    public void setTestSeriesNumber(String testSeriesNumber) {
        this.testSeriesNumber = testSeriesNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
