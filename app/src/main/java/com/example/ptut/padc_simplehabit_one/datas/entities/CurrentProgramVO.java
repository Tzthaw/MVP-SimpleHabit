package com.example.ptut.padc_simplehabit_one.datas.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentProgramVO implements HomeScreenVO{
    @SerializedName("program-id")
    private
    String programId;
    @SerializedName("title")
    private
    String title;
    @SerializedName("current_period")
    private
    String currentPeriod;
    @SerializedName("background")
    private
    String Background;
    @SerializedName("average-lengths")
    private
    int[] avgLength;
    @SerializedName("description")
    private
    String description;
    @SerializedName("sessions")
    private
    List<SessionVO> sessions;

    public CurrentProgramVO() {

    }


    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public String getBackground() {
        return Background+"www.oho.com/sites/default/files/styles/large_photo__960w_/public/insights/rocket-night.jpg?itok=i0kFPmO_";
    }

    public void setBackground(String background) {
        Background = background;
    }

    public int[] getAvgLength() {
        return avgLength;
    }

    public void setAvgLength(int[] avgLength) {
        this.avgLength = avgLength;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SessionVO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionVO> sessions) {
        this.sessions = sessions;
    }
}
