package com.zzh.simplenews.beans;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/6/10.
 */
public class BeforeNews {

    /**
     * date : 20160608
     * stories : [{"images":["http://pic1.zhimg.com/17b1c1944d5951997c65a85382dd87a4.jpg"],"type":0,"id":8404242,"ga_prefix":"060822","title":"小事 · 我遇到的四个「土豪」"},{"images":["http://pic1.zhimg.com/4b9d1de2479b0827d7e2f82e877ae114.jpg"],"type":0,"id":8418252,"ga_prefix":"060821","title":"「如果我喜欢的人是女生，你会怎么办？」"},{"images":["http://pic2.zhimg.com/08a7260e060970da9a203a76d591e821.jpg"],"type":0,"id":8409339,"ga_prefix":"060820","title":"经济学和银行业的革命就在眼前吗？"},{"images":["http://pic2.zhimg.com/ce16cc94d5e406516dba5391bdf99f19.jpg"],"type":0,"id":8410506,"ga_prefix":"060819","title":"「我这么做是有苦衷的，希望你能理解」"},{"images":["http://pic1.zhimg.com/07e58c15cc10e43c65f9981243143748.jpg"],"type":0,"id":8370156,"ga_prefix":"060818","title":"音乐老师没有教，钢琴中间的踏板是做什么用的？"},{"title":"如果吃了披萨，我们就不能看梵蒂冈博物馆了","ga_prefix":"060817","images":["http://pic4.zhimg.com/60b375f4f373e96ddd8772e1122185fb.jpg"],"multipic":true,"type":0,"id":8372700},{"images":["http://pic4.zhimg.com/09d6fb6997e0a9adf647c722f22c6ff7.jpg"],"type":0,"id":8417489,"ga_prefix":"060816","title":"参与高考阅卷是怎样的体验？"},{"images":["http://pic4.zhimg.com/4f5d928882fe185172d7e88bbf6ec977.jpg"],"type":0,"id":8415523,"ga_prefix":"060815","title":"肛门挂线，一个考验勇气的手术，一种直击灵魂的痛苦"},{"images":["http://pic1.zhimg.com/db0d210422e9b1383d2f7530dd9f51e4.jpg"],"type":0,"id":8417233,"ga_prefix":"060814","title":"「你说的白是什么白？」「大概是 255，255，255」"},{"images":["http://pic1.zhimg.com/d86308827d3cddd063edfa4d8a2d6b18.jpg"],"type":0,"id":8393081,"ga_prefix":"060813","title":"外教对小孩子英语学习帮助有多大？"},{"images":["http://pic2.zhimg.com/c2a340dc0f7fb80345e56d486207541d.jpg"],"type":0,"id":8393115,"ga_prefix":"060812","title":"大误 · 这不是几条，而是一串魔性的故事"},{"images":["http://pic3.zhimg.com/43e8197877d3110666fc501aa020742a.jpg"],"type":0,"id":8411049,"ga_prefix":"060811","title":"不同时空人物大乱斗的那种电影，中国现在还拍不出来"},{"images":["http://pic4.zhimg.com/4868c1805ed51d49f8a8b02cfde1a707.jpg"],"type":0,"id":8410628,"ga_prefix":"060810","title":"以前小孩子都靠吃药驱蛔虫，现在呢？"},{"images":["http://pic2.zhimg.com/0052c6b437e767123e7d35793de3253d.jpg"],"type":0,"id":8410151,"ga_prefix":"060809","title":"用一千刀处理一条鱼，这是「老京都」们夏天的浪漫"},{"images":["http://pic1.zhimg.com/13c3e0068651c0fd7dd22fa186e84ffc.jpg"],"type":0,"id":8403513,"ga_prefix":"060808","title":"边境也开了，货币也换了，加入欧盟的国家还有主权吗？"},{"images":["http://pic1.zhimg.com/c4111879bed9239f28a638bd01dde2e4.jpg"],"type":0,"id":8415773,"ga_prefix":"060807","title":"阿里巴巴最大的股东出售股票，因为这股东自己出了问题"},{"images":["http://pic3.zhimg.com/b1e35e568376250b0c3c4a3a06ddc9b6.jpg"],"type":0,"id":8396148,"ga_prefix":"060807","title":"拍电影时皇上坐的是不是真龙椅？不怕毁坏文物吗？"},{"images":["http://pic1.zhimg.com/3fb48f51ada89343ec3868179617263c.jpg"],"type":0,"id":8409856,"ga_prefix":"060807","title":"和数学好的小刚同桌后，我的数学成绩也变好了"},{"images":["http://pic2.zhimg.com/8202bffe4ca060601700e2d285092019.jpg"],"type":0,"id":8415878,"ga_prefix":"060807","title":"读读日报 24 小时热门 TOP 5 · 「高考难度排行榜」靠谱吗？"},{"images":["http://pic3.zhimg.com/577d82d5be9f2511f2f8c83aae12323e.jpg"],"type":0,"id":8408534,"ga_prefix":"060806","title":"瞎扯 · 血溅高考考场"},{"images":["http://pic1.zhimg.com/7c22090140df491351aa3aaa038c5f4c.jpg"],"type":0,"id":8413430,"ga_prefix":"060806","title":"这里是广告 · 拍广告、演美剧、找外星人，「宇宙网红」的开挂人生"}]
     */

    private String date;
    /**
     * images : ["http://pic1.zhimg.com/17b1c1944d5951997c65a85382dd87a4.jpg"]
     * type : 0
     * id : 8404242
     * ga_prefix : 060822
     * title : 小事 · 我遇到的四个「土豪」
     */

    private List<StoriesBean> stories;

    public static BeforeNews objectFromData(String str) {

        return new Gson().fromJson(str, BeforeNews.class);
    }

    public static BeforeNews objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), BeforeNews.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<BeforeNews> arraydayStoriesFromData(String str) {

        Type listType = new TypeToken<ArrayList<BeforeNews>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<BeforeNews> arraydayStoriesFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<BeforeNews>>() {
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


}
