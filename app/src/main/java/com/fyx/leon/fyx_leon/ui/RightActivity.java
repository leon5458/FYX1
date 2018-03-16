package com.fyx.leon.fyx_leon.ui;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import com.fyx.leon.fyx_leon.base.BaseActivity;
import com.fyx.leon.fyx_leon.view.RightMark;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/12<p>
 * <p>更改时间：2018/3/12<p>
 * <p>版本号：1<p>
 */
public class RightActivity extends BaseActivity {
    @BindView(R.id.right_mark_view)
    RightMark markview;

    @Override
    protected int getLayout() {
        return R.layout.rightmark_activity;
    }

    @Override
    protected void findByid() {
        ButterKnife.bind(this);
    }

    @Override
    protected void setListener() {
        markview.setStrokeWidth(10f);//画笔的粗细
        markview.setColor(Color.parseColor("#FFFFFF"));
    }
    @Override
    protected void getData() {
    }
    @OnClick(R.id.btn)
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                markview.start();
                break;
        }
    }

}
