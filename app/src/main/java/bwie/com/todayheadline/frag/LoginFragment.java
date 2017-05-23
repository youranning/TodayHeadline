package bwie.com.todayheadline.frag;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;
import org.xutils.x;

import java.util.Map;

import bwie.com.todayheadline.MyApplication;
import bwie.com.todayheadline.MyEvENT;
import bwie.com.todayheadline.R;
import bwie.com.todayheadline.activity.MoreActivity;
import bwie.com.todayheadline.activity.Settting;


public class LoginFragment extends Fragment implements View.OnClickListener {


    private ImageView qq;
    private CheckBox night_button;
    private ImageView iv_head;
    private TextView tv_name;
    private RelativeLayout relativeLayout;
    private LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        qq = (ImageView) view.findViewById(R.id.login_qq);
        night_button = (CheckBox) view.findViewById(R.id.night_button);
        setNight();
        qq.setOnClickListener(this);
        view.findViewById(R.id.login_more).setOnClickListener(this);
        tv_name = (TextView) view.findViewById(R.id.success_name);
        iv_head = (ImageView) view.findViewById(R.id.success_head);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.login_fail);
        linearLayout = (LinearLayout) view.findViewById(R.id.login_success);
view.findViewById(R.id.bt_setting).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        setting();
    }
});

    }

    private void setting() {
        Intent intent=new Intent(getActivity(), Settting.class);
        startActivity(intent);
    }

    private void setNight() {
        night_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    night_button.setText("护眼模式");

                } else {
                    night_button.setText("正常模式");
                }

                EventBus.getDefault().post(new MyEvENT(isChecked));

            }


        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_qq:
                login();

                break;
            case R.id.login_more:
                more();
                break;
        }
    }

    private void more() {
        Intent intent = new Intent(getActivity(), MoreActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.come, R.anim.out);
    }

    private void login() {

        UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                String name = map.get("name");
                String iconurl=map.get("iconurl");

                tv_name.setText(name);

                x.image().bind(iv_head,iconurl, MyApplication.display(true));
                relativeLayout.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });


    }

}
