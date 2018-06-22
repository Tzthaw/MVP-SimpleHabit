package com.example.ptut.padc_simplehabit_one.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ptut.padc_simplehabit_one.R;

import butterknife.ButterKnife;

public class UserProfileActivity extends AppCompatActivity {


    public static void getInstance(Context context){
        Intent intent=new Intent(context,UserProfileActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_viewpod_userprofile);
        ButterKnife.bind(this,this);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
