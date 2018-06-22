package com.example.ptut.padc_simplehabit_one.datas.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ptut.padc_simplehabit_one.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPodUserProfile extends LinearLayout{

    @BindView(R.id.text_total_session)
    TextView totalSessionTxt;
    @BindView(R.id.text_total_minute)
    TextView totalMinTxt;
    @BindView(R.id.text_day_streak)
    TextView dayStreakTxt;

    public ViewPodUserProfile(Context context) {
        super(context);
    }

    public ViewPodUserProfile(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPodUserProfile(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
        totalSessionTxt.setText("4");
        totalMinTxt.setText("9");
        dayStreakTxt.setText("5");
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setData(){

    }
}
