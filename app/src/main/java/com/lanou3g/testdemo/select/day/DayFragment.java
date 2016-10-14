package com.lanou3g.testdemo.select.day;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.google.gson.Gson;
import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.send.SendFragment;
import com.lanou3g.testdemo.home.tab.TabFragment;
import com.lanou3g.testdemo.select.ItemActivity;
import com.lanou3g.testdemo.select.SelectFragment;
import com.lanou3g.testdemo.select.day.DayAdapter.OnItemClickListener;
import com.lanou3g.testdemo.task.BaseFragment;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.URLValues;
import com.lanou3g.testdemo.task.VolleySingleton;
import com.squareup.picasso.Picasso;

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
 * Created by 程洪运 on 16/9/20.
 */
public class DayFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private RecyclerViewHeader mHeader;
    ArrayList<Fragment> mFragments = new ArrayList<>();
    private ImageView img;

    @Override
    protected int setLayout() {
        return R.layout.fragment_day;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.recycler_Day);
        mHeader = bindView(R.id.header);
        img = bindView(R.id.img);


    }

    @Override
    protected void initData() {


        final ArrayList<DayBean> dayBeen = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(URLValues.SELECT_DAY, new Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                final DayBean dayBean = gson.fromJson(response,DayBean.class);
                for (int i = 0; i < dayBean.getData().getItems().size(); i++) {
                    dayBean.getData().getItems().get(i).getCover_image_url();
                    dayBean.getData().getItems().get(i).getShort_description();
                    dayBean.getData().getItems().get(i).getName();
                    dayBean.getData().getItems().get(i).getPrice();
                    dayBeen.add(dayBean);
                }

                NetTool tool = new NetTool();
                tool.getImg(dayBean.getData().getCover_image(),img);

                DayAdapter adapter = new DayAdapter(getContext());
                adapter.setDayBeen(dayBeen);
                GridLayoutManager manager = new GridLayoutManager(getContext(),2);
                mRecyclerView.setLayoutManager(manager);
                mRecyclerView.setAdapter(adapter);
                mHeader.attachTo(mRecyclerView, true);
                adapter.setRecommendOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void OnItemClickListener(View view, int position) {
                        if (dayBean.getData().getItems().get(position).getPurchase_url() != null) {
                            Intent intent = new Intent(context, ItemActivity.class);
                            intent.putExtra("purchase_url", dayBean.getData().getItems().get(position).getPurchase_url());
                            getContext().startActivity(intent);
                        } else {
                            Toast.makeText(context, "接口未找到", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(stringRequest);



    }
}
