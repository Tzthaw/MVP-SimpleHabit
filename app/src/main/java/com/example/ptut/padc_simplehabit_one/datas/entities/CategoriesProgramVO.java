package com.example.ptut.padc_simplehabit_one.datas.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesProgramVO implements HomeScreenVO {

    @SerializedName("category-id")
    String categoryId;
    @SerializedName("title")
    String title;
    @SerializedName("programs")
    List<ProgramVO> programs;

    public CategoriesProgramVO() {

    }


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProgramVO> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramVO> programs) {
        this.programs = programs;
    }
}


