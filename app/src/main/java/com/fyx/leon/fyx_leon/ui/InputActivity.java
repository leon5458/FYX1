package com.fyx.leon.fyx_leon.ui;

import com.fyx.leon.fyx_leon.base.BaseActivity;
import com.fyx.leon.fyx_leon.view.PswText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/9<p>
 * <p>更改时间：2018/2/9<p>
 * <p>版本号：1<p>
 */
public class InputActivity extends BaseActivity{
    @BindView(R.id.input_pswtext)
    PswText pswText;
    @Override
    protected int getLayout() {
        return R.layout.input_layout;
    }

    @Override
    protected void findByid() {
        ButterKnife.bind(this);
    }

    @Override
    protected void setListener() {
        pswText.setInputCallBack(new PswText.InputCallBack() {
            @Override
            public void onInputFinish(String password) {
            }
        });

    }

    @Override
    protected void getData() {

    }
}
