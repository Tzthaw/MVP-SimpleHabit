package com.example.ptut.padc_simplehabit_one.models;

import android.content.Context;

import com.example.ptut.padc_simplehabit_one.dataAgent.SeriesDataAgentImpl;
import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.HomeScreenVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.example.ptut.padc_simplehabit_one.events.SeriesEvent;
import com.example.ptut.padc_simplehabit_one.models.base.BaseModel;
import com.example.ptut.padc_simplehabit_one.shared.Constant;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CurrentProgramModel extends BaseModel {


    private static CurrentProgramModel currentProgramModel;
    private Context context;
    private SeriesDataAgentImpl seriesDataAgentImpl;
    private List<HomeScreenVO> homeScreenVOS = new ArrayList<>();
    private List<CategoriesProgramVO> categoryList;
    private CurrentProgramVO currentProgramVO;

    //Maps
    private Map<String, CurrentProgramVO> currentMap;
    private Map<String, CategoriesProgramVO> categoriesMap;
    private Map<String, TopicVO> topicMap;


    private CurrentProgramModel() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        seriesDataAgentImpl = SeriesDataAgentImpl.getInstance();

        currentMap = new HashMap<>();
        categoriesMap = new HashMap<>();
        topicMap = new HashMap<>();
    }

    public static CurrentProgramModel getInstance() {
        if (currentProgramModel == null) {
            currentProgramModel = new CurrentProgramModel();
        }
        return currentProgramModel;
    }

    public void loadCurrentProgramData() {
        seriesDataAgentImpl.getCurrentProgram(Constant.access_token, Constant.page);
    }

    public void loadCategoriesData() {
        seriesDataAgentImpl.getCategoriesPrograms(Constant.access_token, Constant.page);
    }
    public void loadTopicsData() {
        seriesDataAgentImpl.getTopicsData(Constant.access_token, Constant.page);
    }

    public CurrentProgramVO loadCurrentData() {
        return currentProgramVO;
    }

    public ProgramVO loadProgramData(String programId) {
        for (CategoriesProgramVO vo : categoryList) {
            for (ProgramVO voprogram : vo.getPrograms()) {
                if (voprogram.getProgramId().equalsIgnoreCase(programId)) {
                    return voprogram;
                }
            }
        }
        return null;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCurrentProgramEvent(SeriesEvent.CurrentProgramEvent event) {
        currentProgramVO = new CurrentProgramVO();
        if (seriesDataAgentImpl == null) {
            seriesDataAgentImpl = SeriesDataAgentImpl.getInstance();
        }
        currentProgramVO = event.getCurrentProgramVO();
        currentMap.put(Constant.CURRENT_PROGRAM, currentProgramVO);


    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void OnCategoriesEvent(SeriesEvent.CategoriesProgramEvent event) {
        if (seriesDataAgentImpl == null) {
            seriesDataAgentImpl = SeriesDataAgentImpl.getInstance();
        }
        categoryList = event.getCategoriesProgramVOS();
        for (CategoriesProgramVO categoriesProgramVO : categoryList) {
            categoriesMap.put(categoriesProgramVO.getCategoryId(), categoriesProgramVO);
        }

    }


    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onTopicItemEvent(SeriesEvent.AllTopicsEvent event) {
            for (TopicVO topicVO : event.getTopicsItems()) {
                topicMap.put(Constant.TOPIC, topicVO);
            }
    }




}
