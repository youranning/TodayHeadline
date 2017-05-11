package bwie.com.todayheadline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bwie.com.todayheadline.frag.FirstTabFragment;

/**
 * Created by Administrator on 2017/5/10.
 */

public class FirstAdapter extends FragmentPagerAdapter{

    public final String[] TITLT={"推荐","热点","北京","视频","社会","娱乐","科技","问答","汽车","财经","军事","体育","段子","美女","国际","趣图","健康","特卖","房产"};

    public FirstAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment=new FirstTabFragment();

        return fragment;

    }

    @Override
    public int getCount() {
        return TITLT.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return TITLT[position];
    }
}
