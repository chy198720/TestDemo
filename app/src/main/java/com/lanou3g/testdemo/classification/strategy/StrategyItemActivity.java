package com.lanou3g.testdemo.classification.strategy;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.BaseActivity;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.PullToZoomListView;
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
public class StrategyItemActivity extends BaseActivity implements OnClickListener, OnScrollListener {
    private PullToZoomListView mZoomListView;
    private TextView mTvTitle; //  渐变的标题
    private RelativeLayout mRlTitle; // 渐变的标题栏背景
    private ImageView mIvReturn;
    private String title;

    @Override
    protected int setLayout() {
        return R.layout.fragment_selection;
    }

    @Override
    protected void initView() {
        mZoomListView = bindView(R.id.lv_selection);
        mTvTitle = bindView(R.id.tv_item_selection_title);
        mIvReturn = bindView(R.id.iv_selection_return);
        mRlTitle = bindView(R.id.rl_selection_title);
        mIvReturn.setOnClickListener(this);
        mZoomListView.setOnScrollListener(this);


    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        int id = intent.getIntExtra("id", 0);
        tool().getData(URLValues.LM_SKIP + id + URLValues.LM_SKIP1, StrategyItemBean.class, new NetTool.NetInterface<StrategyItemBean>() {
            @Override
            public void onSuccess(StrategyItemBean lmSkipEntity) {
                View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_lm_head, null);
                TextView tvDescription = (TextView) view.findViewById(R.id.tv_lm_description);
                tvDescription.setText(lmSkipEntity.getData().getDescription());
                StrategyItemListAdapter adapter = new StrategyItemListAdapter();
                adapter.setLmSkipEntity(lmSkipEntity);
                mZoomListView.setAdapter(adapter);
                mZoomListView.addHeaderView(view);
                tool().getImg(lmSkipEntity.getData().getCover_image_url(), mZoomListView.getHeaderView());
                mZoomListView.getHeaderView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_selection_return:
                finish();
                break;
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (view.getChildAt(0) != null) {
            getScroll();
            if (getScroll() <= 0) {
                mTvTitle.setText(null);
                mRlTitle.setBackgroundColor(Color.argb(0, 244, 62, 94));//AGB由相关工具获得，或者美工提供
            } else if (getScroll() > 0 && getScroll() <= 200) {
                float scale = (float) getScroll() / 200;
                float alpha = (255 * scale);
                mRlTitle.setBackgroundColor(Color.argb((int) alpha, 244, 62, 94));
            } else {
                mRlTitle.setBackgroundColor(Color.argb(255, 244, 62, 94));
                float scale = (float) getScroll() / 200;
                float alpha = (255 * scale);

                if (getScroll() > 200 && getScroll() <= 400) {
                    mTvTitle.setText(title);
                    mTvTitle.setTextColor(Color.argb((int) alpha, 255, 255, 255));
                }
                if (getScroll() > 400) {
                    mTvTitle.setText(title);
                    mTvTitle.setTextColor(Color.argb(255, 255, 255, 255));
                }

            }
        }
    }

    public int getScroll() {
        View view = mZoomListView.getChildAt(0);
        if (view == null) {
            return 0;
        }
        int firstVisiblePosition = mZoomListView.getFirstVisiblePosition();
        int top = view.getTop();
        return -top + firstVisiblePosition * mZoomListView.getHeaderView().getHeight();
    }
}

