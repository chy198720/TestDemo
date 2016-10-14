package com.lanou3g.testdemo.home;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.BaseActivity;
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
 * <p/>
 * Created by 程洪运 on 16/9/20.
 */
public class EtActivity extends BaseActivity implements OnClickListener {

    private EditText mEditText;
    private TextView mTextView;
    private GridView mGridView;
    private EtAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_et;
    }

    @Override
    protected void initData() {
        mEditText = bindView(R.id.et_text);
        mTextView = bindView(R.id.text_et);
        mGridView = bindView(R.id.et_Grid_view);
        mTextView.setOnClickListener(this);
    }

    @Override
    protected void initView() {

        mAdapter = new EtAdapter(this);
        final ArrayList<BoxBean> boxBeen = new ArrayList<>();

        StringRequest mStringRequests = new StringRequest(URLValues.EDITTEXT, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson mGson = new Gson();
                BoxBean boxBean = mGson.fromJson(response, BoxBean.class);
                mEditText.setHint(boxBean.getData().getPlaceholder());
                mEditText.setTextSize(10);
                for (int i = 0; i < boxBean.getData().getHot_words().size(); i++) {
                    boxBeen.add(boxBean);
                }
                mAdapter.setBoxBeen(boxBeen);
                mGridView.setAdapter(mAdapter);
            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });

        VolleySingleton.getInstance().addRequest(mStringRequests);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_et:

                break;
        }
    }
}
