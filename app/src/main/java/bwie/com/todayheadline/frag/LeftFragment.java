package bwie.com.todayheadline.frag;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.FrameLayout;

import bwie.com.todayheadline.R;

public class LeftFragment extends Fragment  {

    private RelativeLayout activityMain;
    private FrameLayout left;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.left, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activityMain = (RelativeLayout) view.findViewById(R.id.activity_main);
        left = (FrameLayout) view.findViewById(R.id.left);
    }

}
