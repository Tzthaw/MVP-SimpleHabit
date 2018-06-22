package com.example.ptut.padc_simplehabit_one.api.response;

import com.example.ptut.padc_simplehabit_one.api.response.base.BaseResponse;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.google.gson.annotations.SerializedName;

public class GetCurrentProgramResponse extends BaseResponse {


    @SerializedName("currentProgram")
    CurrentProgramVO currentProgramVO;

    public GetCurrentProgramResponse() {

    }

    public CurrentProgramVO getCurrentProgramVO() {
        return currentProgramVO;
    }

    public void setCurrentProgramVO(CurrentProgramVO currentProgramVO) {
        this.currentProgramVO = currentProgramVO;
    }


}
