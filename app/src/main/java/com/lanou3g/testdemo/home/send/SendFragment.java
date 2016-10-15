package com.lanou3g.testdemo.home.send;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.homepager.HomeItemActivity;
import com.lanou3g.testdemo.task.BaseFragment;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.NetTool.NetInterface;

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
    NetTool mTool = new NetTool();

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

        mTool.getData(strUrl, SendBean.class, new NetInterface<SendBean>() {
            @Override
            public void onSuccess(SendBean sendBean) {
                SendAdapter adapter = new SendAdapter();
                adapter.setSendBeen(sendBean);
                mListView.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

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

