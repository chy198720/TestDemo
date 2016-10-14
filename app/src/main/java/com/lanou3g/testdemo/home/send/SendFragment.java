package com.lanou3g.testdemo.home.send;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.homepager.HomeItemActivity;
import com.lanou3g.testdemo.task.BaseFragment;
import com.lanou3g.testdemo.task.VolleySingleton;

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
 * Created by 程洪运 on 16/9/21.
 */
public class SendFragment extends BaseFragment {

    private ListView mListView;
    private String strUrl;

    @Override
    protected int setLayout() {
        return R.layout.fragment_send;
    }

    @Override
    protected void initView() {
        mListView = bindView(R.id.list_Send);

    }

    @Override
    protected void initData() {

        Bundle bundle = getArguments();
        String urlNum = bundle.getString("url");
        strUrl = "http://api.liwushuo.com/v2/channels/" + urlNum + "/items_v2?limit=20&ad=2&gender=2&offset=0&generation=2%20HTTP/1.1";


//        ------------------------------------------Gson


        final ArrayList<SendBean> mBeans = new ArrayList<>();

        final StringRequest stringRequest = new StringRequest(strUrl, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                SendBean bean = gson.fromJson(response, SendBean.class);
                Log.d("TabFragment", "bean:" + bean);
                for (int i = 0; i < bean.getData().getItems().size(); i++) {
                    mBeans.add(bean);
                }
                SendAdapter adapter = new SendAdapter(getContext());
                adapter.setSendBeen(mBeans);
                mListView.setAdapter(adapter);
            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });

        VolleySingleton.getInstance().addRequest(stringRequest);



//-------------------------------------跳转




        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SendBean bean = (SendBean) adapterView.getItemAtPosition(i);
                if (bean.getData().getItems().get(i).getUrl() != null) {
                    Intent intent = new Intent(context, HomeItemActivity.class);
                    intent.putExtra("url_kind", bean.getData().getItems().get(i).getUrl());
                    getActivity().startActivity(intent);
                } else {
                    Toast.makeText(context, "没有接口", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

