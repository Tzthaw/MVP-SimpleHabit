package com.example.ptut.padc_simplehabit_one.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptut.padc_simplehabit_one.R;

public class FragmentTeachers extends Fragment{

    public static FragmentTeachers newInstance() {

        Bundle args = new Bundle();

        FragmentTeachers fragment = new FragmentTeachers();
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_teacher,container,false);
        return v;
    }
}
