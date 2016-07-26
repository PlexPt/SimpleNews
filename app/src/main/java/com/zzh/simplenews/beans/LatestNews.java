package com.zzh.simplenews.beans;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LatestNews {


    /**
     * date : 20160607
     * stories : [{"images":["http://pic4.zhimg.com/95ef96aa4fa936a48acc894ac775226b.jpg"],"type":0,"id":8408225,"ga_prefix":"060707","title":"开门看海、上街抓鱼\u2026\u2026罪魁祸首果然还是它"},{"images":["http://pic1.zhimg.com/49c18ba51404154b98387218590e3e74.jpg"],"type":0,"id":8396163,"ga_prefix":"060707","title":"从国外名校通过「青年千人计划」回国是一种怎样的体验？"},{"images":["http://pic1.zhimg.com/dc689cb95acf852b038131418927dfc0.jpg"],"type":0,"id":8409434,"ga_prefix":"060707","title":"月亮的背面：那些不玩手机游戏的人"},{"images":["http://pic4.zhimg.com/9ca951d87fced803825660525cdbe903.jpg"],"type":0,"id":8410823,"ga_prefix":"060707","title":"读读日报 24 小时热门 TOP 5 · 4 招告别考试焦虑"},{"images":["http://pic2.zhimg.com/dadd7abe6ed79ed14d2a9036724ddf31.jpg"],"type":0,"id":8407258,"ga_prefix":"060706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/c52ea5b993930cc649b1049b7efe0cdd.jpg","type":0,"id":8409434,"ga_prefix":"060707","title":"月亮的背面：那些不玩手机游戏的人"},{"image":"http://pic3.zhimg.com/0df73f62028cead9dff9cbcf4d7ff78a.jpg","type":0,"id":8410823,"ga_prefix":"060707","title":"读读日报 24 小时热门 TOP 5 · 4 招告别考试焦虑"},{"image":"http://pic2.zhimg.com/122b7285291a677032d169915a32d9ad.jpg","type":0,"id":8409303,"ga_prefix":"060618","title":"职人介绍所第 19 期：不知道你有没有被他们鄙视过？"},{"image":"http://pic4.zhimg.com/ecb6e60a62aa8adcf831364d0384d3f7.jpg","type":0,"id":8404278,"ga_prefix":"060615","title":"有一部自己为原型的电影是什么样的体验？"},{"image":"http://pic3.zhimg.com/0e4537ff2ebeea21550e95f15768c6be.jpg","type":0,"id":8406303,"ga_prefix":"060607","title":"读读日报 24 小时热门 TOP 5 · 中国第一选手将出马，在围棋上为人类挽回面子？"}]
     */

    private String date;
    /**
     * images : ["http://pic4.zhimg.com/95ef96aa4fa936a48acc894ac775226b.jpg"]
     * type : 0
     * id : 8408225
     * ga_prefix : 060707
     * title : 开门看海、上街抓鱼……罪魁祸首果然还是它
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic2.zhimg.com/c52ea5b993930cc649b1049b7efe0cdd.jpg
     * type : 0
     * id : 8409434
     * ga_prefix : 060707
     * title : 月亮的背面：那些不玩手机游戏的人
     */

    private List<TopStoriesBean> top_stories;

    public static LatestNews objectFromData(String str) {

        return new Gson().fromJson(str, LatestNews.class);
    }

    public static LatestNews objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), LatestNews.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<LatestNews> arrayNewsContentBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<LatestNews>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<LatestNews> arrayNewsContentBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<LatestNews>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }


    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public static TopStoriesBean objectFromData(String str) {

            return new Gson().fromJson(str, TopStoriesBean.class);
        }

        public static TopStoriesBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), TopStoriesBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<TopStoriesBean> arrayTopStoriesBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<TopStoriesBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<TopStoriesBean> arrayTopStoriesBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<TopStoriesBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}