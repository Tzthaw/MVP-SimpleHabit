package com.example.ptut.padc_simplehabit_one.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.adapters.base.BaseRecyclerAdapter;
import com.example.ptut.padc_simplehabit_one.datas.entities.SessionVO;
import com.example.ptut.padc_simplehabit_one.viewholders.CategorySessionViewHolder;

public class CategorySessionAdapter extends BaseRecyclerAdapter<CategorySessionViewHolder,SessionVO> {



    public CategorySessionAdapter(Context context) {
        super(context);
        mLayoutInflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CategorySessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.view_category_session_items,parent,false);
        return new CategorySessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorySessionViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }
}
