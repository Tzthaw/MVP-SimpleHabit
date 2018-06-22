package com.example.ptut.padc_simplehabit_one.mvp.presenters;

import android.widget.ImageView;

import com.example.ptut.padc_simplehabit_one.controllers.ItemClickListener;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.HomeScreenVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.events.SeriesEvent;
import com.example.ptut.padc_simplehabit_one.models.CurrentProgramModel;
import com.example.ptut.padc_simplehabit_one.mvp.presenters.base.BasePresenter;
import com.example.ptut.padc_simplehabit_one.mvp.views.SeriesView;
import com.example.ptut.padc_simplehabit_one.shared.Constant;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SeriesDetailsPresenter extends BasePresenter<SeriesView> implements ItemClickListener{
    public SeriesDetailsPresenter(SeriesView view) {
        super(view);
    }

    public boolean onFinishSetup(String from, String id){
        boolean check = from.equalsIgnoreCase(Constant.PROGRAM_ID);
        CurrentProgramModel currentProgramModel = CurrentProgramModel.getInstance();
        if (check) {
            view.displayCategoryData(currentProgramModel.loadProgramData(id));

        } else {
            view.displayCurrentData(currentProgramModel.loadCurrentData());
        }
        return check;
    }

    @Override
    public void onCategoryItemClick(ProgramVO programVO, ImageView imageView) {
        view.getTabCategoryItem(programVO,imageView);
    }

    @Override
    public void onCurrentItemClick(CurrentProgramVO programVO, ImageView imageView) {
        view.getTabCurrentItem(programVO,imageView);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void onStart(){
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }
    public void onStop(){
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Subscribe
    public void onErrorEvent(SeriesEvent.ErrorEvent errorEvent){

    }
}
