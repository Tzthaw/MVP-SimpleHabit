package com.example.ptut.padc_simplehabit_one.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.activities.base.BaseActivity;
import com.example.ptut.padc_simplehabit_one.adapters.CategorySessionAdapter;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.models.CurrentProgramModel;
import com.example.ptut.padc_simplehabit_one.mvp.presenters.SeriesDetailsPresenter;
import com.example.ptut.padc_simplehabit_one.mvp.views.SeriesView;
import com.example.ptut.padc_simplehabit_one.shared.Constant;
import com.example.ptut.padc_simplehabit_one.shared.SmartRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityCategoryDetail extends BaseActivity implements SeriesView{
    @BindView(R.id.app_bar)
    AppBarLayout appBarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_image_view)
    ImageView toolbarImg;
    @BindView(R.id.category_detail_desc)
    TextView cateDetailDesc;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.category_detail_recycler)
    SmartRecyclerView cateDetails;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;


    private ProgramVO programVO;
    private CurrentProgramVO currentProgramVO;
    private boolean check = true;
    private SeriesDetailsPresenter detailsPresenter;


    //static factory method
    public static Intent getInstance(Context context, String id, String fromId) {
        Intent intent = new Intent(context, ActivityCategoryDetail.class);
        intent.putExtra(Constant.FROM_ID, id);
        intent.putExtra(Constant.FROM_VO, fromId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        String fromId = getIntent().getStringExtra(Constant.FROM_ID);
        String fromVo = getIntent().getStringExtra(Constant.FROM_VO);

        detailsPresenter=new SeriesDetailsPresenter(this);
        detailsPresenter.onCreate();
        check=detailsPresenter.onFinishSetup(fromVo,fromId);

        setActionBarTitle(check ? programVO.getTitle() : currentProgramVO.getTitle());
        toolbarTitle.setText(check ? programVO.getTitle() : currentProgramVO.getTitle());
        Glide.with(this)
                .load(check ? programVO.getImage() : currentProgramVO.getBackground())
                .into(toolbarImg);
        cateDetailDesc.setText(check ? programVO.getDescription() : currentProgramVO.getDescription());
        cateDetails.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        CategorySessionAdapter categoryAdapter = new CategorySessionAdapter(getApplicationContext());
        categoryAdapter.setNewData(check ? programVO.getSessions() : currentProgramVO.getSessions());
        cateDetails.setAdapter(categoryAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @OnClick(R.id.fab)
    public void OnFabClick() {
        Toast.makeText(getApplicationContext(), "You click floating action button.", Toast.LENGTH_LONG).show();
    }


    public void setActionBarTitle(final String text){

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(text);
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category_details, menu);
        return true;
    }

    @Override
    public void getTabCurrentItem(CurrentProgramVO currentProgramVO, ImageView imageView) {

    }

    @Override
    public void getTabCategoryItem(ProgramVO programVO, ImageView imageView) {

    }

    @Override
    public void displayCurrentData(CurrentProgramVO currentProgramVO) {
        this.currentProgramVO=currentProgramVO;
    }

    @Override
    public void displayCategoryData(ProgramVO programVO) {
        this.programVO=programVO;
    }

    @Override
    public void displayErrorMsg(String msg) {

    }
}
