package com.example.finalexam;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class PlacesAdapter extends BaseAdapter {
    private ArrayList<Places> data;
    private LayoutInflater inflater;//we need it to connect with the list_row.xml
    private Context mContext;

    public PlacesAdapter(Context context, ArrayList<Places> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.placebook_list, null);
            holder = new ViewHolder();
            holder.plc_name = view.findViewById(R.id.plcTitle);
            holder.cost = view.findViewById(R.id.cost);
            holder.place_img = view.findViewById(R.id.place_img);
            holder.flag = view.findViewById(R.id.flag);
            holder.capital = view.findViewById(R.id.capital);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();
        holder.plc_name.setText(data.get(i).getPois());
        holder.capital.setText(data.get(i).getCapital());
        holder.cost.setText(String.valueOf(data.get(i).getLiving_cost()));
        holder.place_img.setImageResource(data.get(i).getImage1());
        holder.flag.setImageResource(data.get(i).getFlag());
        return view;
    }

    static class ViewHolder {
        private TextView plc_name, cost, capital, total;
        private ImageView place_img, flag;
    }
}
