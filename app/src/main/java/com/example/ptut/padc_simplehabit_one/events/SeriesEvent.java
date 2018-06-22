package com.example.ptut.padc_simplehabit_one.events;

import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.HomeScreenVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;

import java.util.List;

public class SeriesEvent {

    public static class CurrentProgramEvent{
        CurrentProgramVO currentProgramVO;

        public CurrentProgramEvent(CurrentProgramVO currentProgramVO) {
            this.currentProgramVO = currentProgramVO;
        }

        public CurrentProgramVO getCurrentProgramVO() {
            return currentProgramVO;
        }

    }
    public static class CurrentDataEvent{
        CurrentProgramVO currentProgramVO;

        public CurrentDataEvent(CurrentProgramVO currentProgramVO) {
            this.currentProgramVO = currentProgramVO;
        }

        public CurrentProgramVO getCurrentProgramVO() {
            return currentProgramVO;
        }

    }

    public static class CategoriesProgramEvent{
     List<CategoriesProgramVO> categoriesProgramVOS;

        public CategoriesProgramEvent(List<CategoriesProgramVO> categoriesProgramVOS) {
            this.categoriesProgramVOS = categoriesProgramVOS;
        }

        public List<CategoriesProgramVO> getCategoriesProgramVOS() {
            return categoriesProgramVOS;
        }


    }

    public static class AllTopicsEvent{
      List<TopicVO> topicsItems;

        public AllTopicsEvent(List<TopicVO> topicsItems) {
            this.topicsItems = topicsItems;
        }

        public List<TopicVO> getTopicsItems() {
            return topicsItems;
        }

    }

    public static class HomeScreenEvent{
        List<HomeScreenVO> homeScreenVOS;

        public HomeScreenEvent(List<HomeScreenVO> homeScreenVOS) {
            this.homeScreenVOS = homeScreenVOS;
        }

        public List<HomeScreenVO> getHomeScreenVOS() {
            return homeScreenVOS;
        }


    }

    public static class ProgramEvent{
        ProgramVO programVO;

        public ProgramEvent(ProgramVO programVO) {
            this.programVO = programVO;
        }

        public ProgramVO getProgramVO() {
            return programVO;
        }
    }


    public static class ErrorEvent{
        String msg;

        public ErrorEvent(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

    }

    public static class NetworkErrorEvent{
        String msg;

        public NetworkErrorEvent(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

}
