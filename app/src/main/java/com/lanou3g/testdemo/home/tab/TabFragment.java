package com.lanou3g.testdemo.home.tab;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.homepager.HomeItemActivity;
import com.lanou3g.testdemo.task.BaseFragment;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.NetTool.NetInterface;
import com.lanou3g.testdemo.task.URLValues;
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
public class TabFragment extends BaseFragment {

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
        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TabBean bean = (TabBean) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(getContext(), HomeItemActivity.class);
                intent.putExtra("url", bean.getData().getItems().get(i - 1).getUrl());
                getActivity().startActivity(intent);

            }
        });


        mTool.getData(URLValues.HOME_CELL, TabBean.class, new NetInterface<TabBean>() {
            @Override
            public void onSuccess(TabBean tabBean) {
                TabAdapter adapter = new TabAdapter();
                adapter.setTabBeen(tabBean);
                mListView.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

        mView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.banner_tab, null);
        mBanner = (Banner) mView.findViewById(R.id.ban_ner);

        mTool.getData(URLValues.CAROUSEL, TabsBean.class, new NetInterface<TabsBean>() {
            @Override
            public void onSuccess(TabsBean tabsBean) {
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

        mTool.getData(URLValues.SPECIAL, SpecialBean.class, new NetInterface<SpecialBean>() {
            @Override
            public void onSuccess(SpecialBean specialBean) {
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
