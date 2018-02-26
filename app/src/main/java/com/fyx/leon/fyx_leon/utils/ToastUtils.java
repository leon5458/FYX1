package com.fyx.leon.fyx_leon.utils;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fyx.leon.fyx_leon.MyApplication;
/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/7<p>
 * <p>更改时间：2018/2/7<p>
 * <p>版本号：1<p>
 */
public class ToastUtils {

    //吐司部分，只显示一个
    private static Toast mToast;
    private LinearLayout toastView;

    /**
     * 修改原布局的Toast
     */
    public ToastUtils() {
    }

    /**
     * 完全自定义布局Toast
     *
     */
    public ToastUtils(Context context, View view, int duration) {
        mToast = new Toast(context);
        mToast.setView(view);
        mToast.setDuration(duration);
//        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         mToast.setGravity(Gravity.CENTER,0,0);


    }

    /**
     * 向Toast 中添加自定义view
     */
    public ToastUtils addView(View view, int postion) {
        toastView = (LinearLayout) mToast.getView();
        toastView.addView(view, postion);
        return this;
    }

    /**
     * 设置Toast 字体及背景颜色
     */
    public ToastUtils setToastColor(int messageColor, int backgroundColor) {
        View view = mToast.getView();
        if (view != null) {
            TextView message =  view.findViewById(android.R.id.message);
            message.setBackgroundColor(backgroundColor);
            message.setTextColor(messageColor);
        }
        return this;
    }

    /**
     * 设置Toast 字体及背景
     *
     */
    public ToastUtils setToastBackground(int messageColor, int background) {
        View view = mToast.getView();
        if (view != null) {
            TextView message = view.findViewById(android.R.id.message);
            message.setBackgroundResource(background);
            message.setTextColor(messageColor);
        }
        return this;
    }

    /**
     * 短时间显示Toast
     */
    public ToastUtils Short(Context context, CharSequence message) {
        if (mToast == null || (toastView != null && toastView.getChildCount() > 1)) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toastView = null;
        } else {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        return this;
    }

    /**
     * 短时间显示Toast
     */
    public ToastUtils Short(Context context, int message) {
        if (mToast == null || (toastView != null && toastView.getChildCount() > 1)) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toastView = null;
        } else {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        return this;
    }

    /**
     * 长时间显示Toast
     */
    public ToastUtils Long(Context context, CharSequence message) {
        if (mToast == null || (toastView != null && toastView.getChildCount() > 1)) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            toastView = null;
        } else {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        return this;
    }

    /**
     * 长时间显示Toast * * @param context * @param message
     */
    public ToastUtils Long(Context context, int message) {
        if (mToast == null || (toastView != null && toastView.getChildCount() > 1)) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            toastView = null;
        } else {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        return this;
    }

    /**
     * 自定义显示Toast时间 * * @param context * @param message * @param duration
     */
    public ToastUtils Indefinite(Context context, CharSequence message, int duration) {
        if (mToast == null || (toastView != null && toastView.getChildCount() > 1)) {
            mToast = Toast.makeText(context, message, duration);
            toastView = null;
        } else {
            mToast.setText(message);
            mToast.setDuration(duration);
        }
        return this;
    }

    /**
     * 自定义显示Toast时间 * * @param context * @param message * @param duration
     */
    public ToastUtils Indefinite(Context context, int message, int duration) {
        if (mToast == null || (toastView != null && toastView.getChildCount() > 1)) {
            mToast = Toast.makeText(context, message, duration);
            toastView = null;
        } else {
            mToast.setText(message);
            mToast.setDuration(duration);
        }
        return this;
    }

    /**
     * 显示Toast * @return
     */
    public ToastUtils show() {
        mToast.show();
        return this;
    }

    /**
     * 获取Toast * @return
     */
    public Toast getToast() {
        return mToast;
    }

    /**
     *
     * @param text
     */
    public static void showToast(String text) {
        showToast(MyApplication.getInstance(), text, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String text, int duration) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            //加上时间的设置才能保证时间不叠加
            mToast.setDuration(duration);
            mToast.setText(text);
        }
        mToast.show();
    }

    public static void showToast(Context context, int strId, int duration) {
        showToast(context, context.getString(strId), duration);
    }

    /**
     * 获取一个非null的字符串
     *
     * @param text
     * @return
     */
    public static String getText(String text) {
        if (text == null) {
            return "";
        }
        return text;
    }
}
