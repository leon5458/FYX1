package com.fyx.leon.fyx_leon.utils;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/7<p>
 * <p>更改时间：2018/2/7<p>
 * <p>版本号：1<p>
 */
public class BottomPopWindow {

    static BottomSheetDialog bottomSheetDialog;


    public void dismiss() {
        bottomSheetDialog.dismiss();
    }

    public BottomPopWindow pop(Context context, View v) {
        bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(v);
        return this;
    }


    public void show() {
        bottomSheetDialog.show();
    }


    private BottomPopWindow() {
    }

    public static BottomPopWindow getInstance() {
        return InnerPop.bottomPopWindow;
    }

    private static class InnerPop {
        private static BottomPopWindow bottomPopWindow = new BottomPopWindow();
    }

    OnCallBack onBack;

    public void setOnBack(OnCallBack onBack) {
        this.onBack = onBack;
    }

    public interface OnCallBack {
        void back(String Content);
    }


    class Choose {
        private Boolean choose;

        public Boolean getChoose() {
            return choose;
        }

        public void setChoose(Boolean choose) {
            this.choose = choose;
        }
    }
}
