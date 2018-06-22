package com.example.ptut.padc_simplehabit_one.mvp.views;

import android.widget.ImageView;

import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.mvp.views.base.BaseView;

public interface CurrentView extends BaseView{
    void getCurrentProgramData(CurrentProgramVO programVO);
}
