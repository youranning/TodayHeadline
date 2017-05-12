package bwie.com.todayheadline.frag;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bwie.com.todayheadline.R;
import bwie.com.todayheadline.adapter.XviewAdapter;
import bwie.com.todayheadline.bean.TuiJian;
import bwie.com.todayheadline.bean.TuijianBean;
import bwie.com.todayheadline.task.IAsyncTask;
import bwie.com.todayheadline.task.ResponseListener;
import xunqaing.bwie.com.xlistview.XListView;

/**
 * Created by Administrator on 2017/5/10.
 */

public class FirstTabFragment extends Fragment implements ResponseListener {

    List<TuijianBean.DataBean> glist=new ArrayList<>();

    private XListView tab_xView;

    private XviewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.firsttab,container,false);
        tab_xView = (XListView) view.findViewById(R.id.tab_xView);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getData();
        adapter = new XviewAdapter(glist,getActivity());
        tab_xView.setAdapter(adapter);
    }

    private void getData() {
        String path="http://ic.snssdk.com/2/article/v25/stream/?count=20&min_behot_time=1455521444&bd_city=%E5%8C%97%E4%BA%AC%E5%B8%82&bd_latitude=40.049317&bd_longitude=116.296499&bd_loc_time=1455521401&loc_mode=5&lac=4527&cid=28883&iid=3642583580&device_id=11131669133&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=SCH-I919U&os_api=19&os_version=4.4.2&uuid=285592931621751&openudid=AC9E172CE2490000";
        new IAsyncTask(this).execute(path);
        System.out.println(glist);
    }


    @Override
    public void onSuccess(String string) {

        Gson gson=new Gson();
       TuijianBean tuiJian = gson.fromJson(string,  TuijianBean.class);
       List<TuijianBean.DataBean> data = tuiJian.getData();
      glist.addAll(data);
      adapter.notifyDataSetChanged();

    }

    @Override
    public void onFail() {

    }
}
