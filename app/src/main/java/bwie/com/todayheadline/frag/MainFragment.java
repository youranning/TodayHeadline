package bwie.com.todayheadline.frag;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioButton;

import bwie.com.todayheadline.R;

public class MainFragment extends Fragment implements View.OnClickListener {


    private RadioGroup mainGroup;
    private RadioButton mainFirst;
    private RadioButton mainVideo;
    private RadioButton mainHead;
    private RadioButton mainLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mainGroup = (RadioGroup) view.findViewById(R.id.main_group);
        mainFirst = (RadioButton) view.findViewById(R.id.main_first);
        mainVideo = (RadioButton) view.findViewById(R.id.main_video);
        mainHead = (RadioButton) view.findViewById(R.id.main_head);
        mainLogin = (RadioButton) view.findViewById(R.id.main_login);
        mainFirst.setOnClickListener(this);
        mainVideo.setOnClickListener(this);
        mainHead.setOnClickListener(this);
        mainLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.main_first:
                break;
            case R.id.main_head:
                break;
            case R.id.main_login:
                break;
            case R.id.main_video:
                break;
        }
    }
}
