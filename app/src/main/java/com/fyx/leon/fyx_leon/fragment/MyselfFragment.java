package com.fyx.leon.fyx_leon.fragment;

import android.content.Intent;
import android.view.View;

import com.fyx.leon.fyx_leon.ui.InformationActivity;
import com.fyx.leon.fyx_leon.ui.R;
import com.fyx.leon.fyx_leon.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/3<p>
 * <p>更改时间：2018/2/3<p>
 * <p>版本号：1<p>
 */
public class MyselfFragment extends BaseFragment{
    @Override
    public int getLayoutId() {
        return R.layout.myselffragment_layout;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this,mView);


    }
    @OnClick({R.id.people_icon})
    public void OnClick(View v){
        switch (v.getId()){
            case R.id.people_icon:
                Intent intent1 = new Intent(mActivity,InformationActivity.class);
                startActivity(intent1);
                break;
        }

    }
}
