package com.example.ptut.padc_simplehabit_one.api;

import com.example.ptut.padc_simplehabit_one.api.response.GetCategoriesResponse;
import com.example.ptut.padc_simplehabit_one.api.response.GetCurrentProgramResponse;
import com.example.ptut.padc_simplehabit_one.api.response.GetTopicsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SimpleHabitService {

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<GetCurrentProgramResponse> getCurrentItem(@Field("access_token") String access_token,
                                                   @Field("page") int page);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<GetCategoriesResponse> getCategoriesPrograms(@Field("access_token") String access_token, @Field("page") int page);

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<GetTopicsResponse> getTopicsData(@Field("access_token") String access_token, @Field("page") int page);


}
