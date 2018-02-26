package com.fyx.leon.fyx_leon.ui;

import android.content.Intent;
import android.view.View;

import com.fyx.leon.fyx_leon.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/9<p>
 * <p>更改时间：2018/2/9<p>
 * <p>版本号：1<p>
 */
public class InfoInputActivity extends BaseActivity{
    @Override
    protected int getLayout() {
        return R.layout.inforinput_layout;
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
    @OnClick({R.id.btn1,R.id.btn2,R.id.btn3})
    public void OnClick(View v){
        switch(v.getId()){
            case R.id.btn1:
              startActivity(new Intent(this,InputActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this,ChangeActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this,TableActivity.class));
                break;

        }
    }
}
