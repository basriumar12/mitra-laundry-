package com.samyotech.laundrymitra.ui.adapter.layanan;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterPelayananBinding;
import com.samyotech.laundrymitra.databinding.AdapterPenjualanBinding;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.model.penjualan.PenjualanItemDto;
import com.samyotech.laundrymitra.ui.activity.layanan.EditServiceActivity;
import com.samyotech.laundrymitra.ui.activity.layanan.ServiceActivity;
import com.samyotech.laundrymitra.ui.fragment.layanan.LayananFragment;
import com.samyotech.laundrymitra.ui.fragment.penjualan.PenjualanFragment;

import java.util.ArrayList;

public class LayananAdapter extends RecyclerView.Adapter<LayananAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterPelayananBinding binding;
    Context kContext;
    LayananFragment layananFragment;
    ArrayList<ServiceItemDto> serviceItemDtos;


    public LayananAdapter(Context kContext, ArrayList<ServiceItemDto> serviceItemDtos, LayananFragment layananFragment) {
        this.kContext = kContext;
        this.layananFragment = layananFragment;
        this.serviceItemDtos =serviceItemDtos;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_pelayanan,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Glide.with(kContext)
                .load(serviceItemDtos.get(position).getUrlImage())
                .into(holder.binding.imgTerlaris);
        holder.binding.namaPenjualan.setText(serviceItemDtos.get(position).getServiceName());
        System.out.println("STATUS " + serviceItemDtos.get(position).getStatus());
        if (serviceItemDtos.get(position).getStatus().equals("0")){
            holder.binding.ubah.setBorderColor(Color.parseColor("#808080"));
            holder.binding.status.setText("Aktifkan");
            holder.binding.ubah.setTextColor(Color.parseColor("#808080"));
            holder.binding.status.setTextColor(Color.parseColor("#000000"));
            holder.binding.namaPenjualan.setTextColor(Color.parseColor("#808080"));
            holder.binding.imgTerlaris.setBackgroundColor(Color.parseColor("#808080"));
        } else if (serviceItemDtos.get(position).getStatus().equals("1")){
            holder.binding.ubah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(kContext, EditServiceActivity.class);
                    intent.putExtra("ServiceId",serviceItemDtos.get(position).getServiceId());
                    kContext.startActivity(intent);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return serviceItemDtos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterPelayananBinding binding;
        public MyViewHolder(@NonNull AdapterPelayananBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
