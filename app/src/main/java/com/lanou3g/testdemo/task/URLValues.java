package com.lanou3g.testdemo.task;

/**
 * Created by dllo on 16/5/23.
 */
public final class URLValues {
    //homeTab标题url
    public static final String ROLL_CHANNEL = "http://api.liwushuo.com/v2/channels/preset?gender=2&generation=1";
    //editText里内容
    public static final String EDITTEXT = "http://api.liwushuo.com/v2/search/hot_words_v2";
    //home轮播图url
    public static final String CAROUSEL = "http://api.liwushuo.com/v2/banners";
    //home小方框url
    public static final String SPECIAL = "http://api.liwushuo.com/v2/secondary_banners?gender=2&generation=1";
    //home的listView url
    public static final String HOME_CELL = "http://api.liwushuo.com/v2/channels/103/items_v2?ad=2&gender=2&generation=1&limit=20&offset=0";
    //榜单_每日推荐:
    public static final String SELECT_DAY = "http://api.liwushuo.com/v2/ranks_v2/ranks/1?limit=20&offset=0";
    public static final String SELECT_TOP = "http://api.liwushuo.com/v2/ranks_v2/ranks/2?limit=20&offset=0";
    public static final String SELECT_ORG = "http://api.liwushuo.com/v2/ranks_v2/ranks/3?limit=20&offset=0";
    public static final String SELECT_START = "http://api.liwushuo.com/v2/ranks_v2/ranks/4?limit=20&offset=0";
    // 攻略-栏目
    public static final String CLASS_STRATEGY_PART = "http://api.liwushuo.com/v2/columns?limit=20&offset=0";
    // 攻略-品类
    public static final String CLASS_STRATEGY_CATEGORY = "http://api.liwushuo.com/v2/channel_groups/all";
    // 单品listView
    public static final String CLASS_SKU_LIST = "http://api.liwushuo.com/v2/item_categories/tree";
    // 栏目的二级页面需拼接
    public static final String LM_SKIP = "http://api.liwushuo.com/v2/columns/";
    public static final String LM_SKIP1 = "?limit=20&offset=0";


//    ______________________________________________________________________________________


    //home的listview 点击进入界面的url
    public static final String HOME_DETAIL_CLICK_TAOBAO = "http://www.liwushuo.com/posts/";
    public static final String HOME_DETAIL_BEFORE = "http://api.liwushuo.com/v2/posts/";
    public static final String HOME_DETAIL_AFTER = "?show_baichuan=1";


    //select的分类页面
    public static final String SELECT = "http://api.liwushuo.com/v2/items?limit=20&offset=0&gender=2&generation=1";
    //home的tab分页url 穿搭
    public static final String ITEM_BEFORE = "http://api.liwushuo.com/v2/channels/";
    public static final String CONTENT_DOWN_BEFORE = "http://api.liwushuo.com/v2/posts/";
    public static final String CONTENT_DOWN_AFTER = "/comments?limit=20&offset=0";


    public static final String ITEM_AFTER = "/items?";

    //raidersCategoryfragment界面的上方平滑图片url
    public static final String RAIDERS_TOPIC = "http://api.liwushuo.com/v2/collections?limit=10&offset=0";
    public static final String RAIDERS_TOPIC_ALL = "http://api.liwushuo.com/v2/collections?limit=20&offset=0";

    //raidersCategoryfragment界面的下方的圆形图片所有内容url
    public static final String RAIDERS_DOWN = "http://api.liwushuo.com/v2/channel_groups/all";


    //raidersCategoryfragment界面上方圆角图片的点击url
    public static final String ITEM_RAIDERS_UP_BEFORE = "http://api.liwushuo.com/v2/collections/";
    public static final String ITEM_RAIDERS_UP_AFTER = "/posts?limit=20&offset=0";

    //raidersCategoryfragment界面下方圆形图片的点击url
    public static final String ITEM_RAIDERS_BEFORE = "http://api.liwushuo.com/v2/channels/";
    public static final String ITEM_RAIDERS_AFTER = "/items?limit=20&gender=1&offset=0&generation=1&order_by=now";

    //gift 礼物界面的listview解析url
    public static final String GIFT_LISTVIEW = "http://api.liwushuo.com/v2/item_categories/tree";

    //gift礼物界面每个小圆形item的接口url
    public static final String ITEM_GIFT_BEFORE = "http://api.liwushuo.com/v2/item_subcategories/";
    public static final String ITEM_GIFT_AFTER = "/items?limit=20&offset=0";

    //选礼神器点击进入下一个界面的item  url
    public static final String SELECT_GIFT = "http://api.liwushuo.com/v2/search/item_by_type?limit=20&offset=0";//item 圆角正方形图片
    public static final String SELECT_POPUP = "http://api.liwushuo.com/v2/search/item_filter";//popupwindow  每一个小挑选条件的url

    //选礼神奇小四方块点击进入webview的url   需要拼接id  id为SELECT_GIFT圆角正方形图片解析出来的
    public static final String SELECT_GIFT_WEB = "http://api.liwushuo.com/v2/items/";


    //点击放大镜的url
    public static final String SEARCH = "http://api.liwushuo.com/v2/search/hot_words";

    //查找进入的礼物界面
    public static final String SEARCH_GIFT = "http://api.liwushuo.com/v2/search/item?limit=20&offset=0&sort=&keyword=";


}
