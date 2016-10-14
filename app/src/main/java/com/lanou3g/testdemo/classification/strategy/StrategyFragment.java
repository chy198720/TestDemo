package com.lanou3g.testdemo.classification.strategy;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.BoxBean;
import com.lanou3g.testdemo.home.EtActivity;
import com.lanou3g.testdemo.task.BaseFragment;
import com.lanou3g.testdemo.task.LmClickListener;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.URLValues;
import com.lanou3g.testdemo.task.VolleySingleton;

import java.util.ArrayList;
import java.util.List;

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
public class StrategyFragment extends BaseFragment implements OnClickListener {
    private RecyclerView mRecyclerView;
    private EditText mEditText;
    private ExpandableListView mExpandableListView;
    private List<String> mGroupList;
    private List<List<String>> mChildList;
    private List<List<String>> mChild_item;
    private TextView mText_sku;

    @Override
    protected int setLayout() {
        return R.layout.fragment_strategy_home;
    }

    @Override
    protected void initView() {

        mExpandableListView = bindView(R.id.expandable_strategy);
        View viewHeader = LayoutInflater.from(context).inflate(R.layout.fragment_strategy, null);
        mRecyclerView = (RecyclerView) viewHeader.findViewById(R.id.recycler_strategy);
        mEditText = (EditText) viewHeader.findViewById(R.id.edit_strategy);
        mText_sku = (TextView) viewHeader.findViewById(R.id.text_sku);
        mExpandableListView.addHeaderView(viewHeader);
        mEditText.setOnClickListener(this);
        mText_sku.setOnClickListener(this);

    }

    @Override
    protected void initData() {

        // _____________________解析分类_攻略_栏目数据
        final ArrayList<StrategyBean> strategyBeen = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(URLValues.CLASS_STRATEGY_PART, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                StrategyBean bean = gson.fromJson(response, StrategyBean.class);
                for (int i = 0; i < 11; i++) {
                    bean.getData().getColumns().get(i).getBanner_image_url();
                    bean.getData().getColumns().get(i).getTitle();
                    bean.getData().getColumns().get(i).getSubtitle();
                    bean.getData().getColumns().get(i).getAuthor();
                    strategyBeen.add(bean);
                }
                StrategyAdapter adapter = new StrategyAdapter(getContext());
                adapter.setStrategyBeen(strategyBeen);
                GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
                manager.setOrientation(GridLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(manager);
                mRecyclerView.setAdapter(adapter);
                adapter.setClickListener(new LmClickListener() {
                    @Override
                    public void onClick(int id, String title) {
                        Intent intent = new Intent(MyApp.getContext(), LmSkipActivity.class);
                        intent.putExtra("id", id);
                        intent.putExtra("title", title);
                        startActivity(intent);
                    }
                });

            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleton.getInstance().addRequest(stringRequest);


        // __________________________解析分类_攻略_EditText
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


        //____________________解析分类_攻略_品类.风格.对象

        StringRequest request = new StringRequest(URLValues.CLASS_STRATEGY_CATEGORY, new Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ExpandBean bean = gson.fromJson(response, ExpandBean.class);
                mGroupList = new ArrayList<String>();
                mChildList = new ArrayList<List<String>>();
                for (int i = 0; i < bean.getData().getChannel_groups().size(); i++) {
                    mGroupList.add(bean.getData().getChannel_groups().get(i).getName());
                    mChildList.add(mGroupList);
                }
                mChild_item = new ArrayList<List<String>>();
                List<String> item = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 6; j++) {
                        item.add(bean.getData().getChannel_groups().get(i).getChannels().get(j).getCover_image_url());
                        mChild_item.add(item);
                    }

                }
                ExpandAdapter adapter = new ExpandAdapter(getContext());
                adapter.setGroupList(mGroupList);
                adapter.setChildList(mChildList);
                adapter.setChild_item(mChild_item);
                mExpandableListView.setGroupIndicator(null);
                mExpandableListView.setAdapter(adapter);

                AdapterData();

            }


        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(request);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_strategy:
                startActivity(new Intent(getContext(), EtActivity.class));
                break;

            case R.id.text_sku:
                startActivity(new Intent(getContext(), ColumnActivity.class));
                break;
        }
    }

    private void AdapterData() {
        for (int i = 0; i < mGroupList.size(); i++) {
            mExpandableListView.expandGroup(i);
        }
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
    }
}
