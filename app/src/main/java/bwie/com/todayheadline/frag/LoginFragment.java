package bwie.com.todayheadline.frag;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import bwie.com.todayheadline.R;


public class LoginFragment extends Fragment implements View.OnClickListener {


    private Button qq;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        qq = (Button) view.findViewById(R.id.login_qq);
        qq.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_qq:
                Toast.makeText(getContext(),"dsadasdsa",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
