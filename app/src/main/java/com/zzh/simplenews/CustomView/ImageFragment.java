package com.zzh.simplenews.CustomView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zzh.simplenews.R;


/**
 * Created by zzh on 16/6/2.
 */
public class ImageFragment extends Fragment {

    private String url;


    public ImageFragment() {

    }

    private ImageFragmentClickListener mImageFragmentClickListener;

    public void setImageFragmentClickListener(ImageFragmentClickListener imageFragmentClickListener) {
        mImageFragmentClickListener = imageFragmentClickListener;
    }

    public interface ImageFragmentClickListener {
        void onClick();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null){
            this.url = bundle.getString("url");
        }
        ImageView view = (ImageView) inflater.inflate(R.layout.fragment_image, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageFragmentClickListener != null) {
                    mImageFragmentClickListener.onClick();
                }
            }
        });
        Glide.with(getContext())
                .load(url)
                .into(view);
        return view;
    }


}
