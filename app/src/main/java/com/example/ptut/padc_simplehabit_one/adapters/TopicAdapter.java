package com.example.ptut.padc_simplehabit_one.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.adapters.base.BaseRecyclerAdapter;
import com.example.ptut.padc_simplehabit_one.viewholders.TopicViewHolder;


public class TopicAdapter extends BaseRecyclerAdapter<TopicViewHolder,TopicVO> {

    public TopicAdapter(Context context) {
        super(context);

    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.activity_topic_item,parent,false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }
}
