package com.fyx.leon.fyx_leon.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;

import com.fyx.leon.fyx_leon.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/12<p>
 * <p>更改时间：2018/3/12<p>
 * <p>版本号：1<p>
 */
public class ProgressDialogActivity extends BaseActivity {

    private ProgressDialog mDialog;

    @Override
    protected int getLayout() {
        return R.layout.progressbar_activity;
    }

    @Override
    protected void findByid() {
        ButterKnife.bind(this);

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void getData() {
    }

    @OnClick({R.id.progress_bar})
    public void OnClick(View v){
        switch(v.getId()){
            case R.id.progress_bar:
                mDialog = new ProgressDialog(ProgressDialogActivity.this,R.style.ProgressDialog_item);
                mDialog.setCancelable(true);//点击外部取消
                mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//设置圆形
                mDialog.show();
        }
    }

}
