package com.fyx.leon.fyx_leon.ui;

import android.view.View;

import com.fyx.leon.fyx_leon.base.BaseActivity;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/6<p>
 * <p>更改时间：2018/2/6<p>
 * <p>版本号：1<p>
 */
public class InformationActivity extends BaseActivity{




    @Override
    protected int getLayout() {
        return R.layout.information_layout;
    }

    @Override
    protected void findByid() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void getData() {
        initTitleBar(R.mipmap.jifen,"服务",0, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        },null);
    }
}
