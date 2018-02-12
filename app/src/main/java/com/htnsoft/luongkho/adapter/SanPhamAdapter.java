package com.htnsoft.luongkho.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.htnsoft.luongkho.R;
import com.htnsoft.luongkho.model.sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by TRUNG VAN on 2/10/2018.
 */

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ItemHolder> {
    Context context;
    ArrayList<sanpham> arrayListsanpham;

    public SanPhamAdapter(Context context, ArrayList<sanpham> arrayListsanpham) {
        this.context = context;
        this.arrayListsanpham = arrayListsanpham;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_san_pham_moi,null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        sanpham sanpham = arrayListsanpham.get(position);
        holder.txttensp.setText(sanpham.getTenSP());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiasp.setText("Giá: " + decimalFormat.format(sanpham.getGiaSP()) +" Đ");
        Picasso.with(context).load(sanpham.getHinhAnhSP()).placeholder(R.drawable.imageplace).error(R.drawable.imageplace).into(holder.imghinhsanpham);
    }

    @Override
    public int getItemCount() {
        return arrayListsanpham.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imghinhsanpham;
        public TextView txttensp, txtgiasp;

        public ItemHolder(View itemView) {
            super(itemView);

            imghinhsanpham = (ImageView) itemView.findViewById(R.id.imgviewhinhanhSP);
            txttensp = (TextView) itemView.findViewById(R.id.txtTenSP);
            txtgiasp = (TextView) itemView.findViewById(R.id.txtGiaSP);
        }
    }
}
