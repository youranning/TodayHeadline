package bwie.com.todayheadline.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bumptech.glide.util.Util;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import bwie.com.todayheadline.R;
import bwie.com.todayheadline.adapter.SpringAdapter;
import bwie.com.todayheadline.bean.TuijianBean;
import bwie.com.todayheadline.task.IAsyncTask;
import bwie.com.todayheadline.task.ResponseListener;
import bwie.com.todayheadline.utils.Urls;


/**
 * Created by Administrator on 2017/5/10.
 */

public class FirstTabFragment extends Fragment {

    List<TuijianBean.DataBean> glist=new ArrayList<>();

    private SpringAdapter adapter;
    private SpringView tab_sp;
    private ListView tab_lv;
    int page=1;
    int num=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.firsttab,container,false);
        tab_sp = (SpringView) view.findViewById(R.id.tab_sp);
        tab_lv = (ListView) view.findViewById(R.id.tab_lv);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tab_sp.setHeader(new DefaultHeader(getContext()));
        tab_sp.setFooter(new DefaultFooter(getContext()));
        tab_sp.setType(SpringView.Type.FOLLOW);
        Bundle bundle = getArguments();
         num = bundle.getInt("num");

        getData(Urls.arr[num%Urls.arr.length]);
      /*  adapter = new SpringAdapter(glist,getActivity());
        tab_lv.setAdapter(adapter);*/
        getSpringView();
    }

    private void getSpringView() {

        tab_sp.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
//                glist.clear();
//                page=1;
                getData(Urls.arr[num%Urls.arr.length]);
               /* adapter.addrest(glist);
                tab_sp.onFinishFreshAndLoad();*/
            }
            @Override
            public void onLoadmore() {
//                page++;
                getData(Urls.arr[num%Urls.arr.length]);
              /*  adapter.addrest(glist);
                tab_sp.onFinishFreshAndLoad();*/
            }
        });
    }
    private void getData(String path) {
        Log.e("----",path);
        RequestParams parms=new RequestParams(path);
        x.http().get(parms, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(result);
                Gson gson=new Gson();
                TuijianBean tuiJian = gson.fromJson(result,  TuijianBean.class);
                List<TuijianBean.DataBean> data = tuiJian.getData();
                adapter = new SpringAdapter(data,getActivity());
                tab_lv.setAdapter(adapter);

              /*  glist.addAll(data);
                adapter.notifyDataSetChanged();*/
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
