package com.zzh.simplenews.ReadNews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zzh.simplenews.CustomView.ImageSlider;
import com.zzh.simplenews.R;
import com.zzh.simplenews.beans.BeforeNews;
import com.zzh.simplenews.beans.LatestNews;
import com.zzh.simplenews.beans.StoriesBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by zzh on 16/7/12.
 */
public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = NewsRecyclerViewAdapter.class.getSimpleName();

    public static final int TYPE_STORY = 0;
    public static final int TYPE_HEAD = 1;
    public static final int TYPE_TIME = 2;

    private LatestNews mLatestNews;

    private List<BeforeNews> mBeforeNewses = new ArrayList<>();

    private Context mContext;

    private ImageSlider mImageSlider;

    private String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

    private int first_position = 0;
    private int second_position = 0;

    public interface ItemClickListener{
        void onItemClick(StoriesBean storiesBean);
        void onHeadItenClick(LatestNews.TopStoriesBean topStoriesBean);
    }

    public ItemClickListener mItemClickListener = null;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void addData(LatestNews latest) {
        mLatestNews = latest;
        notifyDataSetChanged();
    }


    public void addData(BeforeNews before) {
        mBeforeNewses.add(before);
        notifyDataSetChanged();
    }

    public NewsRecyclerViewAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return TYPE_HEAD;

        List<Integer> number = new ArrayList<>();
        number.add(1);
        if (mLatestNews != null) {
            number.add(mLatestNews.getStories().size() + 1);
            if (mBeforeNewses != null) {
                for (BeforeNews before : mBeforeNewses) {
                    number.add(before.getStories().size() + 1);
                }
            }
        } else {
            //Log.d(TAG, "ViewType:" + -1);
            return -1; //Error
        }
        position++;

        int temp = position;
        for (first_position = 0; first_position < number.size(); first_position++) {
            if ((temp = temp - number.get(first_position)) <= 0) {
                //Log.d(TAG,"first_position = " + first_position );
                break;
            }
        }
        int j = 0;
        for (j = 0; j < first_position; j++) {
            position = position - number.get(j);
        }

        if (position == 1) {
            // Log.d(TAG, "ViewType:" + TYPE_TIME);
            return TYPE_TIME; //对应时间显示
        }
        position -= 2;
        second_position = position;
        //Log.d(TAG, "ViewType:" + TYPE_STORY);
        return TYPE_STORY;
    }

    public StoriesBean getStory(int position) {
        if (first_position == 1 && mLatestNews != null) {

            return mLatestNews.getStories().get(second_position);
        } else if (mBeforeNewses != null) {
            return mBeforeNewses.get(first_position - 2).getStories().get(second_position);
        }
        return null;
    }




    @Override
    public int getItemCount() {
        if (mLatestNews != null) {
            int count = 0;
            count = mLatestNews.getStories().size();
            ++count; //日期
            if (mBeforeNewses != null) {
                for (BeforeNews before : mBeforeNewses) {
                    count += before.getStories().size();
                    //日期
                    ++count;
                }
            }
            return ++count; //轮播图占一个位置
        }
        return 0;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEAD:
                mImageSlider = (ImageSlider) LayoutInflater.from(mContext).inflate(R.layout.item_imageslider, parent, false);
                return new ImageSliderViewHolder(new ImageSliderWrapper(mContext,mImageSlider));
            case TYPE_STORY:
                View storyView = LayoutInflater.from(mContext).inflate(R.layout.item_story, parent, false);
                return new StoryViewHolder(storyView);
            case TYPE_TIME:
                TextView textView = (TextView) LayoutInflater.from(mContext).inflate(R.layout.item_time, parent, false);
                return new TimeViewHolder(textView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //Log.d(TAG, "onBindViewHoler");
        int type = getItemViewType(position);
        switch (type) {
            case TYPE_HEAD:
                ((ImageSliderViewHolder) holder).mImageSliderWrapper.RefreshView(mLatestNews.getTop_stories());
                ((ImageSliderViewHolder) holder).mImageSliderWrapper.getImageSlider()
                        .setImageSliderOnClickListener(new ImageSlider.ImageSliderOnClickListener() {
                            @Override
                            public void OnClick(int position) {
                                if (mItemClickListener != null){
                                    mItemClickListener.onHeadItenClick(mLatestNews.getTop_stories().get(position));
                                }
                            }
                        });
                break;
            case TYPE_STORY:
                final StoriesBean storiesBean = getStory(position);
                if (storiesBean != null) {
                    ((StoryViewHolder) holder).mTextView.setText(storiesBean.getTitle());
                    ((StoryViewHolder) holder).mView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mItemClickListener != null){
                                mItemClickListener.onItemClick(storiesBean);
                            }
                        }
                    });
                    Glide.with(mContext)
                            .load(storiesBean.getImages().get(0))
                            .into(((StoryViewHolder) holder).mImageView);
                }
                break;
            case TYPE_TIME:
                ((TimeViewHolder) holder).mTextView.setText(getFormatTime(position));
                // mToolbar.setTitle(getFormatTime());
                break;
        }
    }


    public String getFormatTime(int position){
        if (position == 0) return "首页";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(getTime(position));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date now = new Date();

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar2.setTime(now);
        if ((calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR))
                && (calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH))
                && (calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH))){
            return "今日热闻";
        }else{
            SimpleDateFormat format2 = new SimpleDateFormat("MM月dd日");
            return  (format2.format(date) + " " + weeks[calendar1.get(Calendar.DAY_OF_WEEK) - 1]);
        }
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;
        public View mView;

        public StoryViewHolder(View view) {
            super(view);
            mView = view;
            this.mTextView = (TextView) view.findViewById(R.id.story_title);
            this.mImageView = (ImageView) view.findViewById(R.id.story_image);
        }
    }

    //当前绘制item对应的时间
    public String getTime() {
        if (first_position == 1) {
            return mLatestNews.getDate();
        } else {
            return mBeforeNewses.get(first_position - 2).getDate();
        }
    }

    public String getTime(int postion){
        int temp_first = first_position;
        int temp_second = second_position;
        String result;
        getItemViewType(postion);
        if (first_position == 1) {
            result = mLatestNews.getDate();
        } else {
            result = mBeforeNewses.get(first_position - 2).getDate();
        }
        first_position = temp_first;
        second_position = temp_second;

        return result;
    }

    public class TimeViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public TimeViewHolder(TextView textView) {
            super(textView);
            mTextView = textView;
        }
    }

    public class ImageSliderViewHolder extends RecyclerView.ViewHolder {
        //public ImageSlider mImageSlider;
        private ImageSliderWrapper mImageSliderWrapper;

        public ImageSliderViewHolder(ImageSliderWrapper imageSliderWrapper) {
            super(imageSliderWrapper.getImageSlider());
            this.mImageSliderWrapper = imageSliderWrapper;

        }
    }
}
