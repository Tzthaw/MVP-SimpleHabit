package com.example.ptut.padc_simplehabit_one.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.example.ptut.padc_simplehabit_one.controllers.ItemClickListener;
import com.example.ptut.padc_simplehabit_one.viewholders.AllTopicsItemViewHolder;
import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.HomeScreenVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.viewholders.CategoriesViewHolder;
import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.viewholders.CurrentViewHolder;
import com.example.ptut.padc_simplehabit_one.adapters.base.BaseRecyclerAdapter;
import com.example.ptut.padc_simplehabit_one.viewholders.base.BaseViewHolder;

public class SeriesNewAdapter extends BaseRecyclerAdapter<BaseViewHolder,HomeScreenVO> {

    private  final int START_VIEW = 1;
    private final int MORNING_VIEW = 2;
    private final int ALLTOPIC_VIEW = 4;

    ItemClickListener clickListener;

    public SeriesNewAdapter(Context context,ItemClickListener clickListener) {
        super(context);
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder vh = null;
        if(viewType==START_VIEW){
            View v=mLayoutInflater.inflate(R.layout.layout_start,parent,false);
            vh= new CurrentViewHolder(v,clickListener);
        }else if(viewType==MORNING_VIEW){
            View v=mLayoutInflater.inflate(R.layout.layout_recycler_meditation,parent,false);
           vh= new CategoriesViewHolder(v,clickListener);
        }else if(viewType==ALLTOPIC_VIEW){
            View v=mLayoutInflater.inflate(R.layout.activity_topic_item,parent,false);
           vh= new AllTopicsItemViewHolder(v);
        }
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if(mData.get(position) instanceof CurrentProgramVO){
            return START_VIEW;
        }else if(mData.get(position) instanceof CategoriesProgramVO){
            return MORNING_VIEW;
        }else if(mData.get(position) instanceof TopicVO){
            return ALLTOPIC_VIEW;
        }
           return MORNING_VIEW;
        
    }
}
