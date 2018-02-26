package com.fyx.leon.fyx_leon.ui;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.fyx.leon.fyx_leon.adapter.ContactsAdapter;
import com.fyx.leon.fyx_leon.base.BaseActivity;
import com.fyx.leon.fyx_leon.utils.CityUtils;
import com.fyx.leon.fyx_leon.utils.Contact;
import com.fyx.leon.fyx_leon.view.WaveSideBar;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
public class CityActivity extends BaseActivity {
   @BindView(R.id.city_recycle)
    RecyclerView recyclerView;
    @BindView(R.id.city_sidebar)
    WaveSideBar waveSideBar;

    @Override
    protected int getLayout() {
        return R.layout.city_layout;
    }

    @Override
    protected void findByid() {
        ButterKnife.bind(this);
    }
    ArrayList<Contact> contacts = new ArrayList<>();
    String localCity;

    @Override
    protected void getData() {
        new Thread() {
            @Override
            public void run() {
                contacts.addAll(CityUtils.getInstance().read(CityActivity.this));
                handler.sendEmptyMessage(0);
            }
        }.start();

    }
    ContactsAdapter contactsAdapter;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            contactsAdapter.notifyDataSetChanged();
            waveSideBar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
                @Override
                public void onSelectIndexItem(String index) {
                    for (int i = 0; i < contacts.size(); i++) {
                        if (contacts.get(i).getIndex().equals(index)) {
                            ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                            return;
                        }
                    }
                }
            });
        }
    };
    public static final int CityCode = 0x12;

    public void setActivityBack(String city) {
        Intent intent = getIntent();
        intent.putExtra("city", city);
        setResult(CityCode, intent);
        finish();
    }

    @Override
    protected void setListener() {
        localCity = getIntent().getStringExtra("city");
        recyclerView.setLayoutManager(new LinearLayoutManager(CityActivity.this, LinearLayoutManager.VERTICAL, false));
        contactsAdapter = new ContactsAdapter(contacts, localCity);
        recyclerView.setAdapter(contactsAdapter);
        contactsAdapter.setOnItemClickListner(new ContactsAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                setActivityBack(contacts.get(position).getName());
            }
        });
        contactsAdapter.setHeaderBack(new ContactsAdapter.HeaderCallBack() {
            @Override
            public void back(String str) {
                if (!str.equals(""))
                    setActivityBack(str);
            }
        });
    }


}