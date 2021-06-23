package com.samyotech.laundrymitra.ui.adapter.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterChatBinding;
import com.samyotech.laundrymitra.model.chat.ChatListDto;

import java.util.List;

public class ChatAdapterNew extends RecyclerView.Adapter<ChatAdapterNew.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterChatBinding binding;
    Context kContext;
    List<ChatListDto> popLaundryDTOArrayList;

    public ChatAdapterNew(Context kContext, List<ChatListDto> popLaundryDTOArrayList) {
        this.kContext = kContext;
        this.popLaundryDTOArrayList = popLaundryDTOArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_chat, parent, false);
        return new MyViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.title.setText(popLaundryDTOArrayList.get(position).getCustomerName());
        holder.binding.tvDate.setText(popLaundryDTOArrayList.get(position).getJamPesan());
        holder.binding.tvLastChat.setText(popLaundryDTOArrayList.get(position).getPesanTerakhir());

    }

    @Override
    public int getItemCount() {
        return popLaundryDTOArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterChatBinding binding;

        public MyViewHolder(@NonNull AdapterChatBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
