package bwie.com.todayheadline.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import bwie.com.todayheadline.ChannelManger.newsdrag.bean.ChannelItem;
import bwie.com.todayheadline.frag.FirstTabFragment;

/**
 * Created by Administrator on 2017/5/10.
 */

public class FirstAdapter extends FragmentPagerAdapter{

    ArrayList<ChannelItem> list;
    public FirstAdapter(FragmentManager fm,ArrayList<ChannelItem> list) {
        super(fm);
        this.list=list;

    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment=new FirstTabFragment();
        Bundle bundle=new Bundle();

        bundle.putInt("num",position+1);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return list.get(position).getName();
    }
}
