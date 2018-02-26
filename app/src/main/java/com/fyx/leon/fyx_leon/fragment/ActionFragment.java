package com.fyx.leon.fyx_leon.fragment;

import android.content.Intent;
import android.view.View;
import com.fyx.leon.fyx_leon.ui.R;
import com.fyx.leon.fyx_leon.ui.BombboxActivity;
import com.fyx.leon.fyx_leon.ui.CalendarActivity;
import com.fyx.leon.fyx_leon.ui.InfoInputActivity;
import com.fyx.leon.fyx_leon.ui.ProgressBarActivity;

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
public class ActionFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.actionfragment_layout;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this, mView);

    }

    @OnClick({R.id.one, R.id.two, R.id.three, R.id.four})
    public void OnClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.one:
                intent.setClass(mActivity, BombboxActivity.class);
                startActivity(intent);
                break;
            case R.id.two:
                intent.setClass(mActivity, ProgressBarActivity.class);
                startActivity(intent);
                break;

            case R.id.three:
                intent.setClass(mActivity, InfoInputActivity.class);
                startActivity(intent);
                break;
            case R.id.four:
                intent.setClass(mActivity, CalendarActivity.class);
                startActivity(intent);
                break;
        }


    }

}
