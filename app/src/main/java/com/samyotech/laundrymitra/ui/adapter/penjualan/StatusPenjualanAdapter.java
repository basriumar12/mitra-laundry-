package com.samyotech.laundrymitra.ui.adapter.penjualan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterBankBinding;
import com.samyotech.laundrymitra.model.penjualan.StatusPenjualanDto;

import java.util.List;

public class StatusPenjualanAdapter extends RecyclerView.Adapter<StatusPenjualanAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterBankBinding binding;
    Context kContext;
    List<StatusPenjualanDto> popLaundryDTOArrayList;

    private final OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(StatusPenjualanDto item);
    }
    public StatusPenjualanAdapter(Context kContext, List<StatusPenjualanDto> popLaundryDTOArrayList, OnItemClickListener listener) {
        this.kContext = kContext;
        this.popLaundryDTOArrayList = popLaundryDTOArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_bank, parent, false);
        return new MyViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.binding.title.setText(popLaundryDTOArrayList.get(position).getName());
      holder.binding.tvDate.setVisibility(View.GONE);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            listener.onItemClick(popLaundryDTOArrayList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        int showItem;
        int size = popLaundryDTOArrayList.size();


        return size;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterBankBinding binding;

        public MyViewHolder(@NonNull AdapterBankBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
