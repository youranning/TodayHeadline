package bwie.com.todayheadline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwei.slidingmenu.SlidingMenu;
import com.bwei.slidingmenu.app.SlidingActivity;
import com.bwei.slidingmenu.app.SlidingFragmentActivity;

import bwie.com.todayheadline.frag.LeftFragment;
import bwie.com.todayheadline.frag.RightFragment;

public class MainActivity extends SlidingFragmentActivity {

    private SlidingMenu menu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMethod();
    }

    private void initMethod() {
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
    }
}
