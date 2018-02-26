package com.fyx.leon.fyx_leon.base;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.fyx.leon.fyx_leon.ui.R;

/**
 * 公用activity
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 初始化Tag
     **/
    public static final String TAG = BaseActivity.class.getName();
    public InputMethodManager manager;

    private ImageView left_image;
    private TextView  center_title;
    private ImageView right_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayout());
        findByid();
        setListener();
        getData();
    }
/*    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
           hideSoftInput();
        }
        return super.onTouchEvent(event);
    }
    public  void hideSoftInput(){
        if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
            manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }*/

    protected abstract int getLayout();

    protected abstract void findByid();

    protected abstract void setListener();

    protected abstract void getData();

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void initTitleBar(int imageIdLeft,String title, int imageIdRight, View.OnClickListener leftListener, View.OnClickListener rightListener) {
        center_title =findViewById(R.id.tv_title);
        left_image = findViewById(R.id.iv_left);
        right_image = findViewById(R.id.iv_right);

        if (imageIdLeft == 0) {
            left_image.setVisibility(View.GONE);
        } else {
            left_image.setVisibility(View.VISIBLE);
            left_image.setImageResource(imageIdLeft);
        }
        if (imageIdRight == 0) {
            right_image.setVisibility(View.GONE);
        } else {
            right_image.setVisibility(View.VISIBLE);
            right_image.setImageResource(imageIdRight);
        }

        if (rightListener != null) {
            right_image.setOnClickListener(rightListener);
        }
        if (leftListener != null) {
            left_image.setOnClickListener(leftListener);
        }
        center_title.setText(title);
    }

}