package com.samyotech.laundrymitra.ui.adapter.penjualan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterServiceMenuBinding;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.ui.activity.penjualan.ServiceMenuActivity;
import com.samyotech.laundrymitra.ui.activity.penjualan.ServicePenjualanActivity;

import java.util.ArrayList;

public class ServiceMenuAdapter extends RecyclerView.Adapter<ServiceMenuAdapter.MyViewHolder>{

    LayoutInflater layoutInflater;
    AdapterServiceMenuBinding binding;
    Context kContext;
    ServiceMenuActivity serviceMenuActivity;
    ArrayList<ServiceItemDto> serviceItemDtos;


    public ServiceMenuAdapter(Context kContext, ArrayList<ServiceItemDto> serviceItemDtos, ServiceMenuActivity serviceMenuActivity) {
        this.kContext = kContext;
        this.serviceMenuActivity = serviceMenuActivity;
        this.serviceItemDtos = serviceItemDtos;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_service_menu, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Glide.with(kContext)
                .load(serviceItemDtos.get(position).getUrlImage())
                .into(holder.binding.ivImageService);
        binding.namaService.setText(serviceItemDtos.get(position).getServiceName());
        binding.ivImageService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(kContext, ServicePenjualanActivity.class);
                intent.putExtra("ServiceData", serviceItemDtos.get(position));
                kContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return serviceItemDtos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterServiceMenuBinding binding;

        public MyViewHolder(@NonNull AdapterServiceMenuBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
