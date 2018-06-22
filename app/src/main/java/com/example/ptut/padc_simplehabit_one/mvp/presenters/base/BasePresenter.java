package com.example.ptut.padc_simplehabit_one.mvp.presenters.base;

import com.example.ptut.padc_simplehabit_one.mvp.views.base.BaseView;

import org.greenrobot.eventbus.EventBus;


public abstract class BasePresenter<T extends BaseView> {

    protected T view;

    public BasePresenter(T view) {
        this.view = view;
    }

    public void onCreate(){
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    public void onStop(){
        if(EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }

    public void onStart(){

    }

    public void onPause(){

    }

    public void onResume(){

    }

    public void onDestroy(){

    }
}
