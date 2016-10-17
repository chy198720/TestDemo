package com.lanou3g.testdemo.task;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.lanou3g.testdemo.R;

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
 * Created by 程洪运 on 16/10/17.
 */
public class PullListView extends ListView implements AbsListView.OnScrollListener {
    private final static int RELEASE_To_REFRESH = 0;// 下拉过程的状态值
    private final static int PULL_To_REFRESH = 1;// 从下拉返回到不刷新的状态值
    private final static int REFRESHING = 2;// 正在刷新的状态值
    private final static int DONE = 3;
    private final static int LOADING = 4;
    // 实际的padding的距离与界面上偏移距离的比例
    private final static int RATIO = 3;
    private LayoutInflater inflater;
    // ListView头部下拉刷新的布局
    private LinearLayout headerView;
    private ImageView lvHeaderArrowIv;
    // 定义头部下拉刷新的布局的高度
    private int headerContentHeight;
    private int startY;
    private int state;
    private boolean isBack;
    // 用于保证startY的值在一个完整的touch事件中只被记录一次
    private boolean isRecored;
    private SwipeRefreshLayout.OnRefreshListener refreshListener;
    private boolean isRefreshable;
    private AnimationDrawable animationDrawable;
    private ImageView ivHeader;


    public PullListView(Context context) {
        super(context);
        init(context);
    }

    public PullListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        inflater = LayoutInflater.from(context);
        headerView = (LinearLayout) inflater.inflate(R.layout.pull_list_view, null);
        lvHeaderArrowIv = (ImageView) headerView.findViewById(R.id.pull_Img);
        ivHeader = (ImageView) headerView.findViewById(R.id.pull_Header);
        // 设置下拉刷新图标的最小高度和宽度
        lvHeaderArrowIv.setMinimumWidth(50);
        lvHeaderArrowIv.setMinimumHeight(10);

        measureView(headerView);
        headerContentHeight = headerView.getMeasuredHeight();
        // 设置内边距，正好距离顶部为一个负的整个布局的高度，正好把头部隐藏
        headerView.setPadding(0, -1 * headerContentHeight, 0, 0);

        // 将下拉刷新的布局加入ListView的顶部
        addHeaderView(headerView, null, false);
        // 设置滚动监听事件
        setOnScrollListener(this);

        // 是否正在刷新
        isRefreshable = false;
    }


    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        if (i == 0) {
            isRefreshable = true;
        } else {
            isRefreshable = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isRefreshable) {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (!isRecored) {
                        isRecored = true;
                        startY = (int) ev.getY();// 手指按下时记录当前位置
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if (state != REFRESHING && state != LOADING) {
                        if (state == PULL_To_REFRESH) {
                            state = DONE;
                            changeHeaderViewByState();
                        }
                        if (state == RELEASE_To_REFRESH) {
                            state = REFRESHING;
                            changeHeaderViewByState();
                            onLvRefresh();
                        }
                    }
                    isRecored = false;
                    isBack = false;
                    break;

                case MotionEvent.ACTION_MOVE:
                    int tempY = (int) ev.getY();
                    if (!isRecored) {
                        isRecored = true;
                        startY = tempY;
                    }
                    if (state != REFRESHING && isRecored && state != LOADING) {
                        // 保证在设置padding的过程中，当前的位置一直是在head，否则如果当列表超出屏幕的话，当在上推的时候，列表会同时进行滚动
                        // 可以松手去刷新了
                        if (state == RELEASE_To_REFRESH) {
                            setSelection(0);
                            // 往上推了，推到了屏幕足够掩盖head的程度，但是还没有推到全部掩盖的地步
                            if (((tempY - startY) / RATIO < headerContentHeight)// 由松开刷新状态转变到下拉刷新状态
                                    && (tempY - startY) > 0) {
                                state = PULL_To_REFRESH;
                                changeHeaderViewByState();
                            }
                            // 一下子推到顶了
                            else if (tempY - startY <= 0) {// 由松开刷新状态转变到done状态
                                state = DONE;
                                changeHeaderViewByState();
                            }
                        }
                        // 还没有到达显示松开刷新的时候,DONE或者是PULL_To_REFRESH状态
                        if (state == PULL_To_REFRESH) {
                            setSelection(0);
                            // 下拉到可以进入RELEASE_TO_REFRESH的状态
                            if ((tempY - startY) / RATIO >= headerContentHeight) {// 由done或者下拉刷新状态转变到松开刷新
                                state = RELEASE_To_REFRESH;
                                isBack = true;
                                changeHeaderViewByState();
                            }
                            // 上推到顶了
                            else if (tempY - startY <= 0) {// 由DOne或者下拉刷新状态转变到done状态
                                state = DONE;
                                changeHeaderViewByState();
                            }
                        }
                        // done状态下
                        if (state == DONE) {
                            if (tempY - startY > 0) {
                                state = PULL_To_REFRESH;
                                changeHeaderViewByState();
                            }
                        }
                        // 更新headView的size
                        if (state == PULL_To_REFRESH) {
                            headerView.setPadding(0, -1 * headerContentHeight
                                    + (tempY - startY) / RATIO, 0, 0);
                        }
                        // 更新headView的paddingTop
                        if (state == RELEASE_To_REFRESH) {
                            headerView.setPadding(0, (tempY - startY) / RATIO
                                    - headerContentHeight, 0, 0);
                        }
                    }
                    break;

                default:
                    break;
            }
        }
        return super.onTouchEvent(ev);

    }

    // 当状态改变时候，调用该方法，以更新界面
    private void changeHeaderViewByState() {
        switch (state) {
            case REFRESHING:
                headerView.setPadding(0, 0, 0, 0);
                animationDrawable = (AnimationDrawable) lvHeaderArrowIv.getDrawable();
                animationDrawable.start();

                AnimationSet as = new AnimationSet(true);

                AlphaAnimation aa = new AlphaAnimation(0, 1.0f);
                aa.setDuration(800);
                aa.setRepeatCount(0);
                aa.setFillAfter(true);
                TranslateAnimation ta = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_PARENT, 0,
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_PARENT, -0.5f);
                ta.setDuration(1000);
                ta.setFillAfter(true);
                ta.setRepeatCount(0);
                as.addAnimation(aa);
                as.addAnimation(ta);
                ivHeader.startAnimation(as);
                break;

            case DONE:
                headerView.setPadding(0, -1 * headerContentHeight, 0, 0);
                animationDrawable = (AnimationDrawable) lvHeaderArrowIv.getDrawable();
                animationDrawable.stop();
                break;
        }
    }

    // 此方法直接照搬自网络上的一个下拉刷新的demo，此处是“估计”headView的width以及height
    private void measureView(View child) {
        ViewGroup.LayoutParams params = child.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0,
                params.width);
        int lpHeight = params.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
                    MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0,
                    MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    public void setonRefreshListener(SwipeRefreshLayout.OnRefreshListener refreshListener) {
        this.refreshListener = refreshListener;
        isRefreshable = true;
    }


    public void onRefreshComplete() {
        state = DONE;
        changeHeaderViewByState();
    }

    private void onLvRefresh() {
        if (refreshListener != null) {
            refreshListener.onRefresh();
        }
    }
}