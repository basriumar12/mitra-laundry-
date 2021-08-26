package com.samyotech.laundrymitra.ui.adapter.ulasan;

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
import com.samyotech.laundrymitra.databinding.AdapterUlasanListBinding;
import com.samyotech.laundrymitra.model.ulasandata.UlasanNewDto;
import com.samyotech.laundrymitra.ui.activity.detailkhususuntukmu.DetailKhususUntukmuActivity;

import java.util.List;

public class UlasanAdapter extends RecyclerView.Adapter<UlasanAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterUlasanListBinding binding;
    Context kContext;
    List<UlasanNewDto> popLaundryDTOArrayList;

    public UlasanAdapter(Context kContext, List<UlasanNewDto> popLaundryDTOArrayList) {
        this.kContext = kContext;
        this.popLaundryDTOArrayList = popLaundryDTOArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_ulasan_list, parent, false);
        return new MyViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.binding.title.setText(popLaundryDTOArrayList.get(position).getNamaLayanan());

        if (!popLaundryDTOArrayList.get(position).getRating().isEmpty()
                || !popLaundryDTOArrayList.get(position).getRating().equals("")
                || !popLaundryDTOArrayList.get(position).getRating().equals(null)
        ) {
            holder.binding.tvCount.setText(popLaundryDTOArrayList.get(position).getRating());
            holder.binding.arb.setRating(Float.parseFloat(popLaundryDTOArrayList.get(position).getRating()));
        }
        Glide.with(kContext)

                .load(popLaundryDTOArrayList.get(position).getImage())
                .placeholder(R.drawable.laundryshop)
                .error(R.drawable.laundryshop)
                .into(holder.binding.imgUlasan);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(holder.itemView.getContext(), DetailKhususUntukmuActivity.class);
                data.putExtra("ID", popLaundryDTOArrayList.get(position).getServiceId());
                holder.itemView.getContext().startActivity(data);

            }
        });
    }

    @Override
    public int getItemCount() {
        int showItem;
        int size = popLaundryDTOArrayList.size();

        showItem = Math.min(size, 5);

        return size;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterUlasanListBinding binding;

        public MyViewHolder(@NonNull AdapterUlasanListBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
