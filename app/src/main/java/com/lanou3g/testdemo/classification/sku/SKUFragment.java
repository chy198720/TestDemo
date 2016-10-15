package com.lanou3g.testdemo.classification.sku;

import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.BoxBean;
import com.lanou3g.testdemo.task.BaseFragment;
import com.lanou3g.testdemo.task.LmClickListener;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.NetTool.NetInterface;
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
 * <p/>
 * Created by 程洪运 on 16/9/23.
 */
public class SKUFragment extends BaseFragment {

    private ListView mList_sku;
    private EditText mEditText;
    private ListView mList_View_SKU;


    @Override
    protected int setLayout() {
        return R.layout.fragment_sku;
    }

    @Override
    protected void initView() {
        mList_sku = bindView(R.id.list_SKU);
        mEditText = bindView(R.id.edit_SKU);
        mList_View_SKU = bindView(R.id.list_View_SKU);
        mList_View_SKU.setVerticalScrollBarEnabled(false);

    }

    @Override
    protected void initData() {

        NetTool tool = new NetTool();
        tool.getData(URLValues.CLASS_SKU_LIST, SKUItemBean.class, new NetInterface<SKUItemBean>() {
            @Override
            public void onSuccess(SKUItemBean skuItemBean) {
                SKUAdapter skuAdapter = new SKUAdapter();
                skuAdapter.setSKUBeen(skuItemBean);
                mList_sku.setAdapter(skuAdapter);
                SKUItemAdapter skuItemAdapter = new SKUItemAdapter();
                skuItemAdapter.setSKUItemBean(skuItemBean);
                skuItemAdapter.setLmClickListener(new LmClickListener() {
                    @Override
                    public void onClick(int id, String title) {
                        Intent intent = new Intent(MyApp.getContext(), SKURecycleActivity.class);
                        intent.putExtra("url", "" + id);
                        intent.putExtra("title", title);
                        startActivity(intent);
                    }
                });
                mList_View_SKU.setAdapter(skuItemAdapter);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });


        tool.getData(URLValues.EDITTEXT, BoxBean.class, new NetInterface<BoxBean>() {
            @Override
            public void onSuccess(BoxBean boxBean) {
                mEditText.setHint(boxBean.getData().getPlaceholder());
                mEditText.setTextSize(10);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

        mList_sku.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mList_View_SKU.setSelection(i * 1);
            }
        });

        mList_View_SKU.setOnScrollListener(new OnScrollListener() {
            boolean userScrolled = false;

            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == SCROLL_STATE_IDLE) {
                    userScrolled = false;
                } else {
                    userScrolled = true;
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (userScrolled) {

                    mList_sku.setSelection(i / 1);
                }
            }
        });


    }
}
