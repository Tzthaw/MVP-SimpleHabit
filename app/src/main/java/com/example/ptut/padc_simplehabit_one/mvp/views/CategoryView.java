package com.example.ptut.padc_simplehabit_one.mvp.views;

import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.example.ptut.padc_simplehabit_one.mvp.views.base.BaseView;

import java.util.List;

public interface CategoryView extends BaseView {
    void getCategoryData(List<CategoriesProgramVO> categoriesProgramVOS);
}
