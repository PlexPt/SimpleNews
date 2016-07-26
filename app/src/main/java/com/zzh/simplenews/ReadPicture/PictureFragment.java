package com.zzh.simplenews.ReadPicture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzh.simplenews.R;
import com.zzh.simplenews.beans.PictureInfo;
import com.zzh.simplenews.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by zzh on 16/7/11.
 */
public class PictureFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MainActivity mMainActivity;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    private PicturesAdapter mAdapter;

    @Inject
    PicturePresenter mPicturePresenter;

    private int page = 2;

    public PictureFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = (MainActivity)getActivity();
        mMainActivity.getDaggerMainActivityComponent().inject(this);
        mPicturePresenter.setPictureFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.picture_RecyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.picture_swipeRefreshLayout);
        mAdapter = new PicturesAdapter(mMainActivity);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mPicturePresenter.refresh();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPicturePresenter.refresh();
            }
        });
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean isBottom = mAdapter.getItemCount() - mStaggeredGridLayoutManager.findLastVisibleItemPositions(new int[2])[1] <= 2;
                if (isBottom){
                    mPicturePresenter.loadMore(String.valueOf(page));
                    page++;
                }
            }
        });
        return view;
    }



    public void beforeGetData(){
        mSwipeRefreshLayout.setRefreshing(true);
    }

    public void afterGetData(){
        mSwipeRefreshLayout.setRefreshing(false);
        //网络问题
    }

    public void afterGetData(PictureInfo pictureInfo,boolean isTop){
        mSwipeRefreshLayout.setRefreshing(false);
        mAdapter.addData(pictureInfo,isTop);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPicturePresenter.onDestroy();
        mAdapter.onDestroy();
    }
}

















