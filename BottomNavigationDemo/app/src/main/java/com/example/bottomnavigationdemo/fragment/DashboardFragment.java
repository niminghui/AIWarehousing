package com.example.bottomnavigationdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bottomnavigationdemo.MyBaseExpandableListAdapter;
import com.example.bottomnavigationdemo.R;
import com.example.bottomnavigationdemo.pojo.Group;
import com.example.bottomnavigationdemo.pojo.Item;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private ArrayList<Group> gData = null;
    private ArrayList<ArrayList<Item>> iData = null;
    private ArrayList<Item> lData = null;
    private ExpandableListView exlist_lol;
    private MyBaseExpandableListAdapter myAdapter = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expandablelistview, container, false);

        //数据准备
        gData = new ArrayList<Group>();
        iData = new ArrayList<ArrayList<Item>>();
        gData.add(new Group("电池"));
        gData.add(new Group("电容及电阻"));
        gData.add(new Group("二极管及晶体管"));

        lData = new ArrayList<Item>();

        //电池组
        lData.add(new Item(R.mipmap.battery,"碱性电池"));
        lData.add(new Item(R.mipmap.battery,"酸性电池"));
        lData.add(new Item(R.mipmap.battery,"有机电解液电池"));
        iData.add(lData);
        //电容及电阻组
        lData = new ArrayList<Item>();
        lData.add(new Item(R.mipmap.capacitance, "无极性可变电容"));
        lData.add(new Item(R.mipmap.capacitance, "无极性固定电容"));
        lData.add(new Item(R.mipmap.capacitance, "有极性电容"));
        lData.add(new Item(R.mipmap.capacitance, "固定电阻"));
        lData.add(new Item(R.mipmap.capacitance, "可调电阻"));
        iData.add(lData);
        //二极管及晶体管组
        lData = new ArrayList<Item>();
        lData.add(new Item(R.mipmap.diode, "点接触型二极管"));
        lData.add(new Item(R.mipmap.diode, "面接触型二极管"));
        lData.add(new Item(R.mipmap.diode, "平面型二极管"));
        lData.add(new Item(R.mipmap.diode, "稳压管"));
        lData.add(new Item(R.mipmap.diode, "光电二极管"));
        iData.add(lData);

        exlist_lol = (ExpandableListView)view.findViewById(R.id.exlist_lol);
        myAdapter = new MyBaseExpandableListAdapter(gData,iData,getActivity());
        exlist_lol.setAdapter(myAdapter);


        //为列表设置点击事件
        exlist_lol.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(), "你点击了：" + iData.get(groupPosition).get(childPosition).getiName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        return view;
    }
}
