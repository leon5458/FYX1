package com.fyx.leon.fyx_leon.ui;

import android.content.Intent;
import android.graphics.Camera;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.fyx.leon.fyx_leon.adapter.FyxRecyclerAdapter;
import com.fyx.leon.fyx_leon.base.BaseActivity;
import com.fyx.leon.fyx_leon.base.WViewHolder;
import com.fyx.leon.fyx_leon.bean.JsonBean;
import com.fyx.leon.fyx_leon.utils.BottomPopWindow;
import com.fyx.leon.fyx_leon.utils.GetJsonDataUtil;
import com.fyx.leon.fyx_leon.utils.ToastUtils;
import com.google.gson.Gson;
import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.NiceDialog;
import com.othershe.nicedialog.ViewConvertListener;
import com.othershe.nicedialog.ViewHolder;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.fyx.leon.fyx_leon.ui.R.id.bomb13;


/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/7<p>
 * <p>更改时间：2018/2/7<p>
 * <p>版本号：1<p>
 */
public class BombboxActivity extends BaseActivity {
    @BindView(R.id.bomb13)
    TextView showtime;

    private TimePickerView time;
    private OptionsPickerView selectcity;
    private OptionsPickerView skidding;


    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();


    private void initJsonData() {//解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(this, "province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }

    }

    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

    @Override
    protected int getLayout() {
        return R.layout.bombbox_layout;
    }

    @Override
    protected void findByid() {
        ButterKnife.bind(this);
        initJsonData();

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void getData() {


    }

    @OnClick({R.id.bomb_one, R.id.bomb_two, R.id.regist, R.id.bomb_four, R.id.change_shop, R.id.call_phone,R.id.cancel_car_server,R.id.birthday,
            R.id.bottom_cancel_carserver, R.id.share, R.id.bomb_nine, R.id.bomb_ten, R.id.bomb11, R.id.bomb12, R.id.bomb13, R.id.bomb14, R.id.bomb15,
            R.id.order,R.id.province,R.id.camera,R.id.progressbar,R.id.menu,R.id.light})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.light:
                Light();
                break;
            case R.id.menu:
                Intent intent = new Intent(BombboxActivity.this,MenuActivity.class);
                startActivity(intent);
                break;
            case R.id.bomb_one:
                BombOne();
                break;
            case R.id.bomb_two:
                BombTwo();
                break;
            case R.id.regist:
                BombThree();
                break;
            case R.id.bomb_four:
                BombFour();
                break;
            case R.id.change_shop:
                ChangeShop();
                break;
            case R.id.cancel_car_server:
                CancelCarSerVer();
                break;
            case R.id.call_phone:
                BombSix();
                break;
            case R.id.birthday:
                Birth();
                break;
            case R.id.bottom_cancel_carserver:
                BottomCancelCarSerVer();
                break;
            case R.id.share:
                Share();
                break;
            case R.id.bomb_nine:
                BombNine();
                break;
            case R.id.bomb_ten:
                View view3 = LayoutInflater.from(BombboxActivity.this).inflate(R.layout.toast_item3, null);
                new ToastUtils(this, view3, Toast.LENGTH_LONG).show();
                break;
            case R.id.bomb11:
                View view1 = LayoutInflater.from(BombboxActivity.this).inflate(R.layout.toast_item2, null);
                new ToastUtils(this, view1, Toast.LENGTH_LONG).show();

                break;
            case R.id.bomb12:
                View view = LayoutInflater.from(BombboxActivity.this).inflate(R.layout.toast_item1, null);
                new ToastUtils(this, view, Toast.LENGTH_LONG).show();
                break;
            case bomb13:
                ShowTime();
                break;
            case R.id.bomb14:
                ShowArea();
                break;
            case R.id.bomb15:
                Skidding();
                break;
            case R.id.order:
                Order();
                break;
            case R.id.province:
                Province();
                break;
            case R.id.camera:
                CameraPhoto();
                break;
            case R.id.progressbar:
                Progress();
                break;
        }
    }

    private void Light() {
        NiceDialog.init()
                .setLayoutId(R.layout.light_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

                    }
                })
                .setWidth(260)
                .setOutCancel(true)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }


    private void Progress() {
        NiceDialog.init()
                .setLayoutId(R.layout.progress_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

                    }
                })
                .setWidth(210)
                .setOutCancel(true)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }



    private void CameraPhoto() {
        View view=LayoutInflater.from(BombboxActivity.this).inflate(R.layout.cameraphoto_item,null,false);
        BottomPopWindow.getInstance().pop(BombboxActivity.this,view).show();
    }

    String province[] = new String[]{
            "沪", "皖", "京", "津", "渝", "冀", "豫", "云", "辽",
            "黑", "湘", "鲁", "新", "苏", "浙", "赣", "卾",
            "桂", "甘", "晋", "蒙", "陕", "吉", "闽", "粤",
            "贵", "青", "藏", "川", "宁", "琼"
    };

    private void Province() {
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,8));
        FyxRecyclerAdapter adapter = new FyxRecyclerAdapter(this,R.layout.pop_province_item,Arrays.asList(province));
        recyclerView.setAdapter(adapter);
        adapter.setCallBack(new FyxRecyclerAdapter.CallBack() {
            @Override
            public <T> void convert(WViewHolder holder, T bean, int position) {
                holder.setText(R.id.province_text, (String) bean);
            }
        });
        adapter.setOnItemClickListner(new FyxRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                BottomPopWindow.getInstance().dismiss();
            }
        });
        BottomPopWindow.getInstance().pop(this, recyclerView).show();
    }
    private void Order() {
        NiceDialog.init()
                .setLayoutId(R.layout.order_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

                    }
                })
                .setWidth(260)
                .setOutCancel(true)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }




    private ArrayList<String> food = new ArrayList<>();
    private ArrayList<String> clothes = new ArrayList<>();
    private ArrayList<String> computer = new ArrayList<>();

    private void Skidding() {
        final String[] food = new String[]{"1万公里定期保养", "20K基础保养", "10K基础保养", "馒头", "包子", "年糕", "油条", "豆浆", "烧饼", "蛋炒饭"};
        skidding = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {

            }
        })
                .setLayoutRes(R.layout.rem_options, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                        TextView tvAdd = (TextView) v.findViewById(R.id.tv_ok);
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                skidding.dismiss();
                            }
                        });
                        tvAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                skidding.dismiss();
                            }
                        });
                    }
                })
                .setSubmitColor(0xFF55DA99)//确定按钮文字颜色
                .setCancelColor(0xFFa9a9a9)//取消按钮文字颜色
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .setCancelText("请选择保养得项目")
                .setSubmitText("确定")
                .setOutSideCancelable(false)// default is true
                .build();

        skidding.setPicker(Arrays.asList(food));
        skidding.show();

    }

    private void ShowArea() {
        selectcity = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
//                String tx = options1Items.get(options1).getPickerViewText() +
//                        options2Items.get(options1).get(options2) +
//                        options3Items.get(options1).get(options2).get(options3);
//                ToastUtils.showToast("tx");
            }
        })
                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .setCancelText("取消")
                .setSubmitText("确定")
                .build();


        selectcity.setPicker(options1Items, options2Items, options3Items);//三级选择器
        selectcity.show();
    }

    private void ShowTime() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(1949, 0, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2100, 11, 28);

        time = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null


            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "", "", "")
                .isCenterLabel(false)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDate(selectedDate)
                .setCancelText("取消")
                .setSubmitText("确定")
                .setRangDate(startDate, endDate)
                .setBackgroundId(0x00FFFFFF) //设置外部遮罩颜色
                .setDecorView(null)
                .build();
        time.show();
    }

    private String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

//    private void BombTen() {
//        NiceDialog.init()
//                .setLayoutId(R.layout.bombten_layout)
//                .setConvertListener(new ViewConvertListener() {
//                    @Override
//                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
//                        holder.setOnClickListener(R.id.close, new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                dialog.dismiss();
//                            }
//                        });
//                    }
//                })
//                .setWidth(210)
//                .setOutCancel(true)
//                .setAnimStyle(R.style.EnterExitAnimation)
//                .show(getSupportFragmentManager());
//
//    }

    private void BombNine() {
        NiceDialog.init()
                .setLayoutId(R.layout.bombnine_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

                    }
                })
                .setWidth(210)
                .setOutCancel(true)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }

    private void Share() {
        NiceDialog.init()
                .setLayoutId(R.layout.bombeight_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        holder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ToastUtils.showToast("分享成功");
                            }
                        });
                    }
                })
                .setDimAmount(0.3f)
                .setShowBottom(true)
                .show(getSupportFragmentManager());

    }

    private void BottomCancelCarSerVer() {
        NiceDialog.init()
                .setLayoutId(R.layout.bombseven_layout)
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

                .setShowBottom(true)
                .show(getSupportFragmentManager());

    }


    private void BombSix() {
        ConfirmDialog.newInstance("2")
                .setMargin(60)
                .setOutCancel(true)
                .show(getSupportFragmentManager());
    }

   private void CancelCarSerVer(){
       ConfirmDialog.newInstance("3")
               .setMargin(60)
               .setOutCancel(true)
               .show(getSupportFragmentManager());
   }

   private void Birth(){
       ConfirmDialog.newInstance("4")
               .setMargin(60)
               .setOutCancel(true)//设置点击外面不消失,可以用false
               .show(getSupportFragmentManager());
   }

    private void ChangeShop() {
        ConfirmDialog.newInstance("1")
                .setMargin(60)
                .setOutCancel(true)
                .show(getSupportFragmentManager());
    }


    private void BombFour() {
        NiceDialog.init()
                .setLayoutId(R.layout.bombfour_layout)
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

    private void BombThree() {
        NiceDialog.init()
                .setLayoutId(R.layout.bombthree_layout)
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

    private void BombTwo() {
        NiceDialog.init()
                .setLayoutId(R.layout.bombtwo_layout)
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


    private void BombOne() {
        NiceDialog.init()
                .setLayoutId(R.layout.bombone_layout)
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
                .setWidth(240)
                .setOutCancel(true)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }


    public static class ConfirmDialog extends BaseNiceDialog {
        private String type;

        public static ConfirmDialog newInstance(String type) {
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            ConfirmDialog dialog = new ConfirmDialog();
            dialog.setArguments(bundle);
            return dialog;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle bundle = getArguments();
            if (bundle == null) {
                return;
            }
            type = bundle.getString("type");
        }


        @Override
        public int intLayoutId() {
            return R.layout.confirm_layout;
        }


        @Override
        public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
            if ("1".equals(type)) {
                holder.setText(R.id.message, "确认更换专属销售店?");
                holder.setText(R.id.cancel, "再想想");
                holder.setText(R.id.ok, "确认更换");
                holder.setTextColor(R.id.ok, (Color.parseColor("#0babfe")));
            } else if ("2".equals(type)) {
                holder.setText(R.id.message, "(021) -6555 5570");
                holder.setText(R.id.cancel, "取消");
                holder.setText(R.id.ok, "呼叫");
                holder.setTextColor(R.id.ok, (Color.parseColor("#0babfe")));
            } else if ("3".equals(type)) {
                holder.setText(R.id.message, "取消取车服务,您需要先选择保养预约时间");
                holder.setText(R.id.cancel, "再想想");
                holder.setText(R.id.ok, "确认更换");
                holder.setTextColor(R.id.ok, (Color.parseColor("#0babfe")));

            } else if ("4".equals(type)) {
                holder.setText(R.id.message, "生日保存以后不能修改,是否确定保存?");
                holder.setText(R.id.cancel, "再想想");
                holder.setText(R.id.ok, "确认保存");
                holder.setTextColor(R.id.ok, (Color.parseColor("#0babfe")));

                holder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                holder.setOnClickListener(R.id.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        }
    }
}
