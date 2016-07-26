package com.zzh.simplenews.ReadPicture;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zzh.simplenews.R;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by zzh on 16/4/25.
 */
public class PagerViewShowPictureAdapter extends PagerAdapter {

    private Context mContext;

    public PagerViewShowPictureAdapter(Context context) {
        mContext = context;
    }




    @Override
    public int getCount() {
        return PicturesAdapter.sUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_picture_show, container, false);
        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView_picture_activity_show);


        Glide.with(mContext)
                .load(PicturesAdapter.sUrls.get(position))
                .into(imageView);

        PhotoViewAttacher photoViewAttacher =new PhotoViewAttacher(imageView);
        photoViewAttacher.update();
//
        photoViewAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float v, float v1) {
                ((PictureActivity)mContext).hideOrShowToolbar();
            }
        });
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (container.getChildAt(position) != null && container.getChildCount() > 10) {
            container.removeViewAt(position);
        }
    }


    public void onPause() {

    }





}

























