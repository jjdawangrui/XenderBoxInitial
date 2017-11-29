package com.example.raynwang.xenderboxinitial.fragment.subfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raynwang.xenderboxinitial.R;
import com.example.raynwang.xenderboxinitial.adapter.DownloadMusicFragmentAdapter;
import com.example.raynwang.xenderboxinitial.view.RecycleViewDivider;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by raynwang on 2017/11/8.
 */

public class DownloadMusicFragment extends android.support.v4.app.Fragment {

    private XRecyclerView mRecyclerView;
    private DownloadMusicFragmentAdapter mDownloadMusicFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_download_subfragment_1,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (XRecyclerView) view.findViewById(R.id.xrecyclerview);

//        //分隔线，需要一个自定义分隔线控件，在view里面
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(getContext(),
//                LinearLayoutManager.HORIZONTAL, 1, Color.GRAY));
//
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        //设置recyclerview下拉刷新进度条的样式
//        mRecyclerView.setRefreshProgressStyle(ProgressStyle.LineScalePulseOut);
//
//        //设置recyclerview上拉加载更多的样式
//        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);
//
//        //支持下拉刷新
//        mRecyclerView.setPullRefreshEnabled(true);
//        //支持加载更多
//        mRecyclerView.setLoadingMoreEnabled(true);


        //设置recyclerview下拉刷新和加载更多的监听
//        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
//            @Override
//            public void onRefresh() {//下拉刷新
//                isPullRefresh = true;
//            }
//
//            @Override
//            public void onLoadMore() {//上拉加载更多
//
//            }
//        });
//
//        //设置初始化状态为刷新状态。作用：界面初始加载时，刷新数据。
//        mRecyclerView.refresh();


        //设置适配器
        mDownloadMusicFragmentAdapter = new DownloadMusicFragmentAdapter(getActivity(),getContext());
        mRecyclerView.setAdapter(mDownloadMusicFragmentAdapter);


    }

}
