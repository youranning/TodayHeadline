package bwie.com.todayheadline;

/**
 * Created by $USER_NAME on 2017/5/15.
 */

public class MyEvENT {
    private  boolean night;

    public MyEvENT(boolean night) {
        this.night = night;
    }

    public boolean isNight() {
        return night;
    }

    public void setNight(boolean night) {
        this.night = night;
    }
}
