package com.fyx.leon.fyx_leon.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fyx.leon.fyx_leon.base.BaseActivity;
import com.fyx.leon.fyx_leon.bean.Card;
import com.fyx.leon.fyx_leon.utils.CardTpye;
import com.fyx.leon.fyx_leon.view.clipPage.GaPageTransformer;
import com.fyx.leon.fyx_leon.view.clipPage.RecyclingPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/6<p>
 * <p>更改时间：2018/3/6<p>
 * <p>版本号：1<p>
 */
public class GalleryActivity extends BaseActivity {
    @BindView(R.id.ga_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.bc_indicator)
    LinearLayout indicatorLayout;

    private TubatuAdapter mPagerAdapter;

    @Override
    protected int getLayout() {
        return R.layout.gallery_activity_layout;
    }

    @Override
    protected void findByid() {
        ButterKnife.bind(this);
    }

    @Override
    protected void setListener() {
        mViewPager.setPageTransformer(true, new GaPageTransformer());
        mPagerAdapter = new TubatuAdapter(this);
        mViewPager.setAdapter(mPagerAdapter);
        initData();
    }

    private void initData() {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.imgs);
        list.add(R.mipmap.img);
        list.add(R.mipmap.bg);
        list.add(R.mipmap.bg);
        list.add(R.mipmap.img);
        list.add(R.mipmap.imgs);

        list.add(R.mipmap.imgs);
        list.add(R.mipmap.img);
        list.add(R.mipmap.bg);
        list.add(R.mipmap.bg);
        list.add(R.mipmap.img);
        list.add(R.mipmap.imgs);
        //设置OffscreenPageLimit
        mViewPager.setOffscreenPageLimit(Math.min(list.size(), 5));
        mPagerAdapter.addAll(list);
    }

    @Override
    protected void getData() {

    }

    public static class TubatuAdapter extends RecyclingPagerAdapter {

        private final List<Integer> mList;
        private final Context mContext;

        public TubatuAdapter(Context context) {
            mList = new ArrayList<>();
            mContext = context;
        }

        public void addAll(List<Integer> list) {
            mList.addAll(list);
            notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            ImageView imageView = null;
            if (convertView == null) {
                imageView = new ImageView(mContext);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setTag(position);
            imageView.setImageResource(mList.get(position));
            return imageView;
        }

        @Override
        public int getCount()      {
            return mList.size();
        }
    }
}
