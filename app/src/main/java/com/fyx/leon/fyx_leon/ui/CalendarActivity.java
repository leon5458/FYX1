package com.fyx.leon.fyx_leon.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fyx.leon.fyx_leon.adapter.FyxRecyclerAdapter;
import com.fyx.leon.fyx_leon.adapter.MyAdapter;
import com.fyx.leon.fyx_leon.base.BaseActivity;
import com.fyx.leon.fyx_leon.base.WViewHolder;
import com.fyx.leon.fyx_leon.bean.CarServiceBean;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/9<p>
 * <p>更改时间：2018/2/9<p>
 * <p>版本号：1<p>
 */
public class CalendarActivity extends BaseActivity implements CalendarView.OnDateSelectedListener,
        CalendarView.OnMonthChangeListener,
        CalendarView.OnYearChangeListener,
        CalendarView.OnDateLongClickListener {

    @BindView(R.id.calendarView)
    CalendarView mCalendarView;

    @BindView(R.id.year)
    TextView mTextYear;

    @BindView(R.id.mouth)
    TextView mTextMouth;

    @BindView(R.id.details_time)
    TextView detailstime;

    @BindView(R.id.recy_time)
    RecyclerView recyclerView;

    @BindView(R.id.moring)
    TextView moring;
    @BindView(R.id.afternoon)
    TextView afternoon;

    String moringtime[] = new String[]{"08:30", "08:45", "09:00", "09:15", "09:30", "09:45",
            "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45"};

    String afternoontime[] = new String[]{"13:30", "13:45", "14:00", "14:15", "14:30", "14:45",
            "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45"};

    @Override
    protected int getLayout() {
        return R.layout.calendar_layout;
    }

    @Override
    protected void findByid() {
        ButterKnife.bind(this);
        initData();

    }

    private void initData() {
        moring.setBackgroundResource(R.drawable.gray_drawable);
        afternoon.setBackgroundResource(R.drawable.white_smalldrawable);
        FyxRecyclerAdapter adapter = new FyxRecyclerAdapter(this, R.layout.recy_time_item, Arrays.asList(moringtime));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setAdapter(adapter);
        adapter.setCallBack(new FyxRecyclerAdapter.CallBack() {
            @Override
            public <T> void convert(WViewHolder holder, T bean, int position) {
                holder.setText(R.id.time_text, (String) bean);
            }
        });
        adapter.setOnItemClickListner(new FyxRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                detailstime.setText(moringtime[position]);
            }
        });
    }

    @Override
    protected void setListener() {
        mCalendarView.setOnYearChangeListener(this);
        mCalendarView.setOnDateSelectedListener(this);
        mCalendarView.setOnMonthChangeListener(this);
        mCalendarView.setOnDateLongClickListener(this);
    }

    @Override
    protected void getData() {
        initTitleBar(R.mipmap.jifen, "服务", R.mipmap.jifen, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        }, null);


        mTextYear.setText(mCalendarView.getCurYear() + "年" + "-");
        mTextMouth.setText(mCalendarView.getCurMonth() + "月");

    }

    @OnClick({R.id.next_mouth, R.id.last_mouth})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.next_mouth:
                mCalendarView.scrollToNext();
                break;
            case R.id.last_mouth:
                mCalendarView.scrollToPre();
                break;
        }

    }
    @OnClick({R.id.afternoon,R.id.moring})
    public void OnClick1(View v){
        switch (v.getId()){
            case R.id.moring:
                initData();
                break;
            case R.id.afternoon:
                afternoon.setBackgroundResource(R.drawable.gray_drawable);
                moring.setBackgroundResource(R.drawable.white_smalldrawable);
                FyxRecyclerAdapter adapter1 = new FyxRecyclerAdapter(this, R.layout.recy_time_item, Arrays.asList(afternoontime));
                recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
                recyclerView.setAdapter(adapter1);
                adapter1.setCallBack(new FyxRecyclerAdapter.CallBack() {
                    @Override
                    public <T> void convert(WViewHolder holder, T bean, int position) {
                        holder.setText(R.id.time_text, (String) bean);
                    }
                });

                adapter1.setOnItemClickListner(new FyxRecyclerAdapter.OnItemClickListner() {
                    @Override
                    public void onItemClickListner(View v, int position) {
                        detailstime.setText(afternoontime[position]);
                    }
                });
                break;
        }

    }


    @Override
    public void onYearChange(int year) {

    }

    @Override
    public void onMonthChange(int year, int month) {

    }

    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        mTextYear.setVisibility(View.VISIBLE);
        mTextMouth.setVisibility(View.VISIBLE);
        mTextYear.setText(calendar.getYear() + "年" + "-");
        mTextMouth.setText(calendar.getMonth() + "月");
    }

    @Override
    public void onDateLongClick(Calendar calendar) {

    }
}
