package com.lanou3g.testdemo.classification.strategy;

import android.widget.ListView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.BaseActivity;
import com.lanou3g.testdemo.task.URLValues;
import com.lanou3g.testdemo.task.VolleySingleton;

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
 * Created by 程洪运 on 16/10/12.
 */
public class ColumnActivity extends BaseActivity {
    private ListView mListView;
    private ColumnAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_column;
    }

    @Override
    protected void initData() {
        mListView = bindView(R.id.column_list_view);

    }

    @Override
    protected void initView() {

        mAdapter = new ColumnAdapter(this);


        StringRequest stringRequest = new StringRequest(URLValues.CLASS_STRATEGY_PART, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                StrategyBean strategyBean = gson.fromJson(response, StrategyBean.class);
                mAdapter.setStrategyBean(strategyBean);
                mListView.setAdapter(mAdapter);

            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleton.getInstance().addRequest(stringRequest);

    }
}
