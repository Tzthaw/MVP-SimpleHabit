package com.example.ptut.padc_simplehabit_one.dataAgent;

public interface SeriesDataAgent {
    void getCurrentProgram(String access_token,int page);
    void getCategoriesPrograms(String access_token,int page);
    void getTopicsData(String access_token,int page);
}
