package com.samyotech.laundrymitra.ui.adapter.layanan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterPelayananBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.layanan.DetailLayananItemActivity;
import com.samyotech.laundrymitra.ui.activity.layanan.EditServiceActivity;
import com.samyotech.laundrymitra.ui.fragment.layanan.LayananFragment;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayananAdapter extends RecyclerView.Adapter<LayananAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterPelayananBinding binding;
    Context kContext;
    UserDTO userDTO;
    private SharedPrefrence prefrence;
    LayananFragment layananFragment;
    ArrayList<ServiceItemDto> serviceItemDtos;
    private static ClickListener clickListener;

    public interface ClickListener {
        void onItemClick(int position, View v);

    }

    public void setOnItemClickListener(ClickListener clickListener) {
        LayananAdapter.clickListener = clickListener;
    }

    public LayananAdapter(Context kContext, ArrayList<ServiceItemDto> serviceItemDtos, LayananFragment layananFragment) {
        this.kContext = kContext;
        this.layananFragment = layananFragment;
        this.serviceItemDtos = serviceItemDtos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_pelayanan, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        prefrence = SharedPrefrence.getInstance(holder.itemView.getContext());
        userDTO = prefrence.getParentUser(Consts.USER_DTO);

        Glide.with(kContext)
                .load(serviceItemDtos.get(position).getUrlImage())
                .into(holder.binding.imgTerlaris);
        holder.binding.namaPenjualan.setText(serviceItemDtos.get(position).getServiceName());
        System.out.println("STATUS " + serviceItemDtos.get(position).getStatus());
        if (serviceItemDtos.get(position).getStatus().equals("0")) {
            holder.binding.ubah.setBorderColor(Color.parseColor("#808080"));
            holder.binding.status.setText("Aktifkan");
            holder.binding.status.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.binding.ubah.setTextColor(Color.parseColor("#808080"));
            holder.binding.status.setTextColor(Color.parseColor("#000000"));
            holder.binding.namaPenjualan.setTextColor(Color.parseColor("#808080"));
        } else if (serviceItemDtos.get(position).getStatus().equals("1")) {
            holder.binding.ubah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (userDTO.getPremium() == null || userDTO.getPremium().isEmpty()) {
                        Toast.makeText(kContext, "Hanya bisa di akses oleh User Premium", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(kContext, EditServiceActivity.class);
                        intent.putExtra("ServiceId", serviceItemDtos.get(position).getServiceId());
                        kContext.startActivity(intent);
                    }
                }
            });


        }
        holder.binding.status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (userDTO.getPremium() == null || userDTO.getPremium().isEmpty()) {
                    Toast.makeText(kContext, "Hanya bisa di akses oleh User Premium", Toast.LENGTH_SHORT).show();
                } else {

                    final View view1;
                    view1 = view;

                    final ProgressDialog progressDialog = new ProgressDialog(kContext, R.style.CustomAlertDialog);
                    progressDialog.setMessage("loading");
                    progressDialog.show();

                    ApiInterface api = ServiceGenerator.createService(
                            ApiInterface.class,
                            Consts.username,
                            Consts.pass
                    );
                    api.getUpdateStatusLayanan(serviceItemDtos.get(position).getServiceId()).enqueue(new Callback<BaseResponse<ServiceItemDto>>() {
                        @Override
                        public void onResponse(Call<BaseResponse<ServiceItemDto>> call, Response<BaseResponse<ServiceItemDto>> response) {
                            if (response.isSuccessful()) {
                                clickListener.onItemClick(position, view1);
                                progressDialog.dismiss();
                                if (response.body().isStatus()) {
                                    if (response.body().getData().getStatus().equals("0")) {
                                        holder.binding.ubah.setBorderColor(Color.parseColor("#808080"));
                                        holder.binding.status.setText("Aktifkan");
                                        holder.binding.status.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        holder.binding.ubah.setTextColor(Color.parseColor("#808080"));
                                        holder.binding.status.setTextColor(Color.parseColor("#000000"));
                                        holder.binding.namaPenjualan.setTextColor(Color.parseColor("#808080"));
                                    } else {
                                        holder.binding.ubah.setBorderColor(Color.parseColor("#03A9F4"));
                                        holder.binding.status.setText("Nonaktifkan");
                                        holder.binding.status.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        holder.binding.ubah.setTextColor(Color.parseColor("#000000"));
                                        holder.binding.status.setTextColor(Color.parseColor("#FFFFFF"));
                                        holder.binding.namaPenjualan.setTextColor(Color.parseColor("#000000"));
                                    }
                                } else {

                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<BaseResponse<ServiceItemDto>> call, Throwable t) {
                            Log.e("TAG", "gagal upload " + t.getMessage());
                            progressDialog.dismiss();
                        }
                    });
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return serviceItemDtos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterPelayananBinding binding;

        public MyViewHolder(@NonNull AdapterPelayananBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }


}
