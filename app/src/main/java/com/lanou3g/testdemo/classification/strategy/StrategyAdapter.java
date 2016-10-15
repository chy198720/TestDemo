package com.lanou3g.testdemo.classification.strategy;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.LmClickListener;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.NetTool;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

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
 * Created by 程洪运 on 16/9/23.
 */
public class StrategyAdapter extends Adapter<StrategyAdapter.StrategyViewHolder>{
    StrategyBean mStrategyBeen;

    private LmClickListener clickListener;

    public void setClickListener(LmClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setStrategyBeen(StrategyBean strategyBeen) {
        mStrategyBeen = strategyBeen;
    }

    @Override
    public StrategyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_strategy,parent,false);
        StrategyViewHolder viewHolder = new StrategyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StrategyViewHolder holder, final int position) {

        NetTool tool = new NetTool();
        tool.getImg(mStrategyBeen.getData().getColumns().get(position).getBanner_image_url(),holder.mBanner_image_url);
        holder.mTitle_strategy.setText(mStrategyBeen.getData().getColumns().get(position).getTitle());
        holder.mTitle_strategy.setTextColor(Color.BLACK);
        holder.mSubtitle_strategy.setText(mStrategyBeen.getData().getColumns().get(position).getSubtitle());
        holder.mSubtitle_strategy.setTextColor(Color.BLACK);
        holder.mAuthor_strategy.setText(mStrategyBeen.getData().getColumns().get(position).getAuthor());
        holder.mAuthor_strategy.setTextColor(Color.CYAN);
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickListener.onClick
                        (mStrategyBeen.getData().getColumns().get(position).getId()
                                ,mStrategyBeen.getData().getColumns().get(position).getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStrategyBeen.getData().getColumns().size();
    }

    public class StrategyViewHolder extends ViewHolder {

        private final ImageView mBanner_image_url;
        private final TextView mTitle_strategy;
        private final TextView mSubtitle_strategy;
        private final TextView mAuthor_strategy;
        private final LinearLayout mLinearLayout;

        public StrategyViewHolder(View itemView) {
            super(itemView);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.ll_Strategy);
            mBanner_image_url = (ImageView) itemView.findViewById(R.id.banner_image_url_strategy);
            mTitle_strategy = (TextView) itemView.findViewById(R.id.title_strategy);
            mSubtitle_strategy = (TextView) itemView.findViewById(R.id.subtitle_strategy);
            mAuthor_strategy = (TextView) itemView.findViewById(R.id.author_strategy);
        }
    }
}
