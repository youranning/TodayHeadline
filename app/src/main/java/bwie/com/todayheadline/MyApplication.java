package bwie.com.todayheadline;

import android.app.Application;
import android.widget.ImageView;

import com.igexin.sdk.PushManager;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.DbManager;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import bwie.com.todayheadline.ChannelManger.newsdrag.db.SQLHelper;
import bwie.com.todayheadline.service.ClientSeriver;
import bwie.com.todayheadline.service.PushService;

/**
 * Created by $USER_NAME on 2017/5/9.
 */

public class MyApplication extends Application {
    private static MyApplication mAppApplication;
    private SQLHelper sqlHelper;

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


        x.Ext.init(this);
        mAppApplication = this;
        getDaoConfig();
    }

    public static DbManager.DaoConfig daoConfig;

    public static DbManager.DaoConfig getDaoConfig() {
        if (daoConfig == null) {
            daoConfig = new DbManager.DaoConfig()
                    .setDbVersion(1)
                    .setDbName("tt")//设置数据库的名字
                    .setAllowTransaction(true)
                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                        @Override
                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                        }
                    });
        }
        return daoConfig;
    }

    /**
     * 获取Application
     */
    public static MyApplication getApp() {
        return mAppApplication;
    }

    /**
     * 获取数据库Helper
     */
    public SQLHelper getSQLHelper() {
        if (sqlHelper == null)
            sqlHelper = new SQLHelper(mAppApplication);
        return sqlHelper;
    }

    /**
     * 摧毁应用进程时候调用
     */
    public void onTerminate() {
        if (sqlHelper != null)
            sqlHelper.close();
        super.onTerminate();
    }

    public static ImageOptions display(boolean isCircluar) {
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setCircular(isCircluar)
                .setCrop(true)
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                .setFailureDrawableId(R.mipmap.ic_launcher)
                .build();
        return imageOptions;
//        x.image().bind(imageView, iconUrl, imageOptions);
    }

}
