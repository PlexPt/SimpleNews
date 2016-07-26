package com.zzh.simplenews.ReadNews;

import android.content.Context;

import com.zzh.simplenews.CustomView.ImageSlider;
import com.zzh.simplenews.beans.LatestNews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/6/20.
 */
public class ImageSliderWrapper {

    private ImageSlider mImageSlider;

    private List<LatestNews.TopStoriesBean> mTopStories;

    private Context mContext;

    private List<String> descs = new ArrayList<>();
    private List<String> urls = new ArrayList<>();

    public ImageSliderWrapper(Context context, ImageSlider imageSlider) {
        mContext = context;
        mImageSlider = imageSlider;
    }

    

    public void RefreshView(List<LatestNews.TopStoriesBean> topStories) {
        mTopStories = topStories;
        if (mImageSlider == null || mTopStories == null) {
            throw new NullPointerException("you must assign mImageSlider and mTopStories");
        }
        descs.clear();
        urls.clear();
        for (LatestNews.TopStoriesBean story : mTopStories){
            descs.add(story.getTitle());
            urls.add(story.getImage());
        }

        mImageSlider.RefreshView(descs,urls);
    }

    public ImageSlider getImageSlider() {
        return mImageSlider;
    }
}
