package com.example.raynwang.xenderboxinitial.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raynwang.xenderboxinitial.R;
import com.example.raynwang.xenderboxinitial.adapter.TablayoutFragmentAdapter;
import com.example.raynwang.xenderboxinitial.fragment.subfragment.DownloadHistoryFragment;
import com.example.raynwang.xenderboxinitial.fragment.subfragment.DownloadMovieFragment;
import com.example.raynwang.xenderboxinitial.fragment.subfragment.DownloadMusicFragment;
import com.example.raynwang.xenderboxinitial.fragment.subfragment.ReportDayReportFragment;
import com.example.raynwang.xenderboxinitial.fragment.subfragment.ReportIncomeFragment;
import com.example.raynwang.xenderboxinitial.fragment.subfragment.ReportInstallationFragment;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by raynwang on 2017/11/8.
 */

public class DownloadFragment extends android.support.v4.app.Fragment {
    private static TabLayout tabLayout;
    private static ViewPager viewPager;
    private static TablayoutFragmentAdapter tablayoutFragmentAdapter;

    private static List<Fragment> subFragments = new LinkedList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tablayout_viewpager, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tablayoutFragmentAdapter = new TablayoutFragmentAdapter(getChildFragmentManager());
        initSubFragment();
        viewPagerBindTabLayout();
        initSubTitle();

    }

    public static void viewPagerBindTabLayout() {
        viewPager.setAdapter(tablayoutFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    //初始化子标题
    public static void initSubTitle() {
        tabLayout.getTabAt(0).setText("History");
        tabLayout.getTabAt(1).setText("Music");
        tabLayout.getTabAt(2).setText("Movie");
    }

    //初始化子fragment
    public static void initSubFragment() {
        subFragments.clear();
        subFragments.add(new DownloadHistoryFragment());
        subFragments.add(new DownloadMusicFragment());
        subFragments.add(new DownloadMovieFragment());
        tablayoutFragmentAdapter.addAll(subFragments);

    }
}
