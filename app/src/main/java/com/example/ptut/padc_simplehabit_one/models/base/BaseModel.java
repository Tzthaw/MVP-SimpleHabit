package com.example.ptut.padc_simplehabit_one.models.base;

import com.example.ptut.padc_simplehabit_one.events.SeriesEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public abstract class BaseModel {



    public BaseModel() {
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }



    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent(SeriesEvent.ErrorEvent event) {

    }
}
