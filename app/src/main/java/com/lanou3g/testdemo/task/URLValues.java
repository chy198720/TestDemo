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
    // 单品的所有需拼接
    public static final String PRODUCT_ALL = "http://api.liwushuo.com/v2/item_subcategories/";
    public static final String PRODUCT_ALL1 = "/items?limit=20&offset=0";

//    ______________________________________________________________________________________


}