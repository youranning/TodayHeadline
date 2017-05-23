package bwie.com.todayheadline.frag;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import bwie.com.todayheadline.ChannelManger.newsdrag.bean.ChannelItem;
import bwie.com.todayheadline.ChannelManger.newsdrag.bean.ChannelManage;
import bwie.com.todayheadline.MyApplication;
import bwie.com.todayheadline.MyEvENT;
import bwie.com.todayheadline.MyView.MyEditText;
import bwie.com.todayheadline.R;
import bwie.com.todayheadline.activity.Chonnel;
import bwie.com.todayheadline.adapter.FirstAdapter;
import bwie.com.todayheadline.bean.TableShuaxing;


public class FirstFragment extends Fragment {


    private ViewPager first_pager;
    private TabLayout first_tab;
    private ArrayList<ChannelItem> list;
    private FirstAdapter adapter;
    private MyEditText myEditText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first, null);

        first_tab = (TabLayout) view.findViewById(R.id.first_tab);
        first_pager = (ViewPager) view.findViewById(R.id.first_pager);
        myEditText = (MyEditText) view.findViewById(R.id.pub_title_et);
        view.findViewById(R.id.first_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Chonnel.class);
                startActivity(intent);
            }
        });
        myEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"还不能搜索",Toast.LENGTH_LONG).show();
            }
        });
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = (ArrayList<ChannelItem>) ChannelManage.getManage(MyApplication.getApp().getSQLHelper()).getUserChannel();

        adapter = new FirstAdapter(getChildFragmentManager(), list);
        first_pager.setAdapter(adapter);

        first_tab.setupWithViewPager(first_pager);
        first_tab.setTabTextColors(Color.BLACK, Color.RED);
        first_tab.setSelectedTabIndicatorColor(Color.RED);
        first_tab.setTabMode(TabLayout.MODE_FIXED);


    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainActivityEvent(TableShuaxing tableShuaxing){

        if(tableShuaxing.getNum()==1){
            list.clear();
            list = (ArrayList<ChannelItem>) ChannelManage.getManage(MyApplication.getApp().getSQLHelper()).getUserChannel();

            adapter = new FirstAdapter(getChildFragmentManager(), list);
            first_pager.setAdapter(adapter);

            first_tab.setupWithViewPager(first_pager);
            first_tab.setTabTextColors(Color.BLACK, Color.RED);
            first_tab.setSelectedTabIndicatorColor(Color.RED);
            first_tab.setTabMode(TabLayout.MODE_FIXED);

        }

}}
