package com.example.ptut.padc_simplehabit_one.datas.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.controllers.EmptyClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmptyLayout extends LinearLayout implements View.OnClickListener{

    @BindView(R.id.empty_text)
    TextView emptyText;
    Context context;
    EmptyClickListener onEmptyClickListener;

    public EmptyLayout(Context context) {
        super(context);
        this.context=context;


    }

    public EmptyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    public EmptyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
        emptyText.setText("No Data");
        setOnClickListener(this);
    }

    public void bindData(EmptyClickListener onEmptyClickListener) {
        this.onEmptyClickListener=onEmptyClickListener;
    }


    @Override
    public void onClick(View v) {
        onEmptyClickListener.onEmptyClick();
    }
}
