package com.lanou3g.testdemo.home.tab;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.homepager.HomeItemActivity;
import com.lanou3g.testdemo.my.SettingsActivity;
import com.lanou3g.testdemo.task.BaseFragment;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.URLValues;
import com.lanou3g.testdemo.task.VolleySingleton;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.listener.OnLoadImageListener;

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
 * <p>
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

        final ArrayList<TabBean> mBeans = new ArrayList<>();

        final StringRequest stringRequest = new StringRequest(URLValues.HOME_CELL, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                TabBean bean = gson.fromJson(response, TabBean.class);
                Log.d("TabFragment", "bean:" + bean);
                for (int i = 0; i < bean.getData().getItems().size(); i++) {
                    bean.getData().getItems().get(i).getUrl();
                    bean.getData().getItems().get(i).getCover_image_url();
                    bean.getData().getItems().get(i).getTitle();
                    bean.getData().getItems().get(i).getAuthor().getNickname();
                    bean.getData().getItems().get(i).getAuthor().getAvatar_url();
                    mBeans.add(bean);
                }
                TabAdapter adapter = new TabAdapter(getContext());
                adapter.setTabBeen(mBeans);
                mListView.setAdapter(adapter);
            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });

        VolleySingleton.getInstance().addRequest(stringRequest);


        mView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.banner_tab, null);
        mBanner = (Banner) mView.findViewById(R.id.ban_ner);

        StringRequest mStringRequest = new StringRequest(URLValues.CAROUSEL, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                TabsBean tabsBean = gson.fromJson(response, TabsBean.class);
                for (int i = 0; i < tabsBean.getData().getBanners().size(); i++) {
                    mArrayList.add(tabsBean.getData().getBanners().get(i).getImage_url());

                }
                Log.d("TabFragment", "mArrayList:" + mArrayList);
                mBanner.setDelayTime(2000);
                mBanner.setImages(mArrayList);

                mListView.addHeaderView(mView);


            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(mStringRequest);


        mGallery = (LinearLayout) mView.findViewById(R.id.id_gallery);


        StringRequest request = new StringRequest(URLValues.SPECIAL, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                SpecialBean specialBean = gson.fromJson(response, SpecialBean.class);
                for (int i = 0; i < specialBean.getData().getSecondary_banners().size(); i++) {
                    mList.add(specialBean.getData().getSecondary_banners().get(i).getImage_url());
                    View view = mInflater.inflate(R.layout.gallery_item, mGallery, false);
                    mImg = (ImageView) view.findViewById(R.id.img_special);
                    Picasso.with(getContext()).load(specialBean.getData().getSecondary_banners().
                            get(i % specialBean.getData().getSecondary_banners().size()).getImage_url()).into(mImg);
                    mGallery.addView(view);
                }

            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(request);



        mBanner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {

                startActivity(new Intent(getContext(), HomeItemActivity.class));


            }
        });

    }


}
