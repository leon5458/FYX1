package com.fyx.leon.fyx_leon.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.fyx.leon.fyx_leon.base.BaseActivity;
import com.fyx.leon.fyx_leon.fragment.ActionFragment;
import com.fyx.leon.fyx_leon.fragment.HpFragment;
import com.fyx.leon.fyx_leon.fragment.MyselfFragment;
import com.fyx.leon.fyx_leon.fragment.ServiceFragment;
import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.NiceDialog;
import com.othershe.nicedialog.ViewConvertListener;
import com.othershe.nicedialog.ViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    private HpFragment hpFragment;
    private ServiceFragment serviceFragment;
    private ActionFragment actionFragment;
    private MyselfFragment myselfFragment;

    /**
     * framelayout
     */
    @BindView(R.id.hp_bottom_layout)
    View hp_layout;
    @BindView(R.id.service_bottom_layout)
    View service_layout;
    @BindView(R.id.action_bottom_layout)
    View action_layout;
    @BindView(R.id.myself_bottom_layout)
    View myself_layout;

    /**
     * image
     *
     * @return
     */
    @BindView(R.id.hp_bottom_image)
    ImageView hpImage;
    @BindView(R.id.service_bottom_image)
    ImageView serviceImage;
    @BindView(R.id.action_bottom_image)
    ImageView actionImage;
    @BindView(R.id.myself_bottom_image)
    ImageView myselfImage;

    /**
     * text
     *
     * @return
     */
    @BindView(R.id.hp_bottom_text)
    TextView hpText;
    @BindView(R.id.service_bottom_text)
    TextView serviceText;
    @BindView(R.id.action_bottom_text)
    TextView actionText;
    @BindView(R.id.myself_bottom_text)
    TextView myselfText;

    private FragmentManager fragmentManager;//对fragment的管理
    private long exitTime = 0;//退出事件
    /**
     * 防止错误发生会导致fragment重叠
     *
     * @param fragment
     */
    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (hpFragment == null && fragment instanceof HpFragment) {
            hpFragment = (HpFragment) fragment;
        } else if (serviceFragment == null && fragment instanceof ServiceFragment) {
            serviceFragment = (ServiceFragment) fragment;
        } else if (actionFragment == null && fragment instanceof ActionFragment) {
            actionFragment = (ActionFragment) fragment;
        } else if (myselfFragment == null && fragment instanceof MyselfFragment) {
            myselfFragment = (MyselfFragment) fragment;
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void findByid() {
        ButterKnife.bind(this);
        //  FileProvider
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
    }

    @Override
    protected void setListener() {
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void getData() {
        setTabSelection(0);//第一次启动默认的tab(0)
        NiceDialog.init()
                .setLayoutId(R.layout.hp_show_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setWidth(210)
                .setOutCancel(true)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }

    @OnClick({R.id.hp_bottom_layout, R.id.service_bottom_layout, R.id.action_bottom_layout, R.id.myself_bottom_layout})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.hp_bottom_layout:
                setTabSelection(0);
                break;
            case R.id.service_bottom_layout:
                setTabSelection(1);
                break;
            case R.id.action_bottom_layout:
                setTabSelection(2);
                break;
            case R.id.myself_bottom_layout:
                setTabSelection(3);
                break;
        }
    }

    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        clearSelection();//每次选中之前清除掉上次选中的状态
        hideFragments(transaction);
        switch (index) {
            case 0:
                hpImage.setImageResource(R.mipmap.jifen);
                hpText.setTextColor(Color.parseColor("#293754"));
                hp_layout.setBackgroundColor(0xffDFE1E6);
                if (hpFragment == null) {
                    hpFragment = new HpFragment();
                    transaction.add(R.id.content, hpFragment);
                } else {
                    transaction.show(hpFragment);
                }
                break;
            case 1:
                serviceImage.setImageResource(R.mipmap.jifen);
                serviceText.setTextColor(Color.parseColor("#293754"));
                service_layout.setBackgroundColor(0xffDFE1E6);
                if (serviceFragment == null) {
                    serviceFragment = new ServiceFragment();
                    transaction.add(R.id.content, serviceFragment);
                } else {
                    transaction.show(serviceFragment);
                }
                break;
            case 2:
                actionImage.setImageResource(R.mipmap.jifen);
                actionText.setTextColor(Color.parseColor("#293754"));
                action_layout.setBackgroundColor(0xffDFE1E6);
                if (actionFragment == null) {
                    actionFragment = new ActionFragment();
                    transaction.add(R.id.content, actionFragment);
                } else {
                    transaction.show(actionFragment);
                }
                break;

            case 3:
                myselfImage.setImageResource(R.mipmap.jifen);
                myselfText.setTextColor(Color.parseColor("#293754"));
                myself_layout.setBackgroundColor(0xffDFE1E6);
                if (myselfFragment == null) {
                    myselfFragment = new MyselfFragment();
                    transaction.add(R.id.content, myselfFragment);
                } else {
                    transaction.show(myselfFragment);
                }
                break;
        }
        transaction.commitAllowingStateLoss();
    }
    /**
     * 清除所有选中的状态
     */
    private void clearSelection() {
        hpImage.setImageResource(R.mipmap.haoyouqingqiu);
        hpText.setTextColor(Color.parseColor("#82858b"));
        hp_layout.setBackgroundColor(0xffffffff);
        serviceImage.setImageResource(R.mipmap.haoyouqingqiu);
        serviceText.setTextColor(Color.parseColor("#82858b"));
        service_layout.setBackgroundColor(0xffffffff);
        actionImage.setImageResource(R.mipmap.haoyouqingqiu);
        actionText.setTextColor(Color.parseColor("#82858b"));
        action_layout.setBackgroundColor(0xffffffff);
        myselfImage.setImageResource(R.mipmap.haoyouqingqiu);
        myselfText.setTextColor(Color.parseColor("#82858b"));
        myself_layout.setBackgroundColor(0xffffffff);
    }

    /**
     * 将所有的Fragment设置隐藏状态,用于对Fragment执行操作的事务
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (hpFragment != null) {
            transaction.hide(hpFragment);
        }
        if (serviceFragment != null) {
            transaction.hide(serviceFragment);
        }
        if (actionFragment != null) {
            transaction.hide(actionFragment);
        }
        if (myselfFragment != null) {
            transaction.hide(myselfFragment);
        }
    }
    /**
     * 捕捉返回事件按钮
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                this.exitApp();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    /**
     * 退出程序
     */
    private void exitApp() {
        // 判断2次点击事件时间
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }


}
