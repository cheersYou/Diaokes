package com.example.administrator.diaokes.Shop;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.diaokes.DongTai.Dongtai;
import com.example.administrator.diaokes.R;
import com.example.administrator.diaokes.recyclerView.shopitem;
import com.example.administrator.diaokes.recyclerView.shopitemAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/28.
 */

public class recommend extends Fragment implements OnBannerListener {
    private RecyclerView recyclerView1;
    private List<shopitem> list = new ArrayList<>();
    private shopitemAdapter adapter;
    private Banner banner;
    private ArrayList<Integer> list_path;
    private ArrayList<String> list_title;
    private shopitem[] shopitems = {new shopitem(R.drawable.yuxian6,"中海鱼线",6),new shopitem(R.drawable.fupiao4,"黄奕浮漂",2),new shopitem(R.drawable.yuer5,"亦云饵料",5),
            new shopitem(R.drawable.yugou2,"古香鱼钩",1),new shopitem(R.drawable.peijian5,"北忞配件",10),new shopitem(R.drawable.gan6,"南海鱼杆",90)};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.recommend_layout,container,false);
        recyclerView1 = view.findViewById(R.id.shop_item_recycler);
        banner = (Banner) view.findViewById(R.id.banner);

        inits();

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView1.setLayoutManager(layoutManager);
        adapter = new shopitemAdapter(list,this.getActivity());
        recyclerView1.setAdapter(adapter);

        return view;
    }

    private void inits(){
        list.clear();
        for (int i = 0;i<shopitems.length;i++){
            list.add(shopitems[i]);
        }

        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();

        list_path.add(R.drawable.yuer4);
        list_path.add(R.drawable.gan1);
        list_path.add(R.drawable.peijian1);
        list_path.add(R.drawable.yugou3);
        list_title.add("兴安鱼饵");
        list_title.add("万青鱼杆");
        list_title.add("鱼美人配件");
        list_title.add("金龙鱼钩");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();

    }

    @Override
    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第"+position+"张轮播图");
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
