package bwie.com.todayheadline;

import android.app.Application;

import com.igexin.sdk.PushManager;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.DbManager;
import org.xutils.x;

import bwie.com.todayheadline.service.ClientSeriver;
import bwie.com.todayheadline.service.PushService;

/**
 * Created by $USER_NAME on 2017/5/9.
 */

public class MyApplication extends Application {
    DbManager.DaoConfig daoConfig ;

    @Override
    public void onCreate() {

        super.onCreate();
        PushManager.getInstance().registerPushIntentService(this, ClientSeriver.class);
        PushManager.getInstance().initialize(this, PushService.class);
        x.Ext.init(this);
        Config.DEBUG = true;
        UMShareAPI.get(this);
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");

    }

    public void initDB() {
        daoConfig = new DbManager.DaoConfig()
                .setDbName("today.db")    //设置数据库名称
                .setDbVersion(1)  //数据库版本
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
// TODO: ...
                        //  数据库版本号发生了变化  走这个回调

                    }
                });

    }
}
