package com.example.ptut.padc_simplehabit_one.datas.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.CalendarView;
import android.widget.RelativeLayout;

import com.example.ptut.padc_simplehabit_one.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPodCalendar extends RelativeLayout {

    @BindView(R.id.history_calendar)
    CalendarView historyCalendarView;

    public ViewPodCalendar(Context context) {
        super(context);
    }

    public ViewPodCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPodCalendar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }


    public void setData(){


    }
}
