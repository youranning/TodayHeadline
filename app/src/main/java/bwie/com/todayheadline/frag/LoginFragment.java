package bwie.com.todayheadline.frag;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import bwie.com.todayheadline.R;
import bwie.com.todayheadline.activity.MoreActivity;


public class LoginFragment extends Fragment implements View.OnClickListener {


    private ImageView qq;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        qq = (ImageView) view.findViewById(R.id.login_qq);
        qq.setOnClickListener(this);
        view.findViewById(R.id.login_more).setOnClickListener(this);

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
        Intent intent=new Intent(getActivity(), MoreActivity.class);
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
                String uid = map.get("uid");
                String name = map.get("name");

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
