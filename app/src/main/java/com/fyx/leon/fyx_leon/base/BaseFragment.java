package com.fyx.leon.fyx_leon.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fyx.leon.fyx_leon.ui.R;

/**
 * Created by Administrator on 2017/4/1.
 */
public abstract class BaseFragment extends Fragment {
    public Activity mActivity;
    public View mView;

    private ImageView left_image;
    private TextView center_title;
    private ImageView right_image;

    boolean isLoad = false;
    boolean isInit = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();
        mView = inflater.inflate(getLayoutId(), container, false);

        initView();
        isInit = true;
        isCanLoadData();
        return mView;
    }

    public abstract int getLayoutId();

    public abstract void initView();



    public void initTitleBar(int imageIdLeft,String title, int imageIdRight, View.OnClickListener leftListener, View.OnClickListener rightListener) {
        center_title = mView.findViewById(R.id.tv_title);
        left_image = mView.findViewById(R.id.iv_left);
        right_image = mView.findViewById(R.id.iv_right);

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

    /**
     * 视图是否已经对用户可见，系统的方法
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    //懒加载
    private void isCanLoadData() {
        if (!isInit) {
            return;
        }
        if (getUserVisibleHint() && !isLoad) {//如果可见的话，加载数据
            lazyLoad();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
    }

    //第一次加载的处理
    public void lazyLoad() {

    }

    //页面停止加载的处理
    public void stopLoad() {
    }
}
