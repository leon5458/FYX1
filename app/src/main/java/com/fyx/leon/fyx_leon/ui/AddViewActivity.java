package com.fyx.leon.fyx_leon.ui;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.fyx.leon.fyx_leon.base.BaseActivity;
import com.fyx.leon.fyx_leon.view.clipPage.ClipViewPager;
import com.fyx.leon.fyx_leon.view.clipPage.RecyclingPagerAdapter;
import com.fyx.leon.fyx_leon.view.clipPage.ScalePageTransformer;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/15<p>
 * <p>更改时间：2018/3/15<p>
 * <p>版本号：1<p>
 */
public class AddViewActivity extends BaseActivity {
    @BindView(R.id.add_viewpager)
    ClipViewPager mViewPager;

    @BindView(R.id.add_indicator)
    LinearLayout indicatorLayout;

    TubatuAdapter mPagerAdapter;


    @Override
    protected int getLayout() {
        return R.layout.addview_activity_layout;
    }

    @Override
    protected void findByid() {
        ButterKnife.bind(this);
        mViewPager.setPageTransformer(true, new ScalePageTransformer());
        mPagerAdapter = new TubatuAdapter(this);
        mViewPager.setAdapter(mPagerAdapter);
        initData();
    }

    private void initData() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list.add(R.mipmap.img);
        }


        //设置OffscreenPageLimit
        mViewPager.setOffscreenPageLimit(Math.min(list.size(), 3));
        mPagerAdapter.addAll(list);
    }

    @Override
    protected void setListener() {
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
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setTag(position);
            imageView.setImageResource(mList.get(position));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addView();
                }
            });
            return imageView;
        }

        private void addView() {
            List<Integer> list = new ArrayList<>();


        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }
}
