package com.fyx.leon.fyx_leon.fragment;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fyx.leon.fyx_leon.MyApplication;
import com.fyx.leon.fyx_leon.adapter.FyxRecyclerAdapter;
import com.fyx.leon.fyx_leon.adapter.MultiHomeAdapter;
import com.fyx.leon.fyx_leon.base.WViewHolder;
import com.fyx.leon.fyx_leon.bean.CarServiceBean;
import com.fyx.leon.fyx_leon.bean.Hpbean;
import com.fyx.leon.fyx_leon.ui.CityActivity;
import com.fyx.leon.fyx_leon.ui.R;
import com.fyx.leon.fyx_leon.base.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/3<p>
 * <p>更改时间：2018/2/3<p>
 * <p>版本号：1<p>
 */
public class HpFragment extends BaseFragment {
    @BindView(R.id.hp_recycleview)
    RecyclerView mRecyclerView;
    @BindView(R.id.hp_smart)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.hp_city)
    TextView city;

    MultiHomeAdapter multiHomeAdapter;

    List<Hpbean> list = new ArrayList<>();

    MyApplication app;
    String localCity;

    @Override
    public int getLayoutId() {
        return R.layout.hpfragment_layout;
    }


    @OnClick({R.id.hp_city})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.hp_city:
                Intent cityIntent = new Intent(mActivity, CityActivity.class);

                startActivityForResult(cityIntent, CityActivity.CityCode);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) return;
        if (requestCode == CityActivity.CityCode) {
            localCity = data.getStringExtra("city");
            city.setText(localCity);

        }
    }

    @Override
    public void initView() {
        ButterKnife.bind(this, mView);
        initItem1();
        initItem2();
        initItem3();
        initItem4();
        multiHomeAdapter = new MultiHomeAdapter(mActivity, list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(multiHomeAdapter);


        multiHomeAdapter.setOnItemClickListner(new MultiHomeAdapter.OnItemClickListner() {
            @Override
            public void click(int position) {

            }
        });

        multiHomeAdapter.setCallBack(new MultiHomeAdapter.CallBack() {
            @Override
            public void back(RecyclerView.ViewHolder holder, int position, int type) {
                WViewHolder wViewHolder = (WViewHolder) holder;
                switch (type) {
                    case 1:
                        homeItem1(wViewHolder);
                        break;
                    case 2:
                        homeItem2(wViewHolder);
                        break;
                    case 3:
                        homeItem3(wViewHolder);
                        break;
                    case 4:
                        homeItem4(wViewHolder);
                        break;
                }
            }
        });

        smartRefreshLayout.setEnableLoadmore(true);

    }


    private void initItem4() {
        Hpbean item4 = new Hpbean();
        item4.setType(4);
        list.add(item4);
    }

    private void initItem3() {
        Hpbean item3 = new Hpbean();
        item3.setType(3);
        list.add(item3);
    }

    private void initItem2() {
        Hpbean item2 = new Hpbean();
        item2.setType(2);
        list.add(item2);
    }

    private void initItem1() {
        Hpbean item1 = new Hpbean();
        item1.setType(1);
        list.add(item1);

    }


    private void homeItem4(WViewHolder wViewHolder) {
        /**
         * 监听事件
         */
//        wViewHolder.getView(R.id.).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    private void homeItem3(WViewHolder wViewHolder) {
    }


    private void homeItem2(WViewHolder wViewHolder) {
    }

    private void homeItem1(WViewHolder wViewHolder) {
    }


}
