package com.example.ptut.padc_simplehabit_one.shared;

public class UtilsGeneral {

    public static String timeFormat(int second){
        String time = null;
        int minute=second%60;
        int hour=second/60;
        return hour+":"+ minute;
    }


}
