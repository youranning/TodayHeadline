package bwie.com.todayheadline.frag;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import bwie.com.todayheadline.R;
import bwie.com.todayheadline.adapter.FirstAdapter;


public class FirstFragment extends Fragment  {



    private ViewPager first_pager;
    private TabLayout first_tab;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.first, null);

        first_tab = (TabLayout) view.findViewById(R.id.first_tab);
        first_pager = (ViewPager) view.findViewById(R.id.first_pager);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FirstAdapter adapter=new FirstAdapter(getChildFragmentManager());
        first_pager.setAdapter(adapter);

        first_tab.setupWithViewPager(first_pager);

        first_tab.setTabTextColors(Color.BLACK,Color.RED);


        first_tab.setSelectedTabIndicatorColor(Color.RED);

        first_tab.setTabMode(TabLayout.MODE_FIXED);

    }

}
