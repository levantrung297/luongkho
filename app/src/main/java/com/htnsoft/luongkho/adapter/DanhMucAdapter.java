package com.htnsoft.luongkho.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.htnsoft.luongkho.R;
import com.htnsoft.luongkho.model.danhmuc;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by TRUNG VAN on 2/12/2018.
 */

public class DanhMucAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<danhmuc> DanhMucList;

    public DanhMucAdapter(Context context, int layout, ArrayList<danhmuc> danhMucList) {
        this.context = context;
        this.layout = layout;
        DanhMucList = danhMucList;
    }

    @Override
    public int getCount() {
        return DanhMucList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        TextView txttendanhmuc = (TextView) convertView.findViewById(R.id.txttendanhmuc);
        ImageView imgdanhmuc = (ImageView) convertView.findViewById(R.id.imgdanhmuc);
        danhmuc danhmuc = DanhMucList.get(position);
        txttendanhmuc.setText(danhmuc.getTen());
        Picasso.with(context).load(danhmuc.getHinhAnh()).placeholder(R.drawable.imageplace).error(R.drawable.imageplace).into(imgdanhmuc);
        imgdanhmuc.setImageResource(Integer.parseInt(danhmuc.getHinhAnh()));
        return convertView;
    }
}
