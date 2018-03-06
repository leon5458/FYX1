package com.fyx.leon.fyx_leon.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fyx.leon.fyx_leon.adapter.MyAdapter;
import com.fyx.leon.fyx_leon.base.BaseFragment;
import com.fyx.leon.fyx_leon.bean.CarServiceBean;
import com.fyx.leon.fyx_leon.ui.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/3<p>
 * <p>更改时间：2018/2/3<p>
 * <p>版本号：1<p>
 */
public class CarServiceFragment extends BaseFragment {
    @BindView(R.id.head_banner)
    BGABanner bgaBanner;
    @BindView(R.id.carservice_smart)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.carservice_recycleview)
    RecyclerView mRecyclerView;

    MyAdapter myadapter;

    @Override
    public int getLayoutId() {
        return R.layout.carservicefragment_layout;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this, mView);
        List<CarServiceBean> data = new ArrayList<>();
        for (int i=0;i<10;i++){
            CarServiceBean datalist=new CarServiceBean(R.mipmap.ic_launcher,"你好");
            data.add(datalist);
        }
        myadapter = new MyAdapter<CarServiceBean>(R.layout.carservicefragment_item4, data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(myadapter);

        bgaBanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Glide.with(getActivity())
                        .load(model)
                        .placeholder(R.drawable.indicator_background)
                        .error(R.drawable.indicator_background)
                        .centerCrop()
                        .dontAnimate()
                        .into(itemView);

            }
        });
       //网络图片
       bgaBanner.setData(Arrays.asList("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=693437913,4211414746&fm=27&gp=0.jpg"
                , "http://qianming.vipyl.com/user/webimg/201771/20177194315260.jpg"
                , "http://img0.imgtn.bdimg.com/it/u=2054792767,3910355223&fm=27&gp=0.jpg"),
                Arrays.asList("距离下次保养换有39天", "小清新1", "小清新2"));

    }

}

