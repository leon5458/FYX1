package com.fyx.leon.fyx_leon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import com.fyx.leon.fyx_leon.ui.R;
import com.fyx.leon.fyx_leon.utils.Contact;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    private List<Contact> contacts;

    String localCity;

    public ContactsAdapter(List<Contact> contacts, String localCity) {
        this.contacts = contacts;
        this.localCity = localCity;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == 0) {
            view = inflater.inflate(R.layout.city_header, null);
            view.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        } else {
            view = inflater.inflate(R.layout.item_contacts, null);
        }
        ContactsViewHolder viewHolder = new ContactsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, final int position) {

        if (position == 0) {
            initHeaderListner(holder);
        } else {
            Contact contact = contacts.get(position);
            if (position == 1 || !contacts.get(position - 1).getIndex().equals(contact.getIndex())) {
                holder.tvIndex.setVisibility(View.VISIBLE);
                holder.tvIndex.setText(contact.getIndex());
            } else {
                holder.tvIndex.setVisibility(View.GONE);
            }
            holder.tvName.setText(contact.getName());

            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListner.onItemClickListner(v, position);
                }
            });
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return 0;
        return 1;
    }

    @Override
    public int getItemCount() {
        return contacts.size() + 1;
    }

    private void initHeaderListner(ContactsViewHolder holder) {
        TextView city = (TextView) holder.getItemView().findViewById(R.id.city_location);
        city.setText(localCity);
        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerBack.back("");
            }
        });

        holder.getItemView().findViewById(R.id.city_shanghai).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerBack.back("上海市");
            }
        });
        holder.getItemView().findViewById(R.id.city_beijing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerBack.back("北京市");
            }
        });
        holder.getItemView().findViewById(R.id.city_guangzhou).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerBack.back("广州市");
            }
        });
        holder.getItemView().findViewById(R.id.city_shenzhen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerBack.back("深圳市");
            }
        });
        holder.getItemView().findViewById(R.id.city_nanjing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerBack.back("南京市");
            }
        });
        holder.getItemView().findViewById(R.id.city_hangzhou).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerBack.back("杭州市");
            }
        });
        holder.getItemView().findViewById(R.id.city_wuhan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerBack.back("武汉市");
            }
        });
        holder.getItemView().findViewById(R.id.city_qingdao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerBack.back("青岛市");
            }
        });


    }


    class ContactsViewHolder extends RecyclerView.ViewHolder {
        public TextView tvIndex;
        public TextView tvName;
        public View itemView;

        public ContactsViewHolder(View itemView) {
            super(itemView);
            tvIndex = (TextView) itemView.findViewById(R.id.tv_index);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            this.itemView = itemView;
        }

        public View getItemView() {
            return itemView;
        }

    }

    OnItemClickListner onItemClickListner;

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public interface OnItemClickListner {
        void onItemClickListner(View v, int position);
    }

    HeaderCallBack headerBack;

    public void setHeaderBack(HeaderCallBack headerBack) {
        this.headerBack = headerBack;
    }

    public interface HeaderCallBack {
        void back(String str);
    }

}