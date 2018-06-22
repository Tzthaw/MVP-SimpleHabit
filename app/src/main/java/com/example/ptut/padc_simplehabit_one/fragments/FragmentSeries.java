package com.example.ptut.padc_simplehabit_one.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.activities.MainActivity;
import com.example.ptut.padc_simplehabit_one.adapters.SeriesNewAdapter;
import com.example.ptut.padc_simplehabit_one.controllers.EmptyClickListener;
import com.example.ptut.padc_simplehabit_one.controllers.ItemClickListener;
import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.HomeScreenVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.example.ptut.padc_simplehabit_one.datas.views.EmptyLayout;
import com.example.ptut.padc_simplehabit_one.fragments.base.BaseFragment;
import com.example.ptut.padc_simplehabit_one.models.CurrentProgramModel;
import com.example.ptut.padc_simplehabit_one.mvp.presenters.CategoryPresenter;
import com.example.ptut.padc_simplehabit_one.mvp.presenters.CurrentPresenter;
import com.example.ptut.padc_simplehabit_one.mvp.presenters.SeriesDetailsPresenter;
import com.example.ptut.padc_simplehabit_one.mvp.presenters.TopicPresenter;
import com.example.ptut.padc_simplehabit_one.mvp.views.CategoryView;
import com.example.ptut.padc_simplehabit_one.mvp.views.CurrentView;
import com.example.ptut.padc_simplehabit_one.mvp.views.SeriesView;
import com.example.ptut.padc_simplehabit_one.mvp.views.TopicView;
import com.example.ptut.padc_simplehabit_one.shared.SmartRecyclerView;
import com.example.ptut.padc_simplehabit_one.shared.UtilsHttp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentSeries extends BaseFragment implements CurrentView,CategoryView,TopicView,SeriesView{

    @BindView(R.id.series_recycler)
    SmartRecyclerView seriesRecycler;
    @BindView(R.id.empty_layout)
    EmptyLayout emptyLayout;

    SeriesNewAdapter seriesAdapter;

    EmptyClickListener emptyClickListener;
    List<HomeScreenVO> homeScreenVOS;
    CurrentPresenter currentPresenter;
    CategoryPresenter categoryPresenter;
    TopicPresenter topicPresenter;
    SeriesDetailsPresenter detailsPresenter;

    public static FragmentSeries newInstance() {
        Bundle args = new Bundle();
        FragmentSeries fragment = new FragmentSeries();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_series, container, false);
        ButterKnife.bind(this, v);

        homeScreenVOS=new ArrayList<>();
        currentPresenter=new CurrentPresenter(this);
        categoryPresenter=new CategoryPresenter(this);
        topicPresenter=new TopicPresenter(this);


        if(UtilsHttp.isNetworkAvailable(getContext())){
            currentPresenter.onCreate();

        }else{
            Toast.makeText(getContext(),"No Internet Connection",Toast.LENGTH_SHORT).show();
        }


        detailsPresenter.onCreate();


        emptyLayout.bindData(emptyClickListener);
        seriesRecycler.setEmptyView(emptyLayout);
        seriesRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        seriesAdapter=new SeriesNewAdapter(getContext(),detailsPresenter);
        seriesRecycler.setAdapter(seriesAdapter);

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        emptyClickListener=(EmptyClickListener)context;
        detailsPresenter=new SeriesDetailsPresenter((MainActivity)context);
    }

    @Override
    public void getCurrentProgramData(CurrentProgramVO programVO) {
        homeScreenVOS.add(programVO);
        categoryPresenter.onCreate();
    }

    @SuppressLint("ShowToast")
    @Override
    public void displayErrorMsg(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT);
    }

    @Override
    public void getCategoryData(List<CategoriesProgramVO> categoriesProgramVOS) {
        homeScreenVOS.addAll(categoriesProgramVOS);
        topicPresenter.onCreate();
    }

    @Override
    public void getAllTopicData(List<TopicVO> topicVOS) {
        homeScreenVOS.addAll(topicVOS);
        seriesAdapter.setNewData(homeScreenVOS);
    }

    @Override
    public void getTabCurrentItem(CurrentProgramVO currentProgramVO, ImageView imageView) {

    }

    @Override
    public void getTabCategoryItem(ProgramVO programVO, ImageView imageView) {

    }

    @Override
    public void displayCurrentData(CurrentProgramVO currentProgramVO) {

    }

    @Override
    public void displayCategoryData(ProgramVO programVO) {

    }
}
