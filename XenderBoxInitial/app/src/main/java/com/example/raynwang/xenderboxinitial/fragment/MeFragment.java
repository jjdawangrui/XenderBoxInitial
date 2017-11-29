package com.example.raynwang.xenderboxinitial.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raynwang.xenderboxinitial.R;

/**
 * Created by raynwang on 2017/11/8.
 */

public class MeFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_me_fragment, container, false);
        return view;
    }
}
