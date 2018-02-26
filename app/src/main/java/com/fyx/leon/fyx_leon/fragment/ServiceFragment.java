package com.fyx.leon.fyx_leon.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.fyx.leon.fyx_leon.adapter.SeFragmentPagerAdapter;
import com.fyx.leon.fyx_leon.ui.R;
import com.fyx.leon.fyx_leon.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/3<p>
 * <p>更改时间：2018/2/3<p>
 * <p>版本号：1<p>
 */
public class ServiceFragment extends BaseFragment{
    private List<Fragment> fragmentList = new ArrayList<>();

    CarServiceFragment carFragment = new CarServiceFragment();
    SalestoreFragment  saleFragment = new SalestoreFragment();

   @BindView(R.id.service_viewpager)
    ViewPager viewPager;
    @BindView(R.id.servicefragment_tablayout)
    TabLayout tabLayout;


    @Override
    public int getLayoutId() {
        return R.layout.servicefragment_layout;
    }

    @Override
    public void initView() {
        initTitleBar(0,"服务",R.mipmap.haoyouqingqiu, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        },null);

        ButterKnife.bind(this,mView);
        fragmentList.add(carFragment);
        fragmentList.add(saleFragment);
        //设置适配器
        viewPager.setAdapter(new SeFragmentPagerAdapter(getChildFragmentManager(), fragmentList));
        //給viewpager設置標題
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        //关联viewpager
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("车服务");
        tabLayout.getTabAt(1).setText("销售店");
    }




}
