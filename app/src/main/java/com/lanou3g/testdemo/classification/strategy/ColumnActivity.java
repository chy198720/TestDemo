package com.lanou3g.testdemo.classification.strategy;

import android.widget.ListView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.BaseActivity;
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
 * Created by 程洪运 on 16/10/12.
 */
public class ColumnActivity extends BaseActivity {
    private ListView mListView;
    NetTool tool = new NetTool();

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

        tool.getData(URLValues.CLASS_STRATEGY_PART, StrategyBean.class, new NetInterface<StrategyBean>() {
            @Override
            public void onSuccess(StrategyBean strategyBean) {
                ColumnAdapter adapter = new ColumnAdapter();
                adapter.setStrategyBean(strategyBean);
                mListView.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }
}
