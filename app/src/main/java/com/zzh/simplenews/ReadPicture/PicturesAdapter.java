package com.zzh.simplenews.ReadPicture;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zzh.simplenews.CustomView.RatioImageView;
import com.zzh.simplenews.R;
import com.zzh.simplenews.beans.PictureInfo;

import java.util.LinkedList;

/**
 * Created by zzh on 16/4/24.
 */
public class PicturesAdapter extends RecyclerView.Adapter<PicturesAdapter.ViewHolder> {


    private Context mContext;
    //与Viewpager共享数据
    //public static List<PictureInfo.ResultsBean> sData = new LinkedList<>();


    public static LinkedList<String> sUrls = new LinkedList<>();

    public void addData(PictureInfo pictureInfo, boolean isTop) {
        if (isTop) {
            sUrls.clear();
            for (int i = 0; i < pictureInfo.getResults().size(); i++) {
                sUrls.add(pictureInfo.getResults().get(i).getUrl());
            }
        }else{
            for (int i = 0; i < pictureInfo.getResults().size(); i++) {
                sUrls.add(pictureInfo.getResults().get(i).getUrl());
            }
        }
        notifyDataSetChanged();
//        boolean isChanged = false;
//        if (isTop){
//            for (int i = pictureInfo.getResults().size() - 1 ; i >= 0 ;i--){
//                if (!sUrls.contains(pictureInfo.getResults().get(i).getUrl())){
//                    sUrls.add(0,pictureInfo.getResults().get(i).getUrl());
//                    isChanged = true;
//                }
//            }
//            if (isChanged){
//                notifyDataSetChanged();
//            }
//        }else{
//            for (int i = 0 ; i < pictureInfo.getResults().size();i++){
//                sUrls.add(pictureInfo.getResults().get(i).getUrl());
//            }
//            notifyDataSetChanged();
//        }


    }

    public PicturesAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        Glide.with(mContext)
                .load(sUrls.get(position))
                .into(holder.imageView);
        holder.imageView.invalidate();

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureActivity.startPictureActivity(position, mContext);
            }
        });


    }

    @Override
    public int getItemCount() {
        return sUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RatioImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (RatioImageView) itemView.findViewById(R.id.item_ImageView);
            imageView.setOriginalSize(50,50);
        }
    }


    public void onDestroy() {

    }


}