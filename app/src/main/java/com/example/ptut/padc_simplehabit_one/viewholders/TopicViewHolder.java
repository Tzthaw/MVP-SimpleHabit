package com.example.ptut.padc_simplehabit_one.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.example.ptut.padc_simplehabit_one.viewholders.base.BaseViewHolder;

import butterknife.BindView;

public class TopicViewHolder extends BaseViewHolder<TopicVO> {

    @BindView(R.id.topic_item_bg)
    ImageView topicItemBgImg;
    @BindView(R.id.topic_item_icon)
    ImageView topicItemIcon;
    @BindView(R.id.topic_item_title)
    TextView topicItemTitle;
    @BindView(R.id.topic_item_discuss)
    TextView topicItemDiscuss;
    TopicVO topicItem;


    public TopicViewHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void bind(TopicVO data) {
        topicItem = data;
        Glide.with(itemView.getContext())
                .load(data.getBackgroundImg())
                .into(topicItemBgImg);

        Glide.with(itemView.getContext())
                .load(data.getImage())
                .into(topicItemIcon);

        topicItemTitle.setText(data.getTopicName());
        topicItemDiscuss.setText(data.getTopicDesc());
    }

    @Override
    public void onClick(View v) {
    }
}
