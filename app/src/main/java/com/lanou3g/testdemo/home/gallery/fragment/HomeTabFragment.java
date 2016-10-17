package com.lanou3g.testdemo.home.gallery.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.gallery.adapter.HomeTabAdapter;
import com.lanou3g.testdemo.home.gallery.bean.HomeBannerBean;
import com.lanou3g.testdemo.home.gallery.bean.HomeImgBean;
import com.lanou3g.testdemo.home.gallery.bean.HomeTabBean;
import com.lanou3g.testdemo.home.homepager.activity.HomeItemActivity;
import com.lanou3g.testdemo.base.BaseFragment;
import com.lanou3g.testdemo.base.MyApp;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.NetTool.NetInterface;
import com.lanou3g.testdemo.base.URLValues;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p/>
 * Created by 程洪运 on 16/9/19.
 */
public class HomeTabFragment extends BaseFragment {

    private LayoutInflater mInflater;
    private LinearLayout mGallery;
    private ListView mListView;
    ArrayList<String> mArrayList = new ArrayList<>();
    ArrayList<String> mList = new ArrayList<>();
    private Banner mBanner;
    private View mView;
    private ImageView mImg;

    NetTool mTool = new NetTool();

    @Override
    protected int setLayout() {
        mInflater = LayoutInflater.from(getContext());
        return R.layout.fragment_tab;
    }

    @Override
    protected void initView() {
        mListView = bindView(R.id.list_Tab);


    }

    @Override
    protected void initData() {
        mListView.setFocusable(true);
        mTool.getData(URLValues.HOME_CELL, HomeTabBean.class, new NetInterface<HomeTabBean>() {
            @Override
            public void onSuccess(final HomeTabBean tabBean) {
                HomeTabAdapter adapter = new HomeTabAdapter();
                adapter.setTabBeen(tabBean);
                mListView.setAdapter(adapter);
                mListView.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent intent = new Intent(getContext(), HomeItemActivity.class);
                        intent.putExtra("url", tabBean.getData().getItems().get(i - 1).getUrl());
                        getActivity().startActivity(intent);

                    }
                });
            }


            @Override
            public void onError(String errorMsg) {

            }
        });

        mView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.banner_tab, null);
        mBanner = (Banner) mView.findViewById(R.id.ban_ner);

        mTool.getData(URLValues.CAROUSEL, HomeBannerBean.class, new NetInterface<HomeBannerBean>() {
            @Override
            public void onSuccess(HomeBannerBean tabsBean) {
                for (int i = 0; i < tabsBean.getData().getBanners().size(); i++) {
                    mArrayList.add(tabsBean.getData().getBanners().get(i).getImage_url());

                }
                mBanner.setDelayTime(2000);
                mBanner.setImages(mArrayList);

                mListView.addHeaderView(mView);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

        mGallery = (LinearLayout) mView.findViewById(R.id.id_gallery);

        mTool.getData(URLValues.SPECIAL, HomeImgBean.class, new NetInterface<HomeImgBean>() {
            @Override
            public void onSuccess(HomeImgBean specialBean) {
                for (int i = 0; i < specialBean.getData().getSecondary_banners().size(); i++) {
                    mList.add(specialBean.getData().getSecondary_banners().get(i).getImage_url());
                    View view = mInflater.inflate(R.layout.gallery_item, mGallery, false);
                    mImg = (ImageView) view.findViewById(R.id.img_special);
                    mTool.getImg(specialBean.getData().getSecondary_banners().
                            get(i % mList.size()).getImage_url(), mImg);
                    mGallery.addView(view);
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

        mBanner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {

                startActivity(new Intent(getContext(), HomeItemActivity.class));
            }
        });

    }


}
