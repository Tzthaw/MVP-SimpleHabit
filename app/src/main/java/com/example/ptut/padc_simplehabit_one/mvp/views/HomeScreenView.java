package com.example.ptut.padc_simplehabit_one.mvp.views;

import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.HomeScreenVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.example.ptut.padc_simplehabit_one.mvp.views.base.BaseView;

import java.util.List;

public interface HomeScreenView extends BaseView {
    void displayAllDatas(List<HomeScreenVO> homeScreenVOS);
}
