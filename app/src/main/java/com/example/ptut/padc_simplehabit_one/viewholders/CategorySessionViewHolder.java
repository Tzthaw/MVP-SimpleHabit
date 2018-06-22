package com.example.ptut.padc_simplehabit_one.viewholders;

import android.view.View;
import android.widget.TextView;

import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.datas.entities.SessionVO;
import com.example.ptut.padc_simplehabit_one.shared.UtilsGeneral;
import com.example.ptut.padc_simplehabit_one.viewholders.base.BaseViewHolder;

import butterknife.BindView;

public class CategorySessionViewHolder extends BaseViewHolder<SessionVO> {

    @BindView(R.id.session_id)
    TextView sessionId;
    @BindView(R.id.session_desc)
    TextView sessionDesc;
    @BindView(R.id.session_time)
    TextView sessionTime;

    public CategorySessionViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(SessionVO data) {
        sessionId.setText(data.getSessionId());
        sessionDesc.setText(data.getTitle());
        sessionTime.setText(UtilsGeneral.timeFormat(data.getLengthTime()));
    }

    @Override
    public void onClick(View v) {

    }
}
