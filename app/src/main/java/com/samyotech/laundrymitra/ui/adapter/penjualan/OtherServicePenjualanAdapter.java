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
import com.samyotech.laundrymitra.databinding.AdapterServiceMenuBinding;
import com.samyotech.laundrymitra.model.layanan.LayananListDto;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanList;
import com.samyotech.laundrymitra.ui.activity.penjualan.DetailPenjualanActivity;
import com.samyotech.laundrymitra.ui.activity.penjualan.ServiceMenuActivity;
import com.samyotech.laundrymitra.ui.activity.penjualan.ServicePenjualanActivity;

import java.util.ArrayList;

public class OtherServicePenjualanAdapter extends RecyclerView.Adapter<OtherServicePenjualanAdapter.MyViewHolder> {
    LayoutInflater layoutInflater;
    AdapterServiceMenuBinding binding;
    Context kContext;
    ServicePenjualanActivity servicePenjualanActivity;
    ArrayList<LayananListDto> layananListDtos;


    public OtherServicePenjualanAdapter(Context kContext, ArrayList<LayananListDto> layananListDtos, ServicePenjualanActivity servicePenjualanActivity) {
        this.kContext = kContext;
        this.servicePenjualanActivity = servicePenjualanActivity;
        this.layananListDtos = layananListDtos;
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
                .load(layananListDtos.get(position).getUrlImage())
                .into(holder.binding.ivImageService);
        binding.namaService.setText(layananListDtos.get(position).getServiceName());
    }

    @Override
    public int getItemCount() {
        return layananListDtos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterServiceMenuBinding binding;

        public MyViewHolder(@NonNull AdapterServiceMenuBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
