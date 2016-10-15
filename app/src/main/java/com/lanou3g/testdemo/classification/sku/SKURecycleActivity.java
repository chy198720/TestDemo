package com.lanou3g.testdemo.classification.sku;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.BaseActivity;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.URLValues;

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
 * Created by 程洪运 on 16/10/14.
 */
public class SKURecycleActivity  extends BaseActivity implements OnClickListener {
    private TextView tv_sku_title;
    private ImageView iv_sku_return;
    private RecyclerView rv_sku_recycle_id;

    @Override
    protected int setLayout() {
        return R.layout.activity_sku_recycle;
    }

    @Override
    protected void initView() {
        tv_sku_title = bindView(R.id.tv_sku_title);
        iv_sku_return = bindView(R.id.iv_sku_return);
        rv_sku_recycle_id = bindView(R.id.rv_sku_recycle_id);
        iv_sku_return.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        tv_sku_title.setText(title);

        tool().getData(URLValues.PRODUCT_ALL + url + URLValues.PRODUCT_ALL1, SKURecycleBean.class, new NetTool.NetInterface<SKURecycleBean>() {
            @Override
            public void onSuccess(SKURecycleBean skuRecycleBase) {
                RecycleWebAdapter adapter = new RecycleWebAdapter();
                GridLayoutManager manager = new GridLayoutManager(MyApp.getContext(), 2);
                adapter.setSKURecycleBean(skuRecycleBase);
                rv_sku_recycle_id.setLayoutManager(manager);
                rv_sku_recycle_id.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_sku_return:
                finish();
                break;
        }
    }
}