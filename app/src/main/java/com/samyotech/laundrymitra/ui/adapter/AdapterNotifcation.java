package com.samyotech.laundrymitra.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterNotificationBinding;
import com.samyotech.laundrymitra.model.NotificationDTO;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import java.util.List;

public class AdapterNotifcation extends RecyclerView.Adapter<AdapterNotifcation.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterNotificationBinding binding;
    Context kContext;
    List<NotificationDTO> popLaundryDTOArrayList;

    public AdapterNotifcation(Context kContext, List<NotificationDTO> popLaundryDTOArrayList) {
        this.kContext = kContext;
        this.popLaundryDTOArrayList = popLaundryDTOArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_notification, parent, false);
        return new MyViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        NotificationDTO item = popLaundryDTOArrayList.get(position);
        holder.binding.title.setText(item.getTitle());
        holder.binding.ctvMessage.setText(item.getMessage());
        try {
            holder.binding.ctvtime.setText(ProjectUtils.convertTimestampDateToTime(Long.parseLong(item.getCreated_at())));
        }catch (NumberFormatException e){

        }
    }

    @Override
    public int getItemCount() {
        return popLaundryDTOArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterNotificationBinding binding;

        public MyViewHolder(@NonNull AdapterNotificationBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
