package bwie.com.todayheadline.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import bwie.com.todayheadline.R;

public class MoreActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more);

        findViewById(R.id.more_btnMessage).setOnClickListener(this);
        findViewById(R.id.more_come).setOnClickListener(this);
    }

    private EditText getPhone() {
        return (EditText) findViewById(R.id.phone);
    }

    private EditText getPwd() {
        return (EditText) findViewById(R.id.pwd);
    }





    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.more_btnMessage:

                reist();
                break;
            case R.id.more_come:
                login();
                break;
        }
    }

    private void login() {
//        http://qhb.2dyt.com/Bwei/login?username=110110&password=1234&postkey=1503d
        RequestParams login = new RequestParams("http://qhb.2dyt.com/Bwei/login");
        login.addBodyParameter("username", "110110");
        login.addBodyParameter("password", "1234");
        login.addBodyParameter("postkey", "1503d");
        x.http().get(login, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {
//                http://qhb.2dyt.com/Bwei/login?username=110110&password=1234&postkey=1503d
            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void reist() {
        RequestParams parms = new RequestParams("http://qhb.2dyt.com/Bwei/register");
        parms.addBodyParameter("phone", "110110");
        parms.addBodyParameter("password", "1234");
        parms.addBodyParameter("postkey", "1503d");
//        1 register
//        url:http://qhb.2dyt.com/Bwei/register
//        params: phone password postkey(1503d)
//        return : ret_code 0, error 200 ok
        x.http().get(parms, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
