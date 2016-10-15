package com.lanou3g.testdemo.home.send;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
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
 * <p/>
 * Created by 程洪运 on 16/9/22.
 */
public class SendAdapter extends BaseAdapter {


    SendBean mSendBeen;

    public void setSendBeen(SendBean sendBeen) {
        mSendBeen = sendBeen;
    }

    @Override
    public int getCount() {
        return mSendBeen.getData().getItems().size();
    }

    @Override
    public Object getItem(int i) {
        return mSendBeen.getData().getItems().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_send, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        NetTool tool = new NetTool();
        tool.getImg(mSendBeen.getData().getItems().get(i).getCover_image_url(), viewHolder.mImg);
        viewHolder.mTv_title.setText(mSendBeen.getData().getItems().get(i).getTitle());
        viewHolder.category_tex.setText(mSendBeen.getData().getItems().get(i).getColumn().getCategory());
        viewHolder.title_tex.setText(mSendBeen.getData().getItems().get(i).getColumn().getTitles());
        viewHolder.nickname_tex.setText(mSendBeen.getData().getItems().get(i).getAuthor().getNickname());
        tool.getImg(mSendBeen.getData().getItems().get(i).getAuthor().getAvatar_url(), viewHolder.img_avatar_url);
        return view;
    }

    class ViewHolder {
        private final ImageView mImg;
        private final TextView mTv_title;

        private final TextView category_tex;
        private final TextView title_tex;
        private final TextView nickname_tex;
        private final ImageView img_avatar_url;

        public ViewHolder(View view) {
            mImg = (ImageView) view.findViewById(R.id.cover_image);
            mTv_title = (TextView) view.findViewById(R.id.title_text);

            category_tex = (TextView) view.findViewById(R.id.category_tex);
            title_tex = (TextView) view.findViewById(R.id.title_tex);
            img_avatar_url = (ImageView) view.findViewById(R.id.img_avatar_url);
            nickname_tex = (TextView) view.findViewById(R.id.nickname_tex);

        }
    }


}
