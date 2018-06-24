package com.example.ptut.padc_simplehabit_one.mvp.views;

import android.widget.ImageView;

import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.mvp.views.base.BaseView;

public interface SeriesDetailView extends BaseView {
    void getTabCurrentItem(CurrentProgramVO currentProgramVO, ImageView imageView);
    void getTabCategoryItem(ProgramVO programVO, ImageView imageView);
    void displayCurrentData(CurrentProgramVO currentProgramVO);
    void displayCategoryData(ProgramVO programVO);
}
