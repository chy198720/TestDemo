package com.lanou3g.testdemo.classification.strategy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.NetTool;
import com.squareup.picasso.Picasso;

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
 * Created by 程洪运 on 16/10/12.
 */
public class ExpandAdapter extends BaseExpandableListAdapter {


    List<String> groupList = new ArrayList<>();
    List<List<String>> childList = new ArrayList<>();
    List<List<String>> child_item = new ArrayList<>();

    public void setChild_item(List<List<String>> child_item) {
        this.child_item = child_item;
    }


    public void setChildList(List<List<String>> childList) {
        this.childList = childList;
    }

    public void setGroupList(List<String> groupList) {
        this.groupList = groupList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int GroupI) {
        return childList.get(GroupI).size();
    }

    @Override
    public Object getGroup(int GroupI) {
        return groupList.get(GroupI);
    }

    @Override
    public Object getChild(int GroupI, int childI) {
        return childList.get(GroupI).get(childI);
    }

    @Override
    public long getGroupId(int GroupI) {
        return GroupI;
    }

    @Override
    public long getChildId(int GroupI, int childI) {
        return childI;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int GroupI, boolean b, View view, ViewGroup viewGroup) {
        GroupHolder groupHolder = null;
        if (view == null) {
            view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.expand_group, null);
            groupHolder = new GroupHolder();
            groupHolder.mGroup_name = (TextView) view.findViewById(R.id.group_name);
            view.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) view.getTag();
        }
        groupHolder.mGroup_name.setText(groupList.get(GroupI));

        return view;
    }

    @Override
    public View getChildView(int GroupI, int childI, boolean b, View view, ViewGroup viewGroup) {
        ItemHolder itemHolder = null;
        if (view == null) {
            view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.expand_group_item, null);
            itemHolder = new ItemHolder();
            itemHolder.img = (ImageView) view.findViewById(R.id.img);
            itemHolder.imgRider = (ImageView) view.findViewById(R.id.img_raider);
            view.setTag(itemHolder);
        } else {
            itemHolder = (ItemHolder) view.getTag();
        }
        childI = childI + childI;
        NetTool tool = new NetTool();

        if (GroupI == 0) {
            tool.getImg(child_item.get(GroupI).get(childI), itemHolder.img);
            tool.getImg(child_item.get(GroupI).get(childI + 1), itemHolder.imgRider);
        } else if (GroupI == 1) {
            childI = childI + 6;
            tool.getImg(child_item.get(GroupI).get(childI), itemHolder.img);
            tool.getImg(child_item.get(GroupI).get(childI + 1), itemHolder.imgRider);
        } else {
            childI = childI + 12;
            tool.getImg(child_item.get(GroupI).get(childI), itemHolder.img);
            tool.getImg(child_item.get(GroupI).get(childI + 1), itemHolder.imgRider);
        }

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class GroupHolder {
        private TextView mGroup_name;
    }

    class ItemHolder {
        private ImageView img;
        private ImageView imgRider;
    }
}
