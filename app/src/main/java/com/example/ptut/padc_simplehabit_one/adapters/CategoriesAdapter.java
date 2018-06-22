package com.example.ptut.padc_simplehabit_one.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptut.padc_simplehabit_one.controllers.ItemClickListener;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.adapters.base.BaseRecyclerAdapter;
import com.example.ptut.padc_simplehabit_one.viewholders.CategoryItemsViewHolder;


public class CategoriesAdapter extends BaseRecyclerAdapter<CategoryItemsViewHolder, ProgramVO> {

    Context context;
    ItemClickListener clickListener;


    public CategoriesAdapter(Context context,ItemClickListener clickListener) {
        super(context);
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.clickListener=clickListener;
    }

    @Override
    public CategoryItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.activity_meditation_item, parent, false);
        return new CategoryItemsViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemsViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }
}

