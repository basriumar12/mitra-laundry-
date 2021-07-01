package com.samyotech.laundrymitra.ui.adapter.layanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterLayananItemBinding;
import com.samyotech.laundrymitra.databinding.AdapterPelayananBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.ui.activity.Schedule_Activity;
import com.samyotech.laundrymitra.ui.activity.layanan.DetailLayananItemActivity;
import com.samyotech.laundrymitra.ui.activity.layanan.EditServiceActivity;
import com.samyotech.laundrymitra.ui.fragment.layanan.LayananFragment;

import java.util.ArrayList;

public class LayananItemAdapter extends RecyclerView.Adapter<LayananItemAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterLayananItemBinding binding;
    Context kContext;
    EditServiceActivity editServiceActivity;
    ArrayList<LayananItemDto> layananItemDtos;


    public LayananItemAdapter(Context kContext, ArrayList<LayananItemDto> layananItemDtos, EditServiceActivity editServiceActivity) {
        this.kContext = kContext;
        this.editServiceActivity = editServiceActivity;
        this.layananItemDtos =layananItemDtos;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_layanan_item,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.binding.namaItem.setText(layananItemDtos.get(position).getItemName());
        holder.binding.hargaItem.setText("Rp. " +layananItemDtos.get(position).getPrice());
        holder.binding.layananItemCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(kContext, DetailLayananItemActivity.class);
                in.putExtra("LayananItem", layananItemDtos.get(position));
                kContext.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return layananItemDtos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterLayananItemBinding binding;
        public MyViewHolder(@NonNull AdapterLayananItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
