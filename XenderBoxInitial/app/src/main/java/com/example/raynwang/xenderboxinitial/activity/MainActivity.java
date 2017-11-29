package com.example.raynwang.xenderboxinitial.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.raynwang.xenderboxinitial.fragment.DownloadFragment;
import com.example.raynwang.xenderboxinitial.fragment.HotSportFragment;
import com.example.raynwang.xenderboxinitial.fragment.MeFragment;
import com.example.raynwang.xenderboxinitial.fragment.RankingFragment;
import com.example.raynwang.xenderboxinitial.fragment.ReportFragment;
import com.example.raynwang.xenderboxinitial.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private List<Fragment> fragments;
    private TextView tv_toolbar_title;
    private Toolbar toolbar;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * 去掉标题
         */
//        requestWindowFeature(Window.FEATURE_NO_TITLE);//没作用
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //显示标题
        tv_toolbar_title = findViewById(R.id.tv_toolbar_title);

        toolbar = findViewById(R.id.too_bar);
        radioGroup = findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(this);

        //初始化fragments
        initFragments();
        //切换fragments
        switchFragments(0);
        //让第一个tab，默认是选中
        radioGroup.check(R.id.rb_hotspot);
    }

    /**
     * 初始化fragment
     */
    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new HotSportFragment());
        fragments.add(new ReportFragment());
        fragments.add(new RankingFragment());
        fragments.add(new DownloadFragment());
        fragments.add(new MeFragment());

    }

    /**
     * 根据下标，切换fragment
     */
    private void switchFragments(int index) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            if (i == index) {//选中的fragment
                if (fragment.isAdded()) {//判断当前是否已经添加到容器中
                    //如果已经添加到容器中，直接显示
                    fragmentTransaction.show(fragment);
                } else {
                    //将fragment添加到容器中
                    fragmentTransaction.add(R.id.fl_container, fragment);
                }
            } else {//其它没有被选中
                //如果在容器中，包含了fragment，隐藏fragment
                if (fragment.isAdded()) {
                    fragmentTransaction.hide(fragment);
                }
            }
        }
        fragmentTransaction.commitNowAllowingStateLoss();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {
            case R.id.rb_hotspot:
                switchFragments(0);
                tv_toolbar_title.setText("XenderBox");
                break;
            case R.id.rb_report:
                switchFragments(1);
                tv_toolbar_title.setText("Report");
                break;
            case R.id.rb_ranking:
                switchFragments(2);
                tv_toolbar_title.setText("Ranking");
                break;
            case R.id.rb_download:
                switchFragments(3);
                tv_toolbar_title.setText("Download");
                break;
            case R.id.rb_me:
                switchFragments(4);
                tv_toolbar_title.setText("Me");
                break;
        }
    }
}
