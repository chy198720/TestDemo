package com.lanou3g.testdemo.home.homepager.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.homepager.activity.HomeItemActivity;
import com.lanou3g.testdemo.home.homepager.adapter.SendAdapter;
import com.lanou3g.testdemo.home.homepager.bean.SendBean;
import com.lanou3g.testdemo.base.BaseFragment;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.NetTool.NetInterface;
import com.lanou3g.testdemo.task.PullListView;

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

    private PullListView mListView;
    private String strUrl;
    NetTool mTool = new NetTool();
    private SendAdapter mAdapter;

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


        mListView.setonRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... voids) {
                        try {
                            Thread.sleep(1800);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        mAdapter.notifyDataSetChanged();
                        mListView.onRefreshComplete();
                    }
                }.execute(null, null, null);
            }
        });
//        ------------------------------------------Gson

        mTool.getData(strUrl, SendBean.class, new NetInterface<SendBean>() {
            @Override
            public void onSuccess(final SendBean sendBean) {
                mAdapter = new SendAdapter();
                mAdapter.setSendBeen(sendBean);
                mListView.setAdapter(mAdapter);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(context, HomeItemActivity.class);
                        intent.putExtra("url_kind", sendBean.getData().getItems().get(i).getUrl());
                        getActivity().startActivity(intent);
                    }
                });

            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

}

