package bwie.com.todayheadline;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwei.slidingmenu.SlidingMenu;
import com.bwei.slidingmenu.app.SlidingActivity;
import com.bwei.slidingmenu.app.SlidingFragmentActivity;
import com.umeng.socialize.UMShareAPI;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import bwie.com.todayheadline.frag.FirstFragment;
import bwie.com.todayheadline.frag.HeadFragment;
import bwie.com.todayheadline.frag.LeftFragment;
import bwie.com.todayheadline.frag.LoginFragment;
import bwie.com.todayheadline.frag.MainFragment;
import bwie.com.todayheadline.frag.RightFragment;
import bwie.com.todayheadline.frag.VideoFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    //asdsadsadsad
    private SlidingMenu menu;
    private RadioGroup mainGroup;
    private RadioButton mainFirst;
    private RadioButton mainVideo;
    private RadioButton mainHead;
    private RadioButton mainLogin;
    private FragmentManager manager;
    private FirstFragment first;
    private HeadFragment head;
    private LoginFragment login;
    private VideoFragment video;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //asdfasdfasfdsafd
        setContentView(R.layout.activity_main);
//        initMethod();
        initView();
        initGrayBackgroud();
        manager = getSupportFragmentManager();
        first = (FirstFragment) manager.findFragmentById(R.id.first);
        head = (HeadFragment) manager.findFragmentById(R.id.head);
        video = (VideoFragment) manager.findFragmentById(R.id.video);
        login = (LoginFragment) manager.findFragmentById(R.id.login);
        manager.beginTransaction().hide(head).hide(video).hide(login).show(first).commit();
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

    }
    WindowManager windowManager;
    WindowManager.LayoutParams layoutParams;
    View view;
    public void initGrayBackgroud() {
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);


        layoutParams = new WindowManager.LayoutParams
                (WindowManager.LayoutParams.TYPE_APPLICATION,WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        PixelFormat.TRANSPARENT);

        view = new View(this);

        view.setBackgroundResource(R.color.color_window);

    }


    // 日 夜切换
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainActivityEvent(MyEvENT event){
        System.out.println("isChecked = " + event.isNight());

        if(event.isNight()){
            // 日
            windowManager.removeViewImmediate(view);
        } else  {
            // true 夜
            windowManager.addView(view, layoutParams);

        }
        //对所有的控件取出,设置对应的图片
//        setView();
        //更改字体颜色
//        switchTextViewColor((ViewGroup) getWindow().getDecorView(),event.isWhite());
//
//        IndexFragment indexFragment = (IndexFragment) list.get(0);
//
//        indexFragment.changeMode(event.isWhite());
    }

    private void initView() {

        mainGroup = (RadioGroup) findViewById(R.id.main_group);
        mainFirst = (RadioButton) findViewById(R.id.main_first);
        mainVideo = (RadioButton) findViewById(R.id.main_video);
        mainHead = (RadioButton) findViewById(R.id.main_head);
        mainLogin = (RadioButton) findViewById(R.id.main_login);
        mainFirst.setOnClickListener(this);
        mainVideo.setOnClickListener(this);
        mainHead.setOnClickListener(this);
        mainLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.main_first:
                manager.beginTransaction().hide(head).hide(video).hide(login).show(first).commit();
                break;
            case R.id.main_head:
                manager.beginTransaction().hide(first).hide(video).hide(login).show(head).commit();

                break;
            case R.id.main_login:
                manager.beginTransaction().hide(head).hide(video).hide(first).show(login).commit();

                break;
            case R.id.main_video:
                manager.beginTransaction().hide(head).hide(first).hide(login).show(video).commit();

                break;
        }
    }

   /* private void initMethod() {
        LeftFragment left = new LeftFragment();
        setBehindContentView(R.layout.left);
        menu = getSlidingMenu();
        getSupportFragmentManager().beginTransaction().replace(R.id.left, left);
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        // 设置阴影的宽度
        menu.setShadowWidthRes(R.dimen.shadow_width);
        // 设置slidingmenu边界的阴影图片
        menu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        RightFragment rightMenuFragment = new RightFragment();
//        rightMenuFragment.setShareListener(MainActivity);
        menu.setSecondaryMenu(R.layout.right);

        getSupportFragmentManager().beginTransaction().replace(R.id.right, rightMenuFragment).commit();
    }*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}
