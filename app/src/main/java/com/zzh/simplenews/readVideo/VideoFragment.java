package com.zzh.simplenews.readVideo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzh.simplenews.R;
import com.zzh.simplenews.beans.Video;
import com.zzh.simplenews.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by zzh on 16/7/11.
 */
public class VideoFragment extends Fragment {

    public static final String TAG = VideoFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private MainActivity mMainActivity;
    private VideosAdapter mVideosAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    //for first page
    private final static String numFirstPage = "2";
    private final static String udid = "26868b32e808498db32fd51fb422d00175e179df";
    private final static String vc = "83";

    //for next page
    private String date;
    private String num;

    @Inject
    VideoPresenter mVideoPresenter;

    public VideoFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = (MainActivity)getActivity();
        mMainActivity.getDaggerMainActivityComponent().inject(this);
        mVideoPresenter.setVideoFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment,container,false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.video_RecyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.video_SwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mVideoPresenter.getFirstPageVideo(numFirstPage,udid,vc);
            }
        });
        mVideosAdapter = new VideosAdapter(mMainActivity);
        mRecyclerView.setAdapter(mVideosAdapter);
        mLinearLayoutManager = new LinearLayoutManager(mMainActivity);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mVideoPresenter.getFirstPageVideo(numFirstPage,udid,vc);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            int lastVisibleItem = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int totalCount = mLinearLayoutManager.getItemCount();
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == totalCount) {
                    //底部加载更多
                    if (num == null || date == null){
                        throw new RuntimeException("network error");
                    }
                    mVideoPresenter.getVideos(date,num);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
                //firstVisiblePosition = mLinearLayoutManager.findFirstVisibleItemPosition();
            }
        });
        mVideosAdapter.setOnItemClickInterface(new VideosAdapter.onItemClickInterface() {
            @Override
            public void onClick(String url) {
                VideoShowActivity.newIntent(mMainActivity,url);
            }
        });
        return view;
    }

    public void afterGetVideo(Video video,boolean isTop){
        String url = video.getNextPageUrl();

        date = url.substring(45,58);
        num = url.substring(63,64);

        Log.d(TAG,date);
        Log.d(TAG,num);
        mVideosAdapter.addData(video,isTop);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
