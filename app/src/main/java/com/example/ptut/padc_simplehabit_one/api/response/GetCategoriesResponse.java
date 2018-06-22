package com.example.ptut.padc_simplehabit_one.api.response;

import com.example.ptut.padc_simplehabit_one.api.response.base.BaseResponse;
import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCategoriesResponse extends BaseResponse {


    @SerializedName("page")
    private String page;
    @SerializedName("categoriesPrograms")
    private List<CategoriesProgramVO> categoriesProgramVOS;

    public GetCategoriesResponse() {
    }



    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<CategoriesProgramVO> getCategoriesProgramVOS() {
        return categoriesProgramVOS;
    }

    public void setCategoriesProgramVOS(List<CategoriesProgramVO> categoriesProgramVOS) {
        this.categoriesProgramVOS = categoriesProgramVOS;
    }
}
