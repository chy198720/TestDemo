package com.lanou3g.testdemo.home.gallery.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.gallery.bean.HomeTabBean;
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
 * <p/>
 * Created by 程洪运 on 16/9/21.
 */
public class HomeTabAdapter extends BaseAdapter {


    HomeTabBean mTabBeen;

    public void setTabBeen(HomeTabBean tabBeen) {
        mTabBeen = tabBeen;
    }

    @Override
    public int getCount() {
        return mTabBeen.getData().getItems().size();
    }

    @Override
    public Object getItem(int i) {
        return mTabBeen.getData().getItems().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_tab, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        if (mTabBeen.getData().getItems().get(i).getColumn() != null) {

            NetTool tool = new NetTool();
            tool.getImg(mTabBeen.getData().getItems().get(i).getCover_image_url(), viewHolder.mImg);
            viewHolder.mTv_title.setText(mTabBeen.getData().getItems().get(i).getTitle());
            viewHolder.mTv_title.setTextColor(Color.BLACK);
            viewHolder.category_tex.setText(mTabBeen.getData().getItems().get(i).getColumn().getCategory());
            viewHolder.category_tex.setTextColor(Color.BLACK);
            viewHolder.title_tex.setText(mTabBeen.getData().getItems().get(i).getColumn().getTitles());
            viewHolder.title_tex.setTextColor(Color.BLACK);
            viewHolder.nickname_tex.setText(mTabBeen.getData().getItems().get(i).getAuthor().getNickname());
            viewHolder.nickname_tex.setTextColor(Color.BLACK);
            tool.getImg(mTabBeen.getData().getItems().get(i).getAuthor().getAvatar_url(), viewHolder.img_avatar_url);
        }

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
