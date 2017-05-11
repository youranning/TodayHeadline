package bwie.com.todayheadline.task;

/**
 * Created by Administrator on 2017/5/10.
 */
//网络请求回调
public interface ResponseListener {

    //成功回调
    public void onSuccess(String string);
    //失败回调
    public void onFail();

}
