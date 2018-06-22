package com.example.ptut.padc_simplehabit_one.mvp.presenters;

import com.example.ptut.padc_simplehabit_one.events.SeriesEvent;
import com.example.ptut.padc_simplehabit_one.models.CurrentProgramModel;
import com.example.ptut.padc_simplehabit_one.mvp.presenters.base.BasePresenter;
import com.example.ptut.padc_simplehabit_one.mvp.views.TopicView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class TopicPresenter extends BasePresenter<TopicView> {
    public TopicPresenter(TopicView view) {
        super(view);
    }
    @Override
    public void onCreate(){
        super.onCreate();
        CurrentProgramModel.getInstance().loadTopicsData();
    }
    @Override
    public void onStop(){
        super.onStop();
    }
    @Override
    public void onStart(){
        super.onStart();
    }
    @Override
    public void onPause(){
        super.onPause();
    }
    @Override
    public void onResume(){
        super.onResume();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAllTopicLoadedEvent(SeriesEvent.AllTopicsEvent event){
        view.getAllTopicData(event.getTopicsItems());
    }

}
