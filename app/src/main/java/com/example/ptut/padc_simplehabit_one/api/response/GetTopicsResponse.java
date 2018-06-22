package com.example.ptut.padc_simplehabit_one.api.response;

import com.example.ptut.padc_simplehabit_one.api.response.base.BaseResponse;
import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTopicsResponse extends BaseResponse {


    @SerializedName("page")
    private String page;
    @SerializedName("topics")
    private List<TopicVO> topicVOS;

    public GetTopicsResponse() {

    }


    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<TopicVO> getTopicVOS() {
        return topicVOS;
    }
}
