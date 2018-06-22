package com.example.ptut.padc_simplehabit_one.mvp.views;

import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.example.ptut.padc_simplehabit_one.mvp.views.base.BaseView;

import java.util.List;

public interface TopicView extends BaseView {
    void getAllTopicData(List<TopicVO> topicVOS);
}
