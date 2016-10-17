package com.lanou3g.testdemo.select.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.select.activity.ItemActivity;
import com.lanou3g.testdemo.select.adapter.EveryDayAdapter;
import com.lanou3g.testdemo.select.adapter.EveryDayAdapter.OnItemClickListener;
import com.lanou3g.testdemo.select.bean.EveryDayBean;
import com.lanou3g.testdemo.base.BaseFragment;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.NetTool.NetInterface;
import com.lanou3g.testdemo.base.URLValues;

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
public class EveryDayFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private RecyclerViewHeader mHeader;
    private ImageView img;
    NetTool mTool = new NetTool();

    @Override
    protected int setLayout() {
        return R.layout.fragment_day;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.recycler_Day);
        mHeader = bindView(R.id.header);
        img = bindView(R.id.img);


    }

    @Override
    protected void initData() {


        mTool.getData(URLValues.SELECT_DAY, EveryDayBean.class, new NetInterface<EveryDayBean>() {
            @Override
            public void onSuccess(final EveryDayBean dayBean) {
                mTool.getImg(dayBean.getData().getCover_image(), img);

                EveryDayAdapter adapter = new EveryDayAdapter();
                adapter.setDayBeen(dayBean);
                GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
                mRecyclerView.setLayoutManager(manager);
                mRecyclerView.setAdapter(adapter);
                mHeader.attachTo(mRecyclerView, true);
                adapter.setRecommendOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void OnItemClickListener(View view, int position) {
                        if (dayBean.getData().getItems().get(position).getPurchase_url() != null) {
                            Intent intent = new Intent(context, ItemActivity.class);
                            intent.putExtra("purchase_url", dayBean.getData().getItems().get(position).getPurchase_url());
                            getContext().startActivity(intent);
                        } else {
                            Toast.makeText(context, "接口未找到", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }
}
