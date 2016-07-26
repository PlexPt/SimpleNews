package com.zzh.simplenews.ReadNews;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzh.simplenews.R;
import com.zzh.simplenews.beans.BeforeNews;
import com.zzh.simplenews.beans.LatestNews;
import com.zzh.simplenews.beans.StoriesBean;
import com.zzh.simplenews.content.contentActivity;
import com.zzh.simplenews.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by zzh on 16/7/11.
 */
public class NewsFragment extends Fragment {


    private SwipeRefreshLayout mSwipeRefreshLayout;

    private RecyclerView mRecyclerView;

    private LinearLayoutManager mLinearLayoutManager;

    private NewsRecyclerViewAdapter mAdapter;

    private MainActivity mMainActivity;

    private int firstVisiblePosition = 0;



    @Inject
    NewsPresenter mNewsPresenter;


    public NewsFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = (MainActivity)getActivity();
        mMainActivity.getDaggerMainActivityComponent().inject(this);
        mNewsPresenter.setView(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment,container,false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.news_recyclerview);
        mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.news_swipeRefreshLayout);

        mLinearLayoutManager = new LinearLayoutManager(getContext());

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mAdapter = new NewsRecyclerViewAdapter(getContext());

        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mNewsPresenter.refreshData();
            }
        });
        mNewsPresenter.refreshData();
        mAdapter.setItemClickListener(new NewsRecyclerViewAdapter.ItemClickListener() {
            Intent mIntent = new Intent(mMainActivity,contentActivity.class);
            @Override
            public void onItemClick(StoriesBean storiesBean) {
                mIntent.putExtra(contentActivity.EXTRA_DATA_TAG,storiesBean.getId());
                startActivity(mIntent);
            }

            @Override
            public void onHeadItenClick(LatestNews.TopStoriesBean topStoriesBean) {
                mIntent.putExtra(contentActivity.EXTRA_DATA_TAG,topStoriesBean.getId());
                startActivity(mIntent);
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            int lastVisibleItem = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int totalCount = mLinearLayoutManager.getItemCount();
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == totalCount) {
                   //底部加载更多
                    mNewsPresenter.LoadMoreDate(mAdapter.getTime());
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
                firstVisiblePosition = mLinearLayoutManager.findFirstVisibleItemPosition();

                    mMainActivity.setToolBarTitle(mAdapter.getFormatTime(firstVisiblePosition));


            }
        });

        return view;
    }

    public void BeforeRefresh() {
      mSwipeRefreshLayout.setRefreshing(true);
    }

    public void AfterRefresh() {
        mSwipeRefreshLayout.setRefreshing(false);

        new AlertDialog.Builder(getActivity())
                .setTitle("网络出了点问题")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public void AfterRefresh(LatestNews latestNews) {

        mSwipeRefreshLayout.setRefreshing(false);
        mAdapter.addData(latestNews);
    }

    public void AfterRefresh(BeforeNews beforeNews) {

        mSwipeRefreshLayout.setRefreshing(false);
        mMainActivity.setToolBarTitle(mAdapter.getFormatTime(firstVisiblePosition));
        mAdapter.addData(beforeNews);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
























