package com.lanou3g.testdemo.classification.strategy.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.classification.strategy.bean.StrategyItemBean;
import com.lanou3g.testdemo.base.MyApp;
import com.lanou3g.testdemo.task.NetTool;

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
public class StrategyItemListAdapter extends BaseAdapter {
    private StrategyItemBean lmSkipEntity;

    public void setLmSkipEntity(StrategyItemBean lmSkipEntity) {
        this.lmSkipEntity = lmSkipEntity;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return lmSkipEntity.getData().getPosts().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(MyApp.getContext());
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_lm_lvtwo, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        NetTool tool = new NetTool();

            viewHolder.tvLvtwoTitle.setText(lmSkipEntity.getData().getPosts().get(position).getTitle());
            viewHolder.tvLvtwoTitle.setTextColor(Color.BLACK);
            viewHolder.tvLvtwoNickName.setText(lmSkipEntity.getData().getPosts().get(position).getAuthor().getNickname());
            viewHolder.tvLvtwoLikesCount.setText("" + lmSkipEntity.getData().getPosts().get(position).getLikes_count());
            viewHolder.tvLvtwoLikesCount.setTextColor(Color.BLACK);
            tool.getImg(lmSkipEntity.getData().getPosts().get(position).getCover_image_url(), viewHolder.ivLvtwo);
        return convertView;
    }

    public class ViewHolder {
        ImageView ivLvtwo;
        TextView tvLvtwoTitle;
        TextView tvLvtwoNickName;
        TextView tvLvtwoLikesCount;

        public ViewHolder(View view) {
            ivLvtwo = (ImageView) view.findViewById(R.id.iv_lvtwo);
            tvLvtwoTitle = (TextView) view.findViewById(R.id.tv_lvtwo_title);
            tvLvtwoNickName = (TextView) view.findViewById(R.id.tv_lvtwo_nickname);
            tvLvtwoLikesCount = (TextView) view.findViewById(R.id.tv_lvtwo_likescount);
        }
    }
}