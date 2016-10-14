package com.lanou3g.testdemo.classification.sku;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.BoxBean;
import com.lanou3g.testdemo.task.BaseFragment;
import com.lanou3g.testdemo.task.URLValues;
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
 * <p>
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
        final ArrayList<SKUItemBean> been = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(URLValues.CLASS_SKU_LIST, new Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                SKUItemBean bean = gson.fromJson(response, SKUItemBean.class);
                for (int i = 0; i < bean.getData().getCategories().size(); i++) {
                    bean.getData().getCategories().get(i).getName();
                    for (int j = 0; j < bean.getData().getCategories().get(i).getSubcategories().size(); j++) {
                        bean.getData().getCategories().get(i).getSubcategories().get(j).getIcon_url();
                        bean.getData().getCategories().get(i).getSubcategories().get(j).getName();
                    }
                    been.add(bean);
                }
                Log.d("SKUFragment", "been:" + been);
                SKUAdapter adapter = new SKUAdapter(getContext());
                adapter.setSKUBeen(been);
                mList_sku.setAdapter(adapter);

                SKUItemAdapter itemAdapter = new SKUItemAdapter(getContext());
                itemAdapter.setSKUItemBean(bean);
                mList_View_SKU.setAdapter(itemAdapter);



            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(stringRequest);





        StringRequest mStringRequests = new StringRequest(URLValues.EDITTEXT, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson mGson = new Gson();
                BoxBean boxBean = mGson.fromJson(response, BoxBean.class);
                mEditText.setHint(boxBean.getData().getPlaceholder());
                mEditText.setTextSize(10);
            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleton.getInstance().addRequest(mStringRequests);





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
                    mList_sku.setBackgroundColor(Color.YELLOW);
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (userScrolled) {

                    mList_sku.setSelection(i / 1);
//                    mList_sku.setBackgroundColor(Color.YELLOW);
//                    mList_sku.setDrawingCacheBackgroundColor(Color.YELLOW);
                }
            }
        });



    }
}
