package com.example.ptut.padc_simplehabit_one.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.activities.base.BaseActivity;
import com.example.ptut.padc_simplehabit_one.controllers.EmptyClickListener;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.HomeScreenVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.fragments.FragmentOnGo;
import com.example.ptut.padc_simplehabit_one.fragments.FragmentSeries;
import com.example.ptut.padc_simplehabit_one.fragments.FragmentTeachers;
import com.example.ptut.padc_simplehabit_one.mvp.presenters.HomePresenterDelegate;
import com.example.ptut.padc_simplehabit_one.mvp.presenters.SeriesDetailsPresenter;
import com.example.ptut.padc_simplehabit_one.mvp.presenters.SeriesPresenter;
import com.example.ptut.padc_simplehabit_one.mvp.views.HomeScreenView;
import com.example.ptut.padc_simplehabit_one.mvp.views.SeriesDetailView;
import com.example.ptut.padc_simplehabit_one.shared.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements EmptyClickListener, SeriesDetailView, HomeScreenView, HomePresenterDelegate {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    ViewPagerAdapter adapter;
    SeriesDetailsPresenter detailsPresenter;
    SeriesPresenter seriesPresenter;
    FragmentSeries fragmentSeries;
    int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        detailsPresenter = new SeriesDetailsPresenter(this);
        detailsPresenter.onCreate();

        setSupportActionBar(toolbar);


        seriesPresenter = new SeriesPresenter(this);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        Objects.requireNonNull(tabLayout.getTabAt(1)).select();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_meditate:
                        return true;
                    case R.id.action_me:
                        UserProfileActivity.getInstance(getApplicationContext());
                        return true;
                    case R.id.action_more:

                        return true;
                }
                return false;
            }
        });

        fragmentSeries = (FragmentSeries) adapter.getItem(1);


    }

    private void setupViewPager(ViewPager viewPager) {
        adapter.addFragment(FragmentOnGo.newInstance(), "On The Go");
        adapter.addFragment(FragmentSeries.newInstance(), "SERIES");
        adapter.addFragment(FragmentTeachers.newInstance(), "TEACHERS");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onEmptyClick() {
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void getTabCurrentItem(CurrentProgramVO currentProgramVO, ImageView imageView) {
        Intent intent = ActivityCategoryDetail.getInstance(this, currentProgramVO.getProgramId(), Constant.CURRENT_ID);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, imageView, "profile");
        startActivity(intent, options.toBundle());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void getTabCategoryItem(ProgramVO programVO, ImageView imageView) {
        Intent intent = ActivityCategoryDetail.getInstance(this, programVO.getProgramId(), Constant.PROGRAM_ID);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, imageView, "profile");
        startActivity(intent, options.toBundle());
    }

    @Override
    public void displayCurrentData(CurrentProgramVO currentProgramVO) {

    }

    @Override
    public void displayCategoryData(ProgramVO programVO) {

    }

    @Override
    public void displayErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void displayAllDatas(List<HomeScreenVO> homeScreenVOS) {
        fragmentSeries.displayDataFromActivity(homeScreenVOS);
    }

    @Override
    public SeriesPresenter getPresenter() {
        return seriesPresenter;
    }


}