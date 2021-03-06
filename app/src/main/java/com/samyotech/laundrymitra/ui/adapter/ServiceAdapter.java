package com.samyotech.laundrymitra.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ServicesAdapterBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.ShopServicesDTO;
import com.samyotech.laundrymitra.ui.activity.ServiceActivity;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    ServicesAdapterBinding binding;
    Context kContext;
    ArrayList<ShopServicesDTO> servicesDTOArrayList;

    public ServiceAdapter(Context kContext, ArrayList<ShopServicesDTO> servicesDTOArrayList) {
        this.kContext = kContext;
        this.servicesDTOArrayList = servicesDTOArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.services_adapter, parent, false);
        return new MyViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final ShopServicesDTO item = servicesDTOArrayList.get(position);
        holder.binding.namaJasa.setText(item.getService_name());
        Glide.with(kContext).load(Consts.BASE_URL + item.getImage()).placeholder(R.drawable.icon_service_118)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.image);

        holder.binding.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(kContext, ServiceActivity.class);
                in.putExtra(Consts.SHOPSERVICEDTO, item);
                kContext.startActivity(in);
            }
        });

    }

    @Override
    public int getItemCount() {
        return servicesDTOArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ServicesAdapterBinding binding;

        public MyViewHolder(@NonNull ServicesAdapterBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
