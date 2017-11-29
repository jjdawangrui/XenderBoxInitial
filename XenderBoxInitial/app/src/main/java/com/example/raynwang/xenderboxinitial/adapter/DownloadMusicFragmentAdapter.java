package com.example.raynwang.xenderboxinitial.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raynwang.xenderboxinitial.R;


/**
 * Created by raynwang on 2017/6/22.
 */

public class DownloadMusicFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    
    private Activity mActivity;
    Context context;

    public DownloadMusicFragmentAdapter(Activity activity, Context context) {
        this.mActivity = activity;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_download_music_item, parent, false);

        return new DownloadMusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final DownloadMusicViewHolder downloadMusicViewHolder = (DownloadMusicViewHolder) holder;

        downloadMusicViewHolder.mTv_download_music_music.setText("music"+position);
        downloadMusicViewHolder.mTv_download_music_singer.setText("singer"+position);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    class DownloadMusicViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIv_download_music_item;
        private final TextView mTv_download_music_music;
        private final TextView mTv_download_music_singer;

        public DownloadMusicViewHolder(View itemView) {
            super(itemView);
            mIv_download_music_item = itemView.findViewById(R.id.iv_download_music_item);
            mTv_download_music_music = itemView.findViewById(R.id.tv_download_music_music);
            mTv_download_music_singer = itemView.findViewById(R.id.tv_download_music_singer);
        }

    }
}
