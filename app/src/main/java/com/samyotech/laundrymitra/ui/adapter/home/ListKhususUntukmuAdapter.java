package com.samyotech.laundrymitra.ui.adapter.home;

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
import com.samyotech.laundrymitra.databinding.AdapterKhususBinding;
import com.samyotech.laundrymitra.databinding.AdapterKhususListBinding;
import com.samyotech.laundrymitra.model.home.KhususUntukmuListDto;
import com.samyotech.laundrymitra.ui.activity.detailkhususuntukmu.DetailKhususUntukmuActivity;

import java.util.List;

public class ListKhususUntukmuAdapter extends RecyclerView.Adapter<ListKhususUntukmuAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterKhususListBinding binding;
    Context kContext;
    List<KhususUntukmuListDto> popLaundryDTOArrayList;

    public ListKhususUntukmuAdapter(Context kContext, List<KhususUntukmuListDto> popLaundryDTOArrayList) {
        this.kContext = kContext;
        this.popLaundryDTOArrayList = popLaundryDTOArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_khusus_list, parent, false);
        return new MyViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.binding.title.setText(popLaundryDTOArrayList.get(position).getTitle());
        holder.binding.tvDate.setText(popLaundryDTOArrayList.get(position).getCreatedAt());

        Glide.with(kContext)

                .load(popLaundryDTOArrayList.get(position).getUrlImage())
                .placeholder(R.drawable.laundryshop)
                .error(R.drawable.laundryshop)
                .into(holder.binding.imgTerlaris);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(holder.itemView.getContext(), DetailKhususUntukmuActivity.class);
                data.putExtra("TITLE",popLaundryDTOArrayList.get(position).getTitle());
                data.putExtra("DESK",popLaundryDTOArrayList.get(position).getDescription());
                data.putExtra("IMAGE",popLaundryDTOArrayList.get(position).getUrlImage());
                data.putExtra("DATE",popLaundryDTOArrayList.get(position).getCreatedAt());
                holder.itemView.getContext().startActivity(data);

            }
        });
    }

    @Override
    public int getItemCount() {
        int showItem;
        int size = popLaundryDTOArrayList.size();

        showItem = Math.min(size, 5);

        return showItem;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterKhususListBinding binding;

        public MyViewHolder(@NonNull AdapterKhususListBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
