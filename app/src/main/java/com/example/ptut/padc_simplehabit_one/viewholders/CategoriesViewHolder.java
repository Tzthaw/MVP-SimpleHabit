package com.example.ptut.padc_simplehabit_one.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.adapters.CategoriesAdapter;
import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.example.ptut.padc_simplehabit_one.controllers.ItemClickListener;
import com.example.ptut.padc_simplehabit_one.viewholders.base.BaseViewHolder;

import butterknife.BindView;

public class CategoriesViewHolder extends BaseViewHolder<CategoriesProgramVO> {

    @BindView(R.id.meditationview_recycler)
    RecyclerView meditationRecycler;

    @BindView(R.id.meditation_title)
    TextView meditationTitle;

    CategoriesAdapter categoriesAdapter;
    ItemClickListener clickListener;
    CategoriesProgramVO categoriesProgramVO;

    public CategoriesViewHolder(View itemView, ItemClickListener clickListener) {
        super(itemView);
        this.clickListener=clickListener;
        categoriesAdapter =new CategoriesAdapter(itemView.getContext(),clickListener);
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void bind(CategoriesProgramVO data) {
        categoriesProgramVO=data;
        meditationTitle.setText(data.getTitle());
        categoriesAdapter.setNewData(data.getPrograms());
        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        meditationRecycler.setLayoutManager(layoutManager);
        meditationRecycler.setAdapter(categoriesAdapter);
    }
}
