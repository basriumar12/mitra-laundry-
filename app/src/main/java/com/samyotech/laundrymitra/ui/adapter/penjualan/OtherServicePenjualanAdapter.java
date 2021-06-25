package com.samyotech.laundrymitra.ui.adapter.penjualan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterServiceMenuBinding;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.ui.activity.penjualan.ServicePenjualanActivity;

import java.util.ArrayList;

public class OtherServicePenjualanAdapter extends RecyclerView.Adapter<OtherServicePenjualanAdapter.MyViewHolder> {
    LayoutInflater layoutInflater;
    AdapterServiceMenuBinding binding;
    Context kContext;
    ServicePenjualanActivity servicePenjualanActivity;
    ArrayList<ServiceItemDto> serviceItemDtos;


    public OtherServicePenjualanAdapter(Context kContext, ArrayList<ServiceItemDto> serviceItemDtos, ServicePenjualanActivity servicePenjualanActivity) {
        this.kContext = kContext;
        this.servicePenjualanActivity = servicePenjualanActivity;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(kContext)
                .load(serviceItemDtos.get(position).getUrlImage())
                .into(holder.binding.ivImageService);
        binding.namaService.setText(serviceItemDtos.get(position).getServiceName());
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
