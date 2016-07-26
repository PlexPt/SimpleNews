package com.zzh.simplenews.readVideo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zzh.simplenews.R;
import com.zzh.simplenews.beans.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/7/22.
 */
public class VideosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public final static int TYPE_VIDEO = 0;
    public final static int TYPE_TIME = 1;
    List<Video.IssueListBean.ItemListBean> datas = new ArrayList<>();

    Context mContext;
    public VideosAdapter(Context context){
        mContext = context;
    }
    private onItemClickInterface mOnItemClickInterface;

    public void setOnItemClickInterface(onItemClickInterface onItemClickInterface) {
        mOnItemClickInterface = onItemClickInterface;
    }

    public interface onItemClickInterface{
        void onClick(String url);
    }

    public void addData(Video video, boolean isTop) {
        if (isTop) {
            datas.clear();
            for (int i = 0; i < video.getIssueList().size(); i++) {
                datas.addAll(video.getIssueList().get(i).getItemList());
            }
        } else {
            for (int i = 0; i < video.getIssueList().size(); i++) {
                datas.addAll(video.getIssueList().get(i).getItemList());
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_VIDEO){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
            return new VideoHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_time, parent, false);
        return new TimeHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Video.IssueListBean.ItemListBean.DataBean dataBean = datas.get(position).getData();
        if (getItemViewType(position) == TYPE_VIDEO){
            VideoHolder videoHolder = (VideoHolder) holder;
            videoHolder.mTextViewTitle.setText(dataBean.getTitle());
            videoHolder.mTextViewCatogory.setText(dataBean.getCategory());
            Glide.with(mContext)
                    .load(dataBean.getCover().getFeed())
                    .into(videoHolder.mImageView);
            videoHolder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickInterface != null){
                        if (dataBean.getPlayInfo().size() >= 2){
                            mOnItemClickInterface.onClick(dataBean.getPlayInfo().get(1).getUrl());
                        }else{
                            mOnItemClickInterface.onClick(dataBean.getPlayInfo().get(0).getUrl());
                        }

                    }
                }
            });

        }else if (getItemViewType(position) == TYPE_TIME){
            TimeHolder timeHolder = (TimeHolder)holder;
            timeHolder.mTextView.setText(dataBean.getText());
        }


    }

    @Override
    public int getItemViewType(int position) {
        if(datas.get(position).getType().equals("video") ){
            return TYPE_VIDEO;
        }
        return TYPE_TIME;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private static class VideoHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewTitle;
        public TextView mTextViewCatogory;

        public VideoHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.video_imageView);
            mTextViewTitle = (TextView) itemView.findViewById(R.id.video_title);
            mTextViewCatogory = (TextView)itemView.findViewById(R.id.video_catogory);
        }

    }


    private static class TimeHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public TimeHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.videos_time);
        }
    }


}
