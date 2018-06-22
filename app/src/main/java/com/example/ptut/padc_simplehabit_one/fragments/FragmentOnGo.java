package com.example.ptut.padc_simplehabit_one.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptut.padc_simplehabit_one.R;


public class FragmentOnGo extends Fragment {


    public static FragmentOnGo newInstance() {

        Bundle args = new Bundle();

        FragmentOnGo fragment = new FragmentOnGo();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_ongo,container,false);
        return v;
    }
}
