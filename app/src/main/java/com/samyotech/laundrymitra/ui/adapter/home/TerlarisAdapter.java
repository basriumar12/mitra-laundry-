package com.samyotech.laundrymitra.ui.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterPentingBinding;
import com.samyotech.laundrymitra.model.home.TerlarisHariIniListDto;

import java.util.ArrayList;
import java.util.List;

public class TerlarisAdapter extends RecyclerView.Adapter<TerlarisAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterPentingBinding binding;
    Context kContext;
    List<TerlarisHariIniListDto> popLaundryDTOArrayList;

    public TerlarisAdapter(Context kContext, List<TerlarisHariIniListDto> popLaundryDTOArrayList) {
        this.kContext = kContext;
        this.popLaundryDTOArrayList = popLaundryDTOArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_penting, parent, false);
        return new MyViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.title.setText(popLaundryDTOArrayList.get(position).getServiceName());

        Glide.with(kContext)

                .load(popLaundryDTOArrayList.get(position).getUrlImage())
                .placeholder(R.drawable.laundryshop)
                .error(R.drawable.laundryshop)
                .into(holder.binding.imgTerlaris);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(kContext, "Belum tersedia", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return popLaundryDTOArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterPentingBinding binding;

        public MyViewHolder(@NonNull AdapterPentingBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
