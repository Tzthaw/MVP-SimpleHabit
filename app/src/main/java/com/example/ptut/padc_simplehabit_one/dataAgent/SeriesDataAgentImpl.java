package com.example.ptut.padc_simplehabit_one.dataAgent;

import com.example.ptut.padc_simplehabit_one.api.SimpleHabitService;
import com.example.ptut.padc_simplehabit_one.api.response.GetCategoriesResponse;
import com.example.ptut.padc_simplehabit_one.api.response.GetCurrentProgramResponse;
import com.example.ptut.padc_simplehabit_one.api.response.GetTopicsResponse;
import com.example.ptut.padc_simplehabit_one.events.SeriesEvent;
import com.example.ptut.padc_simplehabit_one.shared.Constant;
import com.example.ptut.padc_simplehabit_one.shared.UtilsHttp;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeriesDataAgentImpl implements SeriesDataAgent {

    private static SeriesDataAgentImpl seriesDataAgentImpl;
    private SimpleHabitService theApi;


    public static SeriesDataAgentImpl getInstance(){
        if(seriesDataAgentImpl==null){
            seriesDataAgentImpl=new SeriesDataAgentImpl();
        }
        return seriesDataAgentImpl;
    }

    private SeriesDataAgentImpl(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();

        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(UtilsHttp.getSeriesUrl())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();
        theApi=retrofit.create(SimpleHabitService.class);

    }


    @Override
    public void getCurrentProgram(String access_token,int page) {
        Call<GetCurrentProgramResponse> loadData=theApi.getCurrentItem(access_token,page);
        loadData.enqueue(new Callback<GetCurrentProgramResponse>() {
            @Override
            public void onResponse(Call<GetCurrentProgramResponse> call, Response<GetCurrentProgramResponse> response) {
                try {
                    if(response.isSuccessful()){
                        GetCurrentProgramResponse getCurrentProgramResponse =response.body();
                        EventBus.getDefault().post(new SeriesEvent.CurrentProgramEvent(getCurrentProgramResponse.getCurrentProgramVO()));
                    }else{
                        EventBus.getDefault().post(new SeriesEvent.NetworkErrorEvent(Constant.notSuccessmsg));
                    }
                }catch (Exception e){
                    EventBus.getDefault().post(new SeriesEvent.NetworkErrorEvent(e.getMessage()));
                }
            }
            @Override
            public void onFailure(Call<GetCurrentProgramResponse> call, Throwable t) {
                EventBus.getDefault().post(new SeriesEvent.NetworkErrorEvent(t.getMessage()));
            }
        });

    }

    @Override
    public void getCategoriesPrograms(String access_token,int page) {
        Call<GetCategoriesResponse> loadCategories=theApi.getCategoriesPrograms(access_token,page);
        loadCategories.enqueue(new Callback<GetCategoriesResponse>() {
            @Override
            public void onResponse(Call<GetCategoriesResponse> call, Response<GetCategoriesResponse> response) {
                try {
                    if(response.isSuccessful()){
                        GetCategoriesResponse data=response.body();
                        EventBus.getDefault().post(new SeriesEvent.CategoriesProgramEvent(data.getCategoriesProgramVOS()));
                    }else{
                        EventBus.getDefault().post(new SeriesEvent.NetworkErrorEvent(Constant.notSuccessmsg));
                    }
                }catch (Exception e){
                    EventBus.getDefault().post(new SeriesEvent.NetworkErrorEvent(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<GetCategoriesResponse> call, Throwable t) {
                EventBus.getDefault().post(new SeriesEvent.NetworkErrorEvent(t.getMessage()));
            }
        });
    }

    @Override
    public void getTopicsData(String access_token,int page) {
        Call<GetTopicsResponse> loadTopics=theApi.getTopicsData(access_token,page);
        loadTopics.enqueue(new Callback<GetTopicsResponse>() {
            @Override
            public void onResponse(Call<GetTopicsResponse> call, Response<GetTopicsResponse> response) {
                try {
                    if(response.isSuccessful()){
                        GetTopicsResponse data=response.body();

                        EventBus.getDefault().post(new SeriesEvent.AllTopicsEvent(data.getTopicVOS()));
                    }else{
                        EventBus.getDefault().post(new SeriesEvent.NetworkErrorEvent(Constant.notSuccessmsg));
                    }

                }catch (Exception e){
                    EventBus.getDefault().post(new SeriesEvent.NetworkErrorEvent(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<GetTopicsResponse> call, Throwable t) {
                EventBus.getDefault().post(new SeriesEvent.NetworkErrorEvent(t.getMessage()));
            }
        });
    }
}
