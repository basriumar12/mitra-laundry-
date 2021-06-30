package com.samyotech.laundrymitra.ui.adapter.penjualan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterDetailPenjualanBinding;
import com.samyotech.laundrymitra.databinding.AdapterPenjualanLayananItemBinding;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanList;
import com.samyotech.laundrymitra.ui.activity.penjualan.DetailPenjualanActivity;
import com.samyotech.laundrymitra.ui.activity.penjualan.ServicePenjualanActivity;

import java.util.ArrayList;

public class PenjualanLayananItemAdapter extends RecyclerView.Adapter<PenjualanLayananItemAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterPenjualanLayananItemBinding binding;
    Context kContext;
    ServicePenjualanActivity servicePenjualanActivity;
    ArrayList<LayananItemDto> layananItemDtos;
    int i = -1, j = 0;



    public PenjualanLayananItemAdapter(Context kContext, ArrayList<LayananItemDto> layananItemDtos, ServicePenjualanActivity servicePenjualanActivity) {
        this.kContext = kContext;
        this.servicePenjualanActivity = servicePenjualanActivity;
        this.layananItemDtos = layananItemDtos;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_penjualan_layanan_item,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder,final int position) {
        holder.binding.ctvDeliverenum.setText(layananItemDtos.get(position).getCount());
        holder.binding.ctvItemName.setText(layananItemDtos.get(position).getItemName());
        Glide.with(kContext)
                .load(layananItemDtos.get(position).getUrlImage())
                .into(holder.binding.ivServiceItem);
        holder.binding.ctvPrice.setText("Rp. " + layananItemDtos.get(position).getPrice());

        holder.binding.ivPLus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                j = Integer.parseInt(holder.binding.ctvDeliverenum.getText().toString().trim());
                j = j + 1;

                holder.binding.ctvDeliverenum.setText(String.valueOf(j));
                layananItemDtos.get(position).setCount(String.valueOf(j));

                servicePenjualanActivity.addData(layananItemDtos.get(position));


            }
        });

        holder.binding.ivMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                j = Integer.parseInt(holder.binding.ctvDeliverenum.getText().toString().trim());
                if (j == 0) {
                } else {
                    j = j - 1;

                    holder.binding.ctvDeliverenum.setText(String.valueOf(j));
                    layananItemDtos.get(position).setCount(String.valueOf(j));

                    servicePenjualanActivity.subData(layananItemDtos.get(position));
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return layananItemDtos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterPenjualanLayananItemBinding binding;
        public MyViewHolder(@NonNull AdapterPenjualanLayananItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
