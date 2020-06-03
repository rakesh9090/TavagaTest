package com.example.tavagatest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tavagatest.R;
import com.example.tavagatest.favDatabase.Task;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Task> listData;

    public CustomListAdapter(Context aContext, List<Task> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup vg) {
        ViewHolder holder;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.fav_detail_layout, null);
            holder = new ViewHolder();
            holder.id = (TextView) v.findViewById(R.id.list_id);
            holder.detail = (TextView) v.findViewById(R.id.list_id);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.id.setText(listData.get(position).getUserId());
        holder.detail.setText(listData.get(position).getTitle());
        return v;
    }
    static class ViewHolder {
        TextView id;
        TextView detail;
    }
}
