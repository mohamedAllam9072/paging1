package com.example.paging1.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {
    @Expose
    @SerializedName("content_license")
    private String content_license;
    @Expose
    @SerializedName("question_id")
    private int question_id;
    @Expose
    @SerializedName("answer_id")
    private int answer_id;
    @Expose
    @SerializedName("creation_date")
    private int creation_date;
    @Expose
    @SerializedName("last_edit_date")
    private int last_edit_date;
    @Expose
    @SerializedName("last_activity_date")
    private int last_activity_date;
    @Expose
    @SerializedName("score")
    private int score;
    @Expose
    @SerializedName("is_accepted")
    private boolean is_accepted;
    @Expose
    @SerializedName("owner")
    private Owner owner;

    public String getContent_license() {
        return content_license;
    }

    public void setContent_license(String content_license) {
        this.content_license = content_license;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public int getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(int creation_date) {
        this.creation_date = creation_date;
    }

    public int getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(int last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public int getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(int last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getIs_accepted() {
        return is_accepted;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
