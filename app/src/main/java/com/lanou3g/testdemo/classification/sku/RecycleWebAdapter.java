package com.lanou3g.testdemo.classification.sku;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.classification.sku.SKURecycleBean.DataBean.ItemsBean;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.NetTool;

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
 * Created by 程洪运 on 16/10/14.
 */
public class RecycleWebAdapter extends RecyclerView.Adapter<RecycleWebAdapter.RecycleViewHolder>{
    private SKURecycleBean mSKURecycleBean;

    public void setSKURecycleBean(SKURecycleBean SKURecycleBean) {
        this.mSKURecycleBean = SKURecycleBean;
        notifyDataSetChanged();
    }


    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_hot, parent, false);
        RecycleViewHolder viewHolder = new RecycleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        List<ItemsBean> items = new ArrayList<>();
        for (int i = 0; i < mSKURecycleBean.getData().getItems().size(); i++) {
            items.add(mSKURecycleBean.getData().getItems().get(i));
        }

        NetTool tool = new NetTool();
        tool.getImg(mSKURecycleBean.getData().getItems().get(position).getCover_image_url(), holder.ivHotCoverImageUrl);
        holder.tvHotName.setText(mSKURecycleBean.getData().getItems().get(position).getName());
        holder.tvHotPrice.setText("¥" + mSKURecycleBean.getData().getItems().get(position).getPrice());
        holder.tvHotCount.setText("" + mSKURecycleBean.getData().getItems().get(position).getFavorites_count());

    }



    @Override
    public int getItemCount() {
        return mSKURecycleBean.getData().getItems().size();
    }

    public class RecycleViewHolder extends ViewHolder {
        private ImageView ivHotCoverImageUrl; // 大图片
        private TextView tvHotName; // 简单介绍
        private TextView tvHotPrice;// 价格
        private TextView tvHotCount; // 收藏次数

        public RecycleViewHolder(View itemView) {
            super(itemView);
            ivHotCoverImageUrl = (ImageView) itemView.findViewById(R.id.iv_hot_cover_image_url);
            tvHotName = (TextView) itemView.findViewById(R.id.tv_hot_name);
            tvHotPrice = (TextView) itemView.findViewById(R.id.tv_hot_price);
            tvHotCount = (TextView) itemView.findViewById(R.id.tv_hot_count);
        }
    }
}