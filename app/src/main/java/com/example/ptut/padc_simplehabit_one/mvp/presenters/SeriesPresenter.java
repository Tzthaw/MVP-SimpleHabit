package com.example.ptut.padc_simplehabit_one.mvp.presenters;

import com.example.ptut.padc_simplehabit_one.datas.entities.HomeScreenVO;
import com.example.ptut.padc_simplehabit_one.events.SeriesEvent;
import com.example.ptut.padc_simplehabit_one.models.CurrentProgramModel;
import com.example.ptut.padc_simplehabit_one.mvp.presenters.base.BasePresenter;
import com.example.ptut.padc_simplehabit_one.mvp.views.HomeScreenView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class SeriesPresenter extends BasePresenter<HomeScreenView> {

    List<HomeScreenVO> homeScreenVOS;

    public SeriesPresenter(HomeScreenView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CurrentProgramModel.getInstance().loadCurrentProgramData();
        homeScreenVOS = new ArrayList<>();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCurrentProgramLoadEvent(SeriesEvent.CurrentProgramEvent event) {
        if (event.getCurrentProgramVO() != null)
            homeScreenVOS.add(event.getCurrentProgramVO());
        CurrentProgramModel.getInstance().loadCategoriesData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCategoryDataLoaded(SeriesEvent.CategoriesProgramEvent event) {
        if (event.getCategoriesProgramVOS() != null)
            homeScreenVOS.addAll(event.getCategoriesProgramVOS());
        CurrentProgramModel.getInstance().loadTopicsData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAllTopicLoadedEvent(SeriesEvent.AllTopicsEvent event) {
        if (event.getTopicsItems() != null)
            homeScreenVOS.addAll(event.getTopicsItems());
        view.displayAllDatas(homeScreenVOS);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorLoadedEvent(SeriesEvent.NetworkErrorEvent errorEvent) {
        view.displayErrorMsg(errorEvent.getMsg());
    }
}
