package com.example.ptut.padc_simplehabit_one.datas.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProgramVO {

    @SerializedName("program-id")
    String programId;
    @SerializedName("title")
    String title;
    @SerializedName("image")
    String image;
    @SerializedName("average-lengths")
    int[] avgLength;
    @SerializedName("description")
    String description;
    @SerializedName("sessions")
    List<SessionVO> sessions;

    public ProgramVO() {

    }

    public ProgramVO(String programId) {
        this.programId = programId;
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

    public String getImage() {
        return image+"theultralinx.com/.image/c_limit%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_620/MTI5MDI0MjY3MjM2MTg2NTkw/materialdesign7.jpg";
    }

    public void setImage(String image) {
        this.image = image;
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
