package com.lanou3g.testdemo.home;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

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
 * Created by 程洪运 on 16/9/20.
 */
public class EtActivity extends BaseActivity implements OnClickListener {

    private EditText mEditText;
    private TextView mTextView;
    private GridView mGridView;
    NetTool mTool = new NetTool();

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


        mTool.getData(URLValues.EDITTEXT, BoxBean.class, new NetInterface<BoxBean>() {
            @Override
            public void onSuccess(BoxBean boxBean) {
                EtAdapter adapter = new EtAdapter();
                mEditText.setHint(boxBean.getData().getPlaceholder());
                mEditText.setTextSize(10);
                adapter.setBoxBeen(boxBean);
                mGridView.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_et:

                break;
        }
    }
}
