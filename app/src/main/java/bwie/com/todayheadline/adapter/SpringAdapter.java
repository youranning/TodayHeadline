package bwie.com.todayheadline.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import bwie.com.todayheadline.R;
import bwie.com.todayheadline.bean.TuijianBean;

/**
 * Created by Administrator on 2017/5/10.
 */

public class SpringAdapter extends BaseAdapter {

    List<TuijianBean.DataBean> glist=new ArrayList<>();
    Context context;

    public SpringAdapter(List<TuijianBean.DataBean> glist, Context context) {
        this.glist=glist;
         this.context=context;
    }
    public void addrest(List<TuijianBean.DataBean> glist) {

        this.glist.addAll(glist);
        this.notifyDataSetChanged();

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
        // TODO Auto-generated method stub
        ViewHolder mHolder;
        View view = convertView;
        if (view == null) {
            view = View.inflate(context,R.layout.xlist_item, null);
            mHolder = new ViewHolder();

            mHolder.item_title = (TextView) view.findViewById(R.id.item_title);
            mHolder.item_lable = (TextView) view.findViewById(R.id.item_lable);
            mHolder.item_media_name = (TextView) view.findViewById(R.id.item_media_name);
            mHolder.item_comment_count = (TextView) view.findViewById(R.id.item_comment_count);
            mHolder.right_image = (ImageView) view.findViewById(R.id.item_middle_image);
            mHolder.item_image_0 = (ImageView) view.findViewById(R.id.item_image01);
            mHolder.item_image_1 = (ImageView) view.findViewById(R.id.item_image02);
            mHolder.item_image_2 = (ImageView) view.findViewById(R.id.item_image03);
            mHolder.item_image_layout =(LinearLayout) view.findViewById(R.id.item_image_layout);
            view.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) view.getTag();
        }
        //获取position对应的数据
        TuijianBean.DataBean news = (TuijianBean.DataBean) getItem(position);



        mHolder.item_title.setText(news.getTitle()+"");
        mHolder.item_lable.setText(news.getSource());
        mHolder.item_comment_count.setText("评论" + news.getComment_count());
        List<TuijianBean.DataBean.ImageBean> imgUrlList = news.getImage_list();
        mHolder.item_comment_count.setVisibility(View.VISIBLE);

        if(imgUrlList !=null && imgUrlList.size() !=0){
            if(imgUrlList.size() == 3){
                mHolder.right_image.setVisibility(View.GONE);
                mHolder.item_image_layout.setVisibility(View.VISIBLE);
                Glide.with(context).load(imgUrlList.get(0).getUrl()).dontAnimate().into(mHolder.item_image_0);
                Glide.with(context).load(imgUrlList.get(1).getUrl()).dontAnimate().into(mHolder.item_image_1);
                Glide.with(context).load(imgUrlList.get(2).getUrl()).dontAnimate().into(mHolder.item_image_2);
            }
        }else if (glist.get(position).getMiddle_image()!=null){
            mHolder.right_image.setVisibility(View.VISIBLE);
            mHolder.item_image_layout.setVisibility(View.GONE);
            Glide.with(context).load(glist.get(position).getMiddle_image().getUrl()).dontAnimate().into(mHolder.right_image);
        }
        return view;
    }

    static class ViewHolder {
        //title
        TextView item_title;
        //新闻源
        TextView item_media_name;
        //类似推广之类的标签
        TextView item_lable;
        //评论数量
        TextView item_comment_count;
        //右边图片
        ImageView right_image;
        //3张图片布局
        LinearLayout item_image_layout; //3张图片时候的布局
        ImageView item_image_0;
        ImageView item_image_1;
        ImageView item_image_2;
        //大图的图片的话布局
        ImageView large_image;
        //评论布局
        RelativeLayout comment_layout;
        TextView comment_content;
    }

}
