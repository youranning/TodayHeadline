package bwie.com.todayheadline.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.List;

import bwie.com.todayheadline.R;
import bwie.com.todayheadline.bean.TuiJian;
import bwie.com.todayheadline.bean.TuijianBean;

/**
 * Created by Administrator on 2017/5/10.
 */

public class XviewAdapter extends BaseAdapter {

    List<TuijianBean.DataBean> glist;
    Context context;

    public XviewAdapter(List<TuijianBean.DataBean> glist, Context context) {
        this.glist=glist;
         this.context=context;
    }

    @Override
    public int getCount() {
        return glist.size();
    }

    @Override
    public Object getItem(int position) {
        return glist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        List<TuijianBean.DataBean.ImageBean> image_list =glist.get(position).getImage_list();
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context, R.layout.xlist_item,null);
            holder.x_tv_title= (TextView) convertView.findViewById(R.id.x_tv_title);
            holder.x_tv_name= (TextView) convertView.findViewById(R.id.x_tv_name);
            holder.x_tv_count= (TextView)convertView.findViewById(R.id.x_tv_count);
            holder.x_tv_time= (TextView) convertView.findViewById(R.id.x_tv_time);
            holder.x_iv= (ImageView) convertView.findViewById(R.id.x_iv);
            convertView.setTag(holder);
        }else{
           holder= (ViewHolder) convertView.getTag();

        }
        holder.x_tv_title.setText(glist.get(position).getTitle());
        holder.x_tv_name.setText(glist.get(position).getSource());
        holder.x_tv_count.setText(glist.get(position).getComment_count()+" 评论");
        holder.x_tv_time.setText(glist.get(position).getPublish_time()+"小时前");
        x.image().bind(holder.x_iv,"http://p1.pstatp.com/list/1f810003311dae9ed6f2");


        return convertView;
    }

    class ViewHolder{

        TextView x_tv_title;
        ImageView x_iv;
        TextView x_tv_name;
        TextView x_tv_count;
        TextView x_tv_time;
    }


}
