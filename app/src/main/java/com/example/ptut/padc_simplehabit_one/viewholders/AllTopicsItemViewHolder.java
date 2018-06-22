package com.example.ptut.padc_simplehabit_one.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.example.ptut.padc_simplehabit_one.viewholders.base.BaseViewHolder;

import butterknife.BindView;

public class AllTopicsItemViewHolder extends BaseViewHolder<TopicVO> {

    @BindView(R.id.topic_item_bg)
    ImageView topicItemBgImg;
    @BindView(R.id.topic_item_icon)
    ImageView topicItemIcon;
    @BindView(R.id.topic_item_title)
    TextView topicItemTitle;
    @BindView(R.id.topic_item_discuss)
    TextView topicItemDiscuss;


    public AllTopicsItemViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void bind(TopicVO data) {
        Glide.with(itemView.getContext())
                .load(data.getBackgroundImg()
                        +"wallpaperstudio10.com/static/wpdb/wallpapers/1000x563/170101.jpg")
                .into(topicItemBgImg);
        Glide.with(itemView.getContext())
                .load(data.getImage()
                        +"raw.githubusercontent.com/snwh/paper-icon-theme/master/Paper/512x512/mimetypes/audio-x-generic.png")
                .into(topicItemIcon);
        topicItemTitle.setText(data.getTopicName());
        topicItemDiscuss.setText(data.getTopicDesc());
    }
}
