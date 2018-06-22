package com.example.ptut.padc_simplehabit_one.controllers;

import android.widget.ImageView;

import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;

public interface ItemClickListener {
    void onCategoryItemClick(ProgramVO programVO, ImageView imageView);
    void onCurrentItemClick(CurrentProgramVO programVO, ImageView imageView);
}
