package com.zzh.simplenews.beans;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/7/22.
 */
public class Video {

    /**
     * issueList : [{"releaseTime":1469116800000,"type":"normal","date":1469116800000,"publishTime":1469116800000,"itemList":[{"type":"video","data":{"dataType":"VideoBeanForClient","id":8092,"title":"我的神奇妈妈","description":"短片从小女孩的童真视角来讲述一个妈妈有魔法来帮助自己实现梦想的故事。而妈妈的魔法，则来自于社会的善意。这支短片的广告主是小微贷款慈善机构 Opportunity International。From Stefan Hunt","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.wdjimg.com/image/video/c3ad630be461cbb081649c9e21d6cbe3_256_256.png"},"category":"广告","author":null,"cover":{"feed":"http://img.wdjimg.com/image/video/351826e5d5a81df45a177fb7dc0bdb7a_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/351826e5d5a81df45a177fb7dc0bdb7a_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/ba528124f520b5dbdc0bc74c4cf7ca25_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=default","duration":204,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8092","forWeibo":"http://wandou.im/2juxkq"},"releaseTime":1469116800000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=high"}],"consumption":{"collectionCount":132,"shareCount":119,"replyCount":12},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":40,"name":"公益","actionUrl":"eyepetizer://tag/40/?title=%E5%85%AC%E7%9B%8A","adTrack":null},{"id":110,"name":"亲情","actionUrl":"eyepetizer://tag/110/?title=%E4%BA%B2%E6%83%85","adTrack":null},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null},{"id":498,"name":"萌","actionUrl":"eyepetizer://tag/498/?title=%E8%90%8C","adTrack":null},{"id":158,"name":"萝莉","actionUrl":"eyepetizer://tag/158/?title=%E8%90%9D%E8%8E%89","adTrack":null},{"id":490,"name":"脑洞","actionUrl":"eyepetizer://tag/490/?title=%E8%84%91%E6%B4%9E","adTrack":null},{"id":14,"name":"动画","actionUrl":"eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469116800000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":8262,"title":"大漠走来的冲浪冠军：铁桩","description":"内蒙古汉子铁桩在历经对生活的迷茫后到海南打拼，机缘巧合发现了自己对冲浪的热爱。2009 年他开始冲浪，不断磨练，最终作为一名专业滑手为人所知。本月 27 日，他将赴日本参加东京都知事杯冲浪大赛。From @REnextop","provider":{"name":"腾讯","alias":"qq","icon":"http://img.wdjimg.com/mms/icon/v1/4/2c/def8a8aa0971f93973280f7f75c772c4_256_256.png"},"category":"运动","author":{"id":182,"icon":"http://img.wdjimg.com/image/video/789dacf212667cfb2afc30f1cd78216f_0_0.jpeg","name":"REnextop","description":"成就你的运动梦想","link":"","latestReleaseTime":1469116800000,"videoNum":3,"adTrack":null},"cover":{"feed":"http://img.wdjimg.com/image/video/a315b724e5626808235afd9f4ad3aa40_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/a315b724e5626808235afd9f4ad3aa40_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/0308a0679b47519b560203d666fcf418_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8262&editionType=default","duration":444,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8262","forWeibo":"http://wandou.im/2mbf57"},"releaseTime":1469116800000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8262&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8262&editionType=high"}],"consumption":{"collectionCount":93,"shareCount":110,"replyCount":12},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":284,"name":"冲浪","actionUrl":"eyepetizer://tag/284/?title=%E5%86%B2%E6%B5%AA","adTrack":null},{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null},{"id":4,"name":"运动","actionUrl":"eyepetizer://tag/4/?title=%E8%BF%90%E5%8A%A8","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469116800000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":8108,"title":"法式煎牛排：经典里的与众不同","description":"厚达 4 厘米的顶级牛肉，配以富含多种矿物质的玫瑰盐使得牛排迸发出独特的咸鲜口感，新鲜双色煎角瓜带来的视觉冲击，再加上独家深度挖掘到的灵魂牛排酱汁。达成集色香味于一身的华丽盛宴。From @饭合FoodLink","provider":{"name":"腾讯","alias":"qq","icon":"http://img.wdjimg.com/mms/icon/v1/4/2c/def8a8aa0971f93973280f7f75c772c4_256_256.png"},"category":"开胃","author":{"id":206,"icon":"http://img.wdjimg.com/image/video/2531ae03dc6a4d9701d82bb88c7ac432_0_0.jpeg","name":"饭合 Foodlink","description":"一个人，一道菜，一种生活方式。相同食材不同感受，饭合视频让你饱眼福，饱口福。","link":"","latestReleaseTime":1469116800000,"videoNum":1,"adTrack":null},"cover":{"feed":"http://img.wdjimg.com/image/video/1336bc496558c4a3f7b946590281ea1c_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/1336bc496558c4a3f7b946590281ea1c_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/3977f6b48f996008baec99715e40ea12_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8108&editionType=default","duration":86,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8108","forWeibo":"http://wandou.im/2k5g97"},"releaseTime":1469116800000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8108&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8108&editionType=high"}],"consumption":{"collectionCount":264,"shareCount":266,"replyCount":13},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":240,"name":"西餐","actionUrl":"eyepetizer://tag/240/?title=%E8%A5%BF%E9%A4%90","adTrack":null},{"id":20,"name":"开胃","actionUrl":"eyepetizer://tag/20/?title=%E5%BC%80%E8%83%83","adTrack":null},{"id":272,"name":"荤食","actionUrl":"eyepetizer://tag/272/?title=%E8%8D%A4%E9%A3%9F","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469116800000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":8214,"title":"她把宫崎骏的电影，做成了院子","description":"一处老房，三人生活，十年租约。Yvonne 改造出的院子，既符合一家人对 \u201c偏日式小院 \u201d外观和功能上的期待，也科学满足了小朋友之之作为家庭一员对空间的需求。有风与四季，有设计师一家生动的生活故事。From@住艺","provider":{"name":"腾讯","alias":"qq","icon":"http://img.wdjimg.com/mms/icon/v1/4/2c/def8a8aa0971f93973280f7f75c772c4_256_256.png"},"category":"记录","author":{"id":204,"icon":"http://img.wdjimg.com/image/video/68ff353a77b54d90cc99106adece2f45_0_0.jpeg","name":"住艺","description":"康泰纳仕「安邸 AD」关联设计师精选平台，精选大咖设计师改造家视频，讲解改造趣事，分享设计灵感。","link":"","latestReleaseTime":1469116800000,"videoNum":1,"adTrack":null},"cover":{"feed":"http://img.wdjimg.com/image/video/5cb2008b315d17762a6de941295153c3_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/5cb2008b315d17762a6de941295153c3_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/ac370ed7dbfba0a1ad46b686c397e537_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8214&editionType=default","duration":156,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8214","forWeibo":"http://wandou.im/2lrl2n"},"releaseTime":1469116800000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8214&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8214&editionType=high"}],"consumption":{"collectionCount":460,"shareCount":565,"replyCount":34},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null},{"id":598,"name":"访谈","actionUrl":"eyepetizer://tag/598/?title=%E8%AE%BF%E8%B0%88","adTrack":null},{"id":68,"name":"建筑设计","actionUrl":"eyepetizer://tag/68/?title=%E5%BB%BA%E7%AD%91%E8%AE%BE%E8%AE%A1","adTrack":null},{"id":196,"name":"清新","actionUrl":"eyepetizer://tag/196/?title=%E6%B8%85%E6%96%B0","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469116800000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":5606,"title":"重复人生","description":"日复一日的固定轨迹就是公式，而偶然事件就像忽然出现的变量。当文森特开始关注一位美丽女郎，他的每日公式就悄然发生改变\u2026短片灵感来源于美国物理学家 Brian Greene 的著作「The Hidden Reality」From Paul Trillo","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.wdjimg.com/image/video/c3ad630be461cbb081649c9e21d6cbe3_256_256.png"},"category":"剧情","author":null,"cover":{"feed":"http://img.wdjimg.com/image/video/f424d98d34f42aaf8034cd0f6f3ad3dc_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/f424d98d34f42aaf8034cd0f6f3ad3dc_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/30b496736f21ecbe975c274c30fffbb6_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=5606&editionType=default","duration":499,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=5606","forWeibo":"http://wandou.im/1j882w"},"releaseTime":1469116800000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=5606&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=5606&editionType=high"}],"consumption":{"collectionCount":225,"shareCount":237,"replyCount":18},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":108,"name":"爱情","actionUrl":"eyepetizer://tag/108/?title=%E7%88%B1%E6%83%85","adTrack":null},{"id":82,"name":"定格","actionUrl":"eyepetizer://tag/82/?title=%E5%AE%9A%E6%A0%BC","adTrack":null},{"id":12,"name":"剧情","actionUrl":"eyepetizer://tag/12/?title=%E5%89%A7%E6%83%85","adTrack":null},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null},{"id":530,"name":"人生","actionUrl":"eyepetizer://tag/530/?title=%E4%BA%BA%E7%94%9F","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469116800000,"promotion":null,"label":null}}],"count":5},{"releaseTime":1469030400000,"type":"normal","date":1469030400000,"publishTime":1469030400000,"itemList":[{"type":"textHeader","data":{"dataType":"TextHeader","text":"- Jul. 21 -","font":"lobster","adTrack":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":8260,"title":"特条丨「自杀小分队」哈莉·奎因角色预告片","description":"有多少人等「自杀小分队」就为看哈莉·奎因？近期发布的角色预告将这位万众期待的美女暴力、调皮、病娇、性感等多面展现。然而国内定档日期还没确定╮(╯▽╰)╭From Warner Bros. Pictures","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.wdjimg.com/image/video/fa20228bc5b921e837156923a58713f6_256_256.png"},"category":"预告","author":null,"cover":{"feed":"http://img.wdjimg.com/image/video/f222e3ca22ef3820ddc1eecdb65fdf04_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/f222e3ca22ef3820ddc1eecdb65fdf04_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/3b425560b022296d533f501b986c8ca6_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8260&editionType=default","duration":60,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8260","forWeibo":"http://wandou.im/2m466f"},"releaseTime":1469080157000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8260&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8260&editionType=high"}],"consumption":{"collectionCount":876,"shareCount":2061,"replyCount":54},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":22,"name":"预告","actionUrl":"eyepetizer://tag/22/?title=%E9%A2%84%E5%91%8A","adTrack":null},{"id":408,"name":"DC","actionUrl":"eyepetizer://tag/408/?title=DC","adTrack":null},{"id":508,"name":"燃","actionUrl":"eyepetizer://tag/508/?title=%E7%87%83","adTrack":null},{"id":560,"name":"性感","actionUrl":"eyepetizer://tag/560/?title=%E6%80%A7%E6%84%9F","adTrack":null},{"id":544,"name":"美女","actionUrl":"eyepetizer://tag/544/?title=%E7%BE%8E%E5%A5%B3","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469030400000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":7654,"title":"电影混剪：创作者的磨难","description":"憋稿的过程就像难产，从古到今都是如此。这支电影混剪汇集了 53 部电影中创作者文思枯竭的片段，这过程中内心的无力挣扎心急如焚然而却敲不出半个字的苦难感受，想必你能从短片中感受到~From Ben Watts","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.wdjimg.com/image/video/c3ad630be461cbb081649c9e21d6cbe3_256_256.png"},"category":"综合","author":null,"cover":{"feed":"http://img.wdjimg.com/image/video/85b9d865eddfd09dac0cb3436217a62f_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/85b9d865eddfd09dac0cb3436217a62f_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/c1661ea7a4d72fe251bad157440c6fba_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=7654&editionType=default","duration":254,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=7654","forWeibo":"http://wandou.im/2b0hgs"},"releaseTime":1469030400000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=7654&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=7654&editionType=high"}],"consumption":{"collectionCount":993,"shareCount":1383,"replyCount":68},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469030400000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":8138,"title":"广告会玩丨印章演绎的五十岁","description":"古人云：五十而知天命。但有多少人在五十岁觉得自己碌碌无为？这时，一个欣赏你的伴侣就可以消除这种挫败感。这支创意短片是日本老牌文具厂商 Shachihata 为自己的五十周年所做。From シヤチハタ/Shachihata","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.wdjimg.com/image/video/fa20228bc5b921e837156923a58713f6_256_256.png"},"category":"广告","author":null,"cover":{"feed":"http://img.wdjimg.com/image/video/f6bc6fc719d4be070c5527c16f2ec7df_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/f6bc6fc719d4be070c5527c16f2ec7df_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/1c8b436039cc65cb936a26396aee6ec8_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8138&editionType=default","duration":237,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8138","forWeibo":"http://wandou.im/2kl54u"},"releaseTime":1469030400000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8138&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8138&editionType=high"}],"consumption":{"collectionCount":924,"shareCount":1183,"replyCount":34},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":136,"name":"温情","actionUrl":"eyepetizer://tag/136/?title=%E6%B8%A9%E6%83%85","adTrack":null},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":530,"name":"人生","actionUrl":"eyepetizer://tag/530/?title=%E4%BA%BA%E7%94%9F","adTrack":null},{"id":110,"name":"亲情","actionUrl":"eyepetizer://tag/110/?title=%E4%BA%B2%E6%83%85","adTrack":null},{"id":108,"name":"爱情","actionUrl":"eyepetizer://tag/108/?title=%E7%88%B1%E6%83%85","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469030400000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":8156,"title":"白色荒漠","description":"在美国小镇阿拉莫戈多有一片纯白似雪的荒漠。偶有时日大风扬起层层白沙，壮观的白色沙暴构成一番奇景。短片由摄影师 Harun Mehmedinovic 拍摄，在 BBC Earth 频道首映。From Harun Mehmedinovic","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.wdjimg.com/image/video/c3ad630be461cbb081649c9e21d6cbe3_256_256.png"},"category":"旅行","author":null,"cover":{"feed":"http://img.wdjimg.com/image/video/da5fc29d13e03eb95023cefaaa44ef1c_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/da5fc29d13e03eb95023cefaaa44ef1c_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/8b293236e0aa9cf8e0fd2143e74b9f75_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8156&editionType=default","duration":178,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8156","forWeibo":"http://wandou.im/2krhxv"},"releaseTime":1469030400000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8156&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8156&editionType=high"}],"consumption":{"collectionCount":898,"shareCount":1084,"replyCount":26},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":10,"name":"旅行","actionUrl":"eyepetizer://tag/10/?title=%E6%97%85%E8%A1%8C","adTrack":null},{"id":346,"name":"美国","actionUrl":"eyepetizer://tag/346/?title=%E7%BE%8E%E5%9B%BD","adTrack":null},{"id":202,"name":"唯美","actionUrl":"eyepetizer://tag/202/?title=%E5%94%AF%E7%BE%8E","adTrack":null},{"id":78,"name":"延时","actionUrl":"eyepetizer://tag/78/?title=%E5%BB%B6%E6%97%B6","adTrack":null},{"id":548,"name":"星空","actionUrl":"eyepetizer://tag/548/?title=%E6%98%9F%E7%A9%BA","adTrack":null},{"id":520,"name":"大自然","actionUrl":"eyepetizer://tag/520/?title=%E5%A4%A7%E8%87%AA%E7%84%B6","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469030400000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":8064,"title":"社交不是借口","description":"吸烟可谓是绝妙的社交工具，它可以帮助你打开话题，获得群体认同感，但究其本质，吸烟真的是一个好习惯吗？安大略卫生部以三个坏习惯类比，劝告人们不要以社交作为你染上烟瘾的借口。From Joe Johnson","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.wdjimg.com/image/video/fa20228bc5b921e837156923a58713f6_256_256.png"},"category":"广告","author":null,"cover":{"feed":"http://img.wdjimg.com/image/video/7e8fe4cd81340e5407835d69cd96d5cb_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/7e8fe4cd81340e5407835d69cd96d5cb_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/7c55923956fb3f1d59f901ef8781f407_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8064&editionType=default","duration":266,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8064","forWeibo":"http://wandou.im/2jb1iy"},"releaseTime":1469036259000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8064&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8064&editionType=high"}],"consumption":{"collectionCount":432,"shareCount":645,"replyCount":41},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":140,"name":"搞笑","actionUrl":"eyepetizer://tag/140/?title=%E6%90%9E%E7%AC%91","adTrack":null},{"id":168,"name":"讽刺","actionUrl":"eyepetizer://tag/168/?title=%E8%AE%BD%E5%88%BA","adTrack":null},{"id":40,"name":"公益","actionUrl":"eyepetizer://tag/40/?title=%E5%85%AC%E7%9B%8A","adTrack":null},{"id":120,"name":"黑色幽默","actionUrl":"eyepetizer://tag/120/?title=%E9%BB%91%E8%89%B2%E5%B9%BD%E9%BB%98","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469030400000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":7568,"title":"厨师大赛的意外收获","description":"自打一出生，我们就开始竞争。我们被告知优胜劣汰，机会需要抢夺。但在这样的狼性环境里，忙于竞争的我们是不是丢失了什么？本片由加州艺术学院学生 Hanna Cho 制作，情节直白却引人深思。From Hanna Cho","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.wdjimg.com/image/video/c3ad630be461cbb081649c9e21d6cbe3_256_256.png"},"category":"动画","author":null,"cover":{"feed":"http://img.wdjimg.com/image/video/6b6e9b257dbd00c51b00106568358e66_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/6b6e9b257dbd00c51b00106568358e66_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/1c492fcec1590eeac6a56bf7e46632cf_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=7568&editionType=default","duration":424,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=7568","forWeibo":"http://wandou.im/2a9ojk"},"releaseTime":1469030400000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=7568&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=7568&editionType=high"}],"consumption":{"collectionCount":524,"shareCount":394,"replyCount":18},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":14,"name":"动画","actionUrl":"eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB","adTrack":null},{"id":58,"name":"2D","actionUrl":"eyepetizer://tag/58/?title=2D","adTrack":null},{"id":136,"name":"温情","actionUrl":"eyepetizer://tag/136/?title=%E6%B8%A9%E6%83%85","adTrack":null},{"id":112,"name":"友情","actionUrl":"eyepetizer://tag/112/?title=%E5%8F%8B%E6%83%85","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469030400000,"promotion":null,"label":null}}],"count":7}]
     * nextPageUrl : http://baobab.wandoujia.com/api/v2/feed?date=1468944000000&num=2
     * nextPublishTime : 1469203200000
     * newestIssueType : normal
     * dialog : null
     */

    private String nextPageUrl;
    private long nextPublishTime;
    private String newestIssueType;
    private Object dialog;
    /**
     * releaseTime : 1469116800000
     * type : normal
     * date : 1469116800000
     * publishTime : 1469116800000
     * itemList : [{"type":"video","data":{"dataType":"VideoBeanForClient","id":8092,"title":"我的神奇妈妈","description":"短片从小女孩的童真视角来讲述一个妈妈有魔法来帮助自己实现梦想的故事。而妈妈的魔法，则来自于社会的善意。这支短片的广告主是小微贷款慈善机构 Opportunity International。From Stefan Hunt","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.wdjimg.com/image/video/c3ad630be461cbb081649c9e21d6cbe3_256_256.png"},"category":"广告","author":null,"cover":{"feed":"http://img.wdjimg.com/image/video/351826e5d5a81df45a177fb7dc0bdb7a_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/351826e5d5a81df45a177fb7dc0bdb7a_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/ba528124f520b5dbdc0bc74c4cf7ca25_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=default","duration":204,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8092","forWeibo":"http://wandou.im/2juxkq"},"releaseTime":1469116800000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=high"}],"consumption":{"collectionCount":132,"shareCount":119,"replyCount":12},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":40,"name":"公益","actionUrl":"eyepetizer://tag/40/?title=%E5%85%AC%E7%9B%8A","adTrack":null},{"id":110,"name":"亲情","actionUrl":"eyepetizer://tag/110/?title=%E4%BA%B2%E6%83%85","adTrack":null},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null},{"id":498,"name":"萌","actionUrl":"eyepetizer://tag/498/?title=%E8%90%8C","adTrack":null},{"id":158,"name":"萝莉","actionUrl":"eyepetizer://tag/158/?title=%E8%90%9D%E8%8E%89","adTrack":null},{"id":490,"name":"脑洞","actionUrl":"eyepetizer://tag/490/?title=%E8%84%91%E6%B4%9E","adTrack":null},{"id":14,"name":"动画","actionUrl":"eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469116800000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":8262,"title":"大漠走来的冲浪冠军：铁桩","description":"内蒙古汉子铁桩在历经对生活的迷茫后到海南打拼，机缘巧合发现了自己对冲浪的热爱。2009 年他开始冲浪，不断磨练，最终作为一名专业滑手为人所知。本月 27 日，他将赴日本参加东京都知事杯冲浪大赛。From @REnextop","provider":{"name":"腾讯","alias":"qq","icon":"http://img.wdjimg.com/mms/icon/v1/4/2c/def8a8aa0971f93973280f7f75c772c4_256_256.png"},"category":"运动","author":{"id":182,"icon":"http://img.wdjimg.com/image/video/789dacf212667cfb2afc30f1cd78216f_0_0.jpeg","name":"REnextop","description":"成就你的运动梦想","link":"","latestReleaseTime":1469116800000,"videoNum":3,"adTrack":null},"cover":{"feed":"http://img.wdjimg.com/image/video/a315b724e5626808235afd9f4ad3aa40_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/a315b724e5626808235afd9f4ad3aa40_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/0308a0679b47519b560203d666fcf418_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8262&editionType=default","duration":444,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8262","forWeibo":"http://wandou.im/2mbf57"},"releaseTime":1469116800000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8262&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8262&editionType=high"}],"consumption":{"collectionCount":93,"shareCount":110,"replyCount":12},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":284,"name":"冲浪","actionUrl":"eyepetizer://tag/284/?title=%E5%86%B2%E6%B5%AA","adTrack":null},{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null},{"id":4,"name":"运动","actionUrl":"eyepetizer://tag/4/?title=%E8%BF%90%E5%8A%A8","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469116800000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":8108,"title":"法式煎牛排：经典里的与众不同","description":"厚达 4 厘米的顶级牛肉，配以富含多种矿物质的玫瑰盐使得牛排迸发出独特的咸鲜口感，新鲜双色煎角瓜带来的视觉冲击，再加上独家深度挖掘到的灵魂牛排酱汁。达成集色香味于一身的华丽盛宴。From @饭合FoodLink","provider":{"name":"腾讯","alias":"qq","icon":"http://img.wdjimg.com/mms/icon/v1/4/2c/def8a8aa0971f93973280f7f75c772c4_256_256.png"},"category":"开胃","author":{"id":206,"icon":"http://img.wdjimg.com/image/video/2531ae03dc6a4d9701d82bb88c7ac432_0_0.jpeg","name":"饭合 Foodlink","description":"一个人，一道菜，一种生活方式。相同食材不同感受，饭合视频让你饱眼福，饱口福。","link":"","latestReleaseTime":1469116800000,"videoNum":1,"adTrack":null},"cover":{"feed":"http://img.wdjimg.com/image/video/1336bc496558c4a3f7b946590281ea1c_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/1336bc496558c4a3f7b946590281ea1c_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/3977f6b48f996008baec99715e40ea12_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8108&editionType=default","duration":86,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8108","forWeibo":"http://wandou.im/2k5g97"},"releaseTime":1469116800000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8108&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8108&editionType=high"}],"consumption":{"collectionCount":264,"shareCount":266,"replyCount":13},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":240,"name":"西餐","actionUrl":"eyepetizer://tag/240/?title=%E8%A5%BF%E9%A4%90","adTrack":null},{"id":20,"name":"开胃","actionUrl":"eyepetizer://tag/20/?title=%E5%BC%80%E8%83%83","adTrack":null},{"id":272,"name":"荤食","actionUrl":"eyepetizer://tag/272/?title=%E8%8D%A4%E9%A3%9F","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469116800000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":8214,"title":"她把宫崎骏的电影，做成了院子","description":"一处老房，三人生活，十年租约。Yvonne 改造出的院子，既符合一家人对 \u201c偏日式小院 \u201d外观和功能上的期待，也科学满足了小朋友之之作为家庭一员对空间的需求。有风与四季，有设计师一家生动的生活故事。From@住艺","provider":{"name":"腾讯","alias":"qq","icon":"http://img.wdjimg.com/mms/icon/v1/4/2c/def8a8aa0971f93973280f7f75c772c4_256_256.png"},"category":"记录","author":{"id":204,"icon":"http://img.wdjimg.com/image/video/68ff353a77b54d90cc99106adece2f45_0_0.jpeg","name":"住艺","description":"康泰纳仕「安邸 AD」关联设计师精选平台，精选大咖设计师改造家视频，讲解改造趣事，分享设计灵感。","link":"","latestReleaseTime":1469116800000,"videoNum":1,"adTrack":null},"cover":{"feed":"http://img.wdjimg.com/image/video/5cb2008b315d17762a6de941295153c3_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/5cb2008b315d17762a6de941295153c3_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/ac370ed7dbfba0a1ad46b686c397e537_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8214&editionType=default","duration":156,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8214","forWeibo":"http://wandou.im/2lrl2n"},"releaseTime":1469116800000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8214&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8214&editionType=high"}],"consumption":{"collectionCount":460,"shareCount":565,"replyCount":34},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null},{"id":598,"name":"访谈","actionUrl":"eyepetizer://tag/598/?title=%E8%AE%BF%E8%B0%88","adTrack":null},{"id":68,"name":"建筑设计","actionUrl":"eyepetizer://tag/68/?title=%E5%BB%BA%E7%AD%91%E8%AE%BE%E8%AE%A1","adTrack":null},{"id":196,"name":"清新","actionUrl":"eyepetizer://tag/196/?title=%E6%B8%85%E6%96%B0","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469116800000,"promotion":null,"label":null}},{"type":"video","data":{"dataType":"VideoBeanForClient","id":5606,"title":"重复人生","description":"日复一日的固定轨迹就是公式，而偶然事件就像忽然出现的变量。当文森特开始关注一位美丽女郎，他的每日公式就悄然发生改变\u2026短片灵感来源于美国物理学家 Brian Greene 的著作「The Hidden Reality」From Paul Trillo","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.wdjimg.com/image/video/c3ad630be461cbb081649c9e21d6cbe3_256_256.png"},"category":"剧情","author":null,"cover":{"feed":"http://img.wdjimg.com/image/video/f424d98d34f42aaf8034cd0f6f3ad3dc_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/f424d98d34f42aaf8034cd0f6f3ad3dc_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/30b496736f21ecbe975c274c30fffbb6_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=5606&editionType=default","duration":499,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=5606","forWeibo":"http://wandou.im/1j882w"},"releaseTime":1469116800000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=5606&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=5606&editionType=high"}],"consumption":{"collectionCount":225,"shareCount":237,"replyCount":18},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":108,"name":"爱情","actionUrl":"eyepetizer://tag/108/?title=%E7%88%B1%E6%83%85","adTrack":null},{"id":82,"name":"定格","actionUrl":"eyepetizer://tag/82/?title=%E5%AE%9A%E6%A0%BC","adTrack":null},{"id":12,"name":"剧情","actionUrl":"eyepetizer://tag/12/?title=%E5%89%A7%E6%83%85","adTrack":null},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null},{"id":530,"name":"人生","actionUrl":"eyepetizer://tag/530/?title=%E4%BA%BA%E7%94%9F","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469116800000,"promotion":null,"label":null}}]
     * count : 5
     */

    private List<IssueListBean> issueList;

    public static Video objectFromData(String str) {

        return new Gson().fromJson(str, Video.class);
    }

    public static Video objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Video.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Video> arrayVideoFromData(String str) {

        Type listType = new TypeToken<ArrayList<Video>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Video> arrayVideoFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Video>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public String getNewestIssueType() {
        return newestIssueType;
    }

    public void setNewestIssueType(String newestIssueType) {
        this.newestIssueType = newestIssueType;
    }

    public Object getDialog() {
        return dialog;
    }

    public void setDialog(Object dialog) {
        this.dialog = dialog;
    }

    public List<IssueListBean> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<IssueListBean> issueList) {
        this.issueList = issueList;
    }

    public static class IssueListBean {
        private long releaseTime;
        private String type;
        private long date;
        private long publishTime;
        private int count;
        /**
         * type : video
         * data : {"dataType":"VideoBeanForClient","id":8092,"title":"我的神奇妈妈","description":"短片从小女孩的童真视角来讲述一个妈妈有魔法来帮助自己实现梦想的故事。而妈妈的魔法，则来自于社会的善意。这支短片的广告主是小微贷款慈善机构 Opportunity International。From Stefan Hunt","provider":{"name":"Vimeo","alias":"vimeo","icon":"http://img.wdjimg.com/image/video/c3ad630be461cbb081649c9e21d6cbe3_256_256.png"},"category":"广告","author":null,"cover":{"feed":"http://img.wdjimg.com/image/video/351826e5d5a81df45a177fb7dc0bdb7a_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/351826e5d5a81df45a177fb7dc0bdb7a_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/ba528124f520b5dbdc0bc74c4cf7ca25_0_0.jpeg","sharing":null},"playUrl":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=default","duration":204,"webUrl":{"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8092","forWeibo":"http://wandou.im/2juxkq"},"releaseTime":1469116800000,"playInfo":[{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=high"}],"consumption":{"collectionCount":132,"shareCount":119,"replyCount":12},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":40,"name":"公益","actionUrl":"eyepetizer://tag/40/?title=%E5%85%AC%E7%9B%8A","adTrack":null},{"id":110,"name":"亲情","actionUrl":"eyepetizer://tag/110/?title=%E4%BA%B2%E6%83%85","adTrack":null},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null},{"id":498,"name":"萌","actionUrl":"eyepetizer://tag/498/?title=%E8%90%8C","adTrack":null},{"id":158,"name":"萝莉","actionUrl":"eyepetizer://tag/158/?title=%E8%90%9D%E8%8E%89","adTrack":null},{"id":490,"name":"脑洞","actionUrl":"eyepetizer://tag/490/?title=%E8%84%91%E6%B4%9E","adTrack":null},{"id":14,"name":"动画","actionUrl":"eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1469116800000,"promotion":null,"label":null}
         */

        private List<ItemListBean> itemList;

        public static IssueListBean objectFromData(String str) {

            return new Gson().fromJson(str, IssueListBean.class);
        }

        public static IssueListBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), IssueListBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<IssueListBean> arrayIssueListBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<IssueListBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<IssueListBean> arrayIssueListBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<IssueListBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public static class ItemListBean {
            private String type;
            /**
             * dataType : VideoBeanForClient
             * id : 8092
             * title : 我的神奇妈妈
             * description : 短片从小女孩的童真视角来讲述一个妈妈有魔法来帮助自己实现梦想的故事。而妈妈的魔法，则来自于社会的善意。这支短片的广告主是小微贷款慈善机构 Opportunity International。From Stefan Hunt
             * provider : {"name":"Vimeo","alias":"vimeo","icon":"http://img.wdjimg.com/image/video/c3ad630be461cbb081649c9e21d6cbe3_256_256.png"}
             * category : 广告
             * author : null
             * cover : {"feed":"http://img.wdjimg.com/image/video/351826e5d5a81df45a177fb7dc0bdb7a_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/351826e5d5a81df45a177fb7dc0bdb7a_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/ba528124f520b5dbdc0bc74c4cf7ca25_0_0.jpeg","sharing":null}
             * playUrl : http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=default
             * duration : 204
             * webUrl : {"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=8092","forWeibo":"http://wandou.im/2juxkq"}
             * releaseTime : 1469116800000
             * playInfo : [{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=high"}]
             * consumption : {"collectionCount":132,"shareCount":119,"replyCount":12}
             * campaign : null
             * waterMarks : null
             * adTrack : null
             * tags : [{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":40,"name":"公益","actionUrl":"eyepetizer://tag/40/?title=%E5%85%AC%E7%9B%8A","adTrack":null},{"id":110,"name":"亲情","actionUrl":"eyepetizer://tag/110/?title=%E4%BA%B2%E6%83%85","adTrack":null},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null},{"id":498,"name":"萌","actionUrl":"eyepetizer://tag/498/?title=%E8%90%8C","adTrack":null},{"id":158,"name":"萝莉","actionUrl":"eyepetizer://tag/158/?title=%E8%90%9D%E8%8E%89","adTrack":null},{"id":490,"name":"脑洞","actionUrl":"eyepetizer://tag/490/?title=%E8%84%91%E6%B4%9E","adTrack":null},{"id":14,"name":"动画","actionUrl":"eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB","adTrack":null}]
             * type : NORMAL
             * idx : 0
             * shareAdTrack : null
             * favoriteAdTrack : null
             * webAdTrack : null
             * date : 1469116800000
             * promotion : null
             * label : null
             */

            private DataBean data;

            public static ItemListBean objectFromData(String str) {

                return new Gson().fromJson(str, ItemListBean.class);
            }

            public static ItemListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ItemListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ItemListBean> arrayItemListBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ItemListBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ItemListBean> arrayItemListBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ItemListBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBean {
                private String text;
                private String font;

                private String dataType;
                private int id;
                private String title;
                private String description;
                /**
                 * name : Vimeo
                 * alias : vimeo
                 * icon : http://img.wdjimg.com/image/video/c3ad630be461cbb081649c9e21d6cbe3_256_256.png
                 */

                private ProviderBean provider;
                private String category;
                private Object author;
                /**
                 * feed : http://img.wdjimg.com/image/video/351826e5d5a81df45a177fb7dc0bdb7a_0_0.jpeg
                 * detail : http://img.wdjimg.com/image/video/351826e5d5a81df45a177fb7dc0bdb7a_0_0.jpeg
                 * blurred : http://img.wdjimg.com/image/video/ba528124f520b5dbdc0bc74c4cf7ca25_0_0.jpeg
                 * sharing : null
                 */

                private CoverBean cover;
                private String playUrl;
                private int duration;
                /**
                 * raw : http://www.wandoujia.com/eyepetizer/detail.html?vid=8092
                 * forWeibo : http://wandou.im/2juxkq
                 */

                private WebUrlBean webUrl;
                private long releaseTime;
                /**
                 * collectionCount : 132
                 * shareCount : 119
                 * replyCount : 12
                 */

                private ConsumptionBean consumption;
                private Object campaign;
                private Object waterMarks;
                private Object adTrack;
                private String type;
                private int idx;
                private Object shareAdTrack;
                private Object favoriteAdTrack;
                private Object webAdTrack;
                private long date;
                private Object promotion;
                private Object label;
                /**
                 * height : 480
                 * width : 854
                 * name : 标清
                 * type : normal
                 * url : http://baobab.wandoujia.com/api/v1/playUrl?vid=8092&editionType=normal
                 */

                private List<PlayInfoBean> playInfo;
                /**
                 * id : 16
                 * name : 广告
                 * actionUrl : eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A
                 * adTrack : null
                 */

                private List<TagsBean> tags;



                public static DataBean objectFromData(String str) {

                    return new Gson().fromJson(str, DataBean.class);
                }

                public static DataBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<DataBean> arrayDataBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<DataBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<DataBean> arrayDataBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<DataBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getFont() {
                    return font;
                }

                public void setFont(String font) {
                    this.font = font;
                }

                public String getDataType() {
                    return dataType;
                }

                public void setDataType(String dataType) {
                    this.dataType = dataType;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public ProviderBean getProvider() {
                    return provider;
                }

                public void setProvider(ProviderBean provider) {
                    this.provider = provider;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public Object getAuthor() {
                    return author;
                }

                public void setAuthor(Object author) {
                    this.author = author;
                }

                public CoverBean getCover() {
                    return cover;
                }

                public void setCover(CoverBean cover) {
                    this.cover = cover;
                }

                public String getPlayUrl() {
                    return playUrl;
                }

                public void setPlayUrl(String playUrl) {
                    this.playUrl = playUrl;
                }

                public int getDuration() {
                    return duration;
                }

                public void setDuration(int duration) {
                    this.duration = duration;
                }

                public WebUrlBean getWebUrl() {
                    return webUrl;
                }

                public void setWebUrl(WebUrlBean webUrl) {
                    this.webUrl = webUrl;
                }

                public long getReleaseTime() {
                    return releaseTime;
                }

                public void setReleaseTime(long releaseTime) {
                    this.releaseTime = releaseTime;
                }

                public ConsumptionBean getConsumption() {
                    return consumption;
                }

                public void setConsumption(ConsumptionBean consumption) {
                    this.consumption = consumption;
                }

                public Object getCampaign() {
                    return campaign;
                }

                public void setCampaign(Object campaign) {
                    this.campaign = campaign;
                }

                public Object getWaterMarks() {
                    return waterMarks;
                }

                public void setWaterMarks(Object waterMarks) {
                    this.waterMarks = waterMarks;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getIdx() {
                    return idx;
                }

                public void setIdx(int idx) {
                    this.idx = idx;
                }

                public Object getShareAdTrack() {
                    return shareAdTrack;
                }

                public void setShareAdTrack(Object shareAdTrack) {
                    this.shareAdTrack = shareAdTrack;
                }

                public Object getFavoriteAdTrack() {
                    return favoriteAdTrack;
                }

                public void setFavoriteAdTrack(Object favoriteAdTrack) {
                    this.favoriteAdTrack = favoriteAdTrack;
                }

                public Object getWebAdTrack() {
                    return webAdTrack;
                }

                public void setWebAdTrack(Object webAdTrack) {
                    this.webAdTrack = webAdTrack;
                }

                public long getDate() {
                    return date;
                }

                public void setDate(long date) {
                    this.date = date;
                }

                public Object getPromotion() {
                    return promotion;
                }

                public void setPromotion(Object promotion) {
                    this.promotion = promotion;
                }

                public Object getLabel() {
                    return label;
                }

                public void setLabel(Object label) {
                    this.label = label;
                }

                public List<PlayInfoBean> getPlayInfo() {
                    return playInfo;
                }

                public void setPlayInfo(List<PlayInfoBean> playInfo) {
                    this.playInfo = playInfo;
                }

                public List<TagsBean> getTags() {
                    return tags;
                }

                public void setTags(List<TagsBean> tags) {
                    this.tags = tags;
                }

                public static class ProviderBean {
                    private String name;
                    private String alias;
                    private String icon;

                    public static ProviderBean objectFromData(String str) {

                        return new Gson().fromJson(str, ProviderBean.class);
                    }

                    public static ProviderBean objectFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);

                            return new Gson().fromJson(jsonObject.getString(str), ProviderBean.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    public static List<ProviderBean> arrayProviderBeanFromData(String str) {

                        Type listType = new TypeToken<ArrayList<ProviderBean>>() {
                        }.getType();

                        return new Gson().fromJson(str, listType);
                    }

                    public static List<ProviderBean> arrayProviderBeanFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);
                            Type listType = new TypeToken<ArrayList<ProviderBean>>() {
                            }.getType();

                            return new Gson().fromJson(jsonObject.getString(str), listType);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return new ArrayList();


                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getAlias() {
                        return alias;
                    }

                    public void setAlias(String alias) {
                        this.alias = alias;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }
                }

                public static class CoverBean {
                    private String feed;
                    private String detail;
                    private String blurred;
                    private Object sharing;

                    public static CoverBean objectFromData(String str) {

                        return new Gson().fromJson(str, CoverBean.class);
                    }

                    public static CoverBean objectFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);

                            return new Gson().fromJson(jsonObject.getString(str), CoverBean.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    public static List<CoverBean> arrayCoverBeanFromData(String str) {

                        Type listType = new TypeToken<ArrayList<CoverBean>>() {
                        }.getType();

                        return new Gson().fromJson(str, listType);
                    }

                    public static List<CoverBean> arrayCoverBeanFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);
                            Type listType = new TypeToken<ArrayList<CoverBean>>() {
                            }.getType();

                            return new Gson().fromJson(jsonObject.getString(str), listType);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return new ArrayList();


                    }

                    public String getFeed() {
                        return feed;
                    }

                    public void setFeed(String feed) {
                        this.feed = feed;
                    }

                    public String getDetail() {
                        return detail;
                    }

                    public void setDetail(String detail) {
                        this.detail = detail;
                    }

                    public String getBlurred() {
                        return blurred;
                    }

                    public void setBlurred(String blurred) {
                        this.blurred = blurred;
                    }

                    public Object getSharing() {
                        return sharing;
                    }

                    public void setSharing(Object sharing) {
                        this.sharing = sharing;
                    }
                }

                public static class WebUrlBean {
                    private String raw;
                    private String forWeibo;

                    public static WebUrlBean objectFromData(String str) {

                        return new Gson().fromJson(str, WebUrlBean.class);
                    }

                    public static WebUrlBean objectFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);

                            return new Gson().fromJson(jsonObject.getString(str), WebUrlBean.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    public static List<WebUrlBean> arrayWebUrlBeanFromData(String str) {

                        Type listType = new TypeToken<ArrayList<WebUrlBean>>() {
                        }.getType();

                        return new Gson().fromJson(str, listType);
                    }

                    public static List<WebUrlBean> arrayWebUrlBeanFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);
                            Type listType = new TypeToken<ArrayList<WebUrlBean>>() {
                            }.getType();

                            return new Gson().fromJson(jsonObject.getString(str), listType);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return new ArrayList();


                    }

                    public String getRaw() {
                        return raw;
                    }

                    public void setRaw(String raw) {
                        this.raw = raw;
                    }

                    public String getForWeibo() {
                        return forWeibo;
                    }

                    public void setForWeibo(String forWeibo) {
                        this.forWeibo = forWeibo;
                    }
                }

                public static class ConsumptionBean {
                    private int collectionCount;
                    private int shareCount;
                    private int replyCount;

                    public static ConsumptionBean objectFromData(String str) {

                        return new Gson().fromJson(str, ConsumptionBean.class);
                    }

                    public static ConsumptionBean objectFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);

                            return new Gson().fromJson(jsonObject.getString(str), ConsumptionBean.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    public static List<ConsumptionBean> arrayConsumptionBeanFromData(String str) {

                        Type listType = new TypeToken<ArrayList<ConsumptionBean>>() {
                        }.getType();

                        return new Gson().fromJson(str, listType);
                    }

                    public static List<ConsumptionBean> arrayConsumptionBeanFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);
                            Type listType = new TypeToken<ArrayList<ConsumptionBean>>() {
                            }.getType();

                            return new Gson().fromJson(jsonObject.getString(str), listType);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return new ArrayList();


                    }

                    public int getCollectionCount() {
                        return collectionCount;
                    }

                    public void setCollectionCount(int collectionCount) {
                        this.collectionCount = collectionCount;
                    }

                    public int getShareCount() {
                        return shareCount;
                    }

                    public void setShareCount(int shareCount) {
                        this.shareCount = shareCount;
                    }

                    public int getReplyCount() {
                        return replyCount;
                    }

                    public void setReplyCount(int replyCount) {
                        this.replyCount = replyCount;
                    }
                }

                public static class PlayInfoBean {
                    private int height;
                    private int width;
                    private String name;
                    private String type;
                    private String url;

                    public static PlayInfoBean objectFromData(String str) {

                        return new Gson().fromJson(str, PlayInfoBean.class);
                    }

                    public static PlayInfoBean objectFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);

                            return new Gson().fromJson(jsonObject.getString(str), PlayInfoBean.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    public static List<PlayInfoBean> arrayPlayInfoBeanFromData(String str) {

                        Type listType = new TypeToken<ArrayList<PlayInfoBean>>() {
                        }.getType();

                        return new Gson().fromJson(str, listType);
                    }

                    public static List<PlayInfoBean> arrayPlayInfoBeanFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);
                            Type listType = new TypeToken<ArrayList<PlayInfoBean>>() {
                            }.getType();

                            return new Gson().fromJson(jsonObject.getString(str), listType);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return new ArrayList();


                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }

                public static class TagsBean {
                    private int id;
                    private String name;
                    private String actionUrl;
                    private Object adTrack;

                    public static TagsBean objectFromData(String str) {

                        return new Gson().fromJson(str, TagsBean.class);
                    }

                    public static TagsBean objectFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);

                            return new Gson().fromJson(jsonObject.getString(str), TagsBean.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    public static List<TagsBean> arrayTagsBeanFromData(String str) {

                        Type listType = new TypeToken<ArrayList<TagsBean>>() {
                        }.getType();

                        return new Gson().fromJson(str, listType);
                    }

                    public static List<TagsBean> arrayTagsBeanFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);
                            Type listType = new TypeToken<ArrayList<TagsBean>>() {
                            }.getType();

                            return new Gson().fromJson(jsonObject.getString(str), listType);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return new ArrayList();


                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getActionUrl() {
                        return actionUrl;
                    }

                    public void setActionUrl(String actionUrl) {
                        this.actionUrl = actionUrl;
                    }

                    public Object getAdTrack() {
                        return adTrack;
                    }

                    public void setAdTrack(Object adTrack) {
                        this.adTrack = adTrack;
                    }
                }
            }
        }
    }
}
