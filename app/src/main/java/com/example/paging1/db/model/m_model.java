package com.example.paging1.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class m_model {
    @Expose
    @SerializedName("quota_remaining")
    private int quota_remaining;
    @Expose
    @SerializedName("quota_max")
    private int quota_max;
    @Expose
    @SerializedName("backoff")
    private int backoff;
    @Expose
    @SerializedName("has_more")
    private boolean has_more;
    @Expose
    @SerializedName("items")
    private List<Items> items;

    public int getQuota_remaining() {
        return quota_remaining;
    }

    public void setQuota_remaining(int quota_remaining) {
        this.quota_remaining = quota_remaining;
    }

    public int getQuota_max() {
        return quota_max;
    }

    public void setQuota_max(int quota_max) {
        this.quota_max = quota_max;
    }

    public int getBackoff() {
        return backoff;
    }

    public void setBackoff(int backoff) {
        this.backoff = backoff;
    }

    public boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
