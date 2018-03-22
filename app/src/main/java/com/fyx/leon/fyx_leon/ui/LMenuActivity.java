package com.fyx.leon.fyx_leon.ui;

import android.view.MotionEvent;
import android.view.View;

import com.fyx.leon.fyx_leon.base.BaseActivity;
import com.fyx.leon.fyx_leon.utils.lmenu.SlidingMenu;
import com.fyx.leon.fyx_leon.view.AdhesionHorizontalLoader;
import com.fyx.leon.fyx_leon.view.BezierCircle;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/19<p>
 * <p>更改时间：2018/3/19<p>
 * <p>版本号：1<p>
 */
public class LMenuActivity extends BaseActivity {
    private SlidingMenu mMenu;
    private AdhesionHorizontalLoader bezierCircle;

    @Override
    protected int getLayout() {
        return R.layout.lmenu_layout;
    }

    @Override
    protected void findByid() {
        mMenu = (SlidingMenu) findViewById(R.id.id_menu);
        bezierCircle=findViewById(R.id.bezier_view);

    }

    public void toggleMenu(View view) {
        mMenu.toggle();
        bezierCircle.startAnim();
    }


    @Override
    protected void setListener() {

    }

    @Override
    protected void getData() {
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int action = event.getActionMasked();
//        switch (action) {
//            case MotionEvent.ACTION_MOVE:
//                bezierCircle.startAnim();
//        }
//
//        return false;
//    }


}
