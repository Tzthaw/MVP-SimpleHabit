package com.example.ptut.padc_simplehabit_one.datas.entities;

import com.google.gson.annotations.SerializedName;

public class SessionVO {

    @SerializedName("session-id")
    String sessionId;
    @SerializedName("title")
    String title;
    @SerializedName("length-in-seconds")
    int LengthTime;
    @SerializedName("file-path")
    String filePath;

    public SessionVO(String sessionId, String title, int lengthTime, String filePath) {
        this.sessionId = sessionId;
        this.title = title;
        LengthTime = lengthTime;
        this.filePath = filePath;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLengthTime() {
        return LengthTime;
    }

    public void setLengthTime(int lengthTime) {
        LengthTime = lengthTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
