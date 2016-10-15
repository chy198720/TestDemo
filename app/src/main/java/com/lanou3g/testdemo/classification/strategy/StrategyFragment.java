package com.lanou3g.testdemo.classification.strategy;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.BoxBean;
import com.lanou3g.testdemo.home.EtActivity;
import com.lanou3g.testdemo.task.BaseFragment;
import com.lanou3g.testdemo.task.LmClickListener;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.NetTool.NetInterface;
import com.lanou3g.testdemo.task.URLValues;

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
    NetTool mTool = new NetTool();

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

        mTool.getData(URLValues.CLASS_STRATEGY_PART, StrategyBean.class, new NetInterface<StrategyBean>() {
            @Override
            public void onSuccess(StrategyBean strategyBean) {
                StrategyAdapter adapter = new StrategyAdapter();
                adapter.setStrategyBeen(strategyBean);
                GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
                manager.setOrientation(GridLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(manager);
                mRecyclerView.setAdapter(adapter);
                adapter.setClickListener(new LmClickListener() {
                    @Override
                    public void onClick(int id, String title) {
                        Intent intent = new Intent(MyApp.getContext(), StrategyItemActivity.class);
                        intent.putExtra("id", id);
                        intent.putExtra("title", title);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(String errorMsg) {

            }
        });


        // __________________________解析分类_攻略_EditText

        mTool.getData(URLValues.EDITTEXT, BoxBean.class, new NetInterface<BoxBean>() {
            @Override
            public void onSuccess(BoxBean boxBean) {
                mEditText.setHint(boxBean.getData().getPlaceholder());
                mEditText.setTextSize(10);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });


        //____________________解析分类_攻略_品类.风格.对象


        mTool.getData(URLValues.CLASS_STRATEGY_CATEGORY, ExpandBean.class, new NetInterface<ExpandBean>() {
            @Override
            public void onSuccess(ExpandBean expandBean) {
                mGroupList = new ArrayList<String>();
                mChildList = new ArrayList<List<String>>();
                for (int i = 0; i < expandBean.getData().getChannel_groups().size(); i++) {
                    mGroupList.add(expandBean.getData().getChannel_groups().get(i).getName());
                    mChildList.add(mGroupList);
                }
                mChild_item = new ArrayList<List<String>>();
                List<String> item = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 6; j++) {
                        item.add(expandBean.getData().getChannel_groups().get(i).getChannels().get(j).getCover_image_url());
                        mChild_item.add(item);
                    }

                }
                ExpandAdapter adapter = new ExpandAdapter();
                adapter.setGroupList(mGroupList);
                adapter.setChildList(mChildList);
                adapter.setChild_item(mChild_item);
                mExpandableListView.setGroupIndicator(null);
                mExpandableListView.setAdapter(adapter);

                AdapterData();

            }

            @Override
            public void onError(String errorMsg) {

            }
        });
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
