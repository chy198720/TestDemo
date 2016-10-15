package com.lanou3g.testdemo.select;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.select.day.DayAdapter;
import com.lanou3g.testdemo.select.day.DayAdapter.OnItemClickListener;
import com.lanou3g.testdemo.select.day.DayBean;
import com.lanou3g.testdemo.task.BaseFragment;
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
 * <p>
 * Created by 程洪运 on 16/10/14.
 */
public class TOPFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private RecyclerViewHeader mHeader;
    private ImageView img;
    private DayAdapter mAdapter;
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


        mTool.getData(URLValues.SELECT_TOP, DayBean.class, new NetInterface<DayBean>() {
            @Override
            public void onSuccess(final DayBean dayBean) {
                mTool.getImg(dayBean.getData().getCover_image(), img);

                DayAdapter adapter = new DayAdapter();
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

