package com.lanou3g.testdemo.home.gallery.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.gallery.adapter.HomeEditAdapter;
import com.lanou3g.testdemo.home.gallery.bean.EditBean;
import com.lanou3g.testdemo.base.BaseActivity;
import com.lanou3g.testdemo.home.gallery.fragment.HomeSearchFragment;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.NetTool.NetInterface;
import com.lanou3g.testdemo.base.URLValues;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
public class HomeEditActivity extends BaseActivity implements OnClickListener {

    private EditText mEditText;
    private TextView mTextView;
    private GridView mGridView;
    private String wordUrl;
    NetTool mTool = new NetTool();
    private HomeSearchFragment mSearchFragment;


    @Override
    protected int setLayout() {
        return R.layout.activity_et;
    }

    @Override
    protected void initData() {
//        mEditText = bindView(R.id.et_home_text_activity);
        mTextView = bindView(R.id.text_et);
        mGridView = bindView(R.id.et_Grid_view);
        mTextView.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mEditText = (EditText) findViewById(R.id.et_home_text_activity);
        Log.d("HomeEditActivity", "00000");
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String str = null;
                Log.d("HomeEditActivity", "....");
                try {
                    str = URLEncoder.encode(mEditText.getText().toString(), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                wordUrl = "http://api.liwushuo.com/v2/search/word_completed?keyword=" + str;

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                if (mSearchFragment == null) {
                    mSearchFragment = new HomeSearchFragment();
                }

                if (!mSearchFragment.isVisible()) {
                    transaction.replace(R.id.home_Edit_frame, mSearchFragment);
                    transaction.commit();
                }
                mSearchFragment.setUrl(wordUrl);


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });





        mTool.getData(URLValues.EDITTEXT, EditBean.class, new NetInterface<EditBean>() {
            @Override
            public void onSuccess(EditBean boxBean) {
                HomeEditAdapter adapter = new HomeEditAdapter();
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
                finish();
                break;
        }
    }
}
