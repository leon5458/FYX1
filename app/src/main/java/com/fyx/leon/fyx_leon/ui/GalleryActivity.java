package com.fyx.leon.fyx_leon.ui;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.fyx.leon.fyx_leon.base.BaseActivity;
import com.fyx.leon.fyx_leon.view.clipPage.ClipViewPager;
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
    ClipViewPager mViewPager;
    @BindView(R.id.ga_container)
    RelativeLayout container;
    @BindView(R.id.ga_indicator)
    LinearLayout indicatorLayout;


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
        updateIndicator(0);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageTransformer(true, new GaPageTransformer());
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                updateIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mViewPager.setAdapter(new GaAdapter(GalleryActivity.this));
    }

    List<ImageView> imgs = new ArrayList<>();
    private void updateIndicator(int position) {
        indicatorLayout.removeAllViews();
        imgs.clear();
        for (int i = 0; i < 3; i++) {
            ImageView img = new ImageView(GalleryActivity.this);
            if (i == position) img.setImageResource(R.mipmap.select);
            else img.setImageResource(R.mipmap.unselect);
            img.setPadding(10, 0, 10, 0);
            imgs.add(img);
            indicatorLayout.addView(img);
        }
    }

    @Override
    protected void getData() {
    }

    class GaAdapter extends RecyclingPagerAdapter {
        private final Context mContext;

        public GaAdapter(Context context) {
            mContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            View view;
            if (convertView == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_ga_item, null);
            } else {
                view = convertView;
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShowCenterDialog();
                }
            });

            return view;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }
    }

    private OptionsPickerView Show;

    private void ShowCenterDialog() {
      /*  *
         * 注意自定义PickerView ,在布局中,LineayLayout这个不要删除,已经隐藏了,不影响布局,删除掉
         * 会引起空指针异常
         */
        Show = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {

            }
        }).setLayoutRes(R.layout.showcenterdialog_item, new CustomListener() {
            @Override
            public void customLayout(View v) {
            }
        }).isDialog(true).build();
        Show.show();

    }
}
