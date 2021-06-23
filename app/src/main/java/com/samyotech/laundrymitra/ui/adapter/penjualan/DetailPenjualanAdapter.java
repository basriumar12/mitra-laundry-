package com.samyotech.laundrymitra.ui.adapter.penjualan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterDetailPenjualanBinding;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanList;
import com.samyotech.laundrymitra.ui.activity.penjualan.DetailPenjualanActivity;

import java.util.ArrayList;

public class DetailPenjualanAdapter  extends RecyclerView.Adapter<DetailPenjualanAdapter.MyViewHolder>  {

    LayoutInflater layoutInflater;
    AdapterDetailPenjualanBinding binding;
    Context kContext;
    DetailPenjualanActivity detailPenjualanActivity;
    ArrayList<DetailPenjualanList> detailPenjualanLists;


    public DetailPenjualanAdapter(Context kContext, ArrayList<DetailPenjualanList> detailPenjualanLists, DetailPenjualanActivity detailPenjualanActivity) {
        this.kContext = kContext;
        this.detailPenjualanActivity = detailPenjualanActivity;
        this.detailPenjualanLists = detailPenjualanLists;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_detail_penjualan, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.binding.quantity.setText(detailPenjualanLists.get(position).getQuantity());
        holder.binding.namaItem.setText(detailPenjualanLists.get(position).getItemName());
        holder.binding.harga.setText("Rp." + detailPenjualanLists.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return detailPenjualanLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterDetailPenjualanBinding binding;

        public MyViewHolder(@NonNull AdapterDetailPenjualanBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }

}