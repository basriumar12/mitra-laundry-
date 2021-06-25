package com.samyotech.laundrymitra.ui.adapter.penjualan;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.AdapterPenjualanBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.penjualan.PenjualanItemDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.ui.activity.penjualan.DetailPenjualanActivity;
import com.samyotech.laundrymitra.ui.fragment.penjualan.PenjualanFragment;

import java.util.ArrayList;
import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PenjualanAdapter extends RecyclerView.Adapter<PenjualanAdapter.MyViewHolder>  {

    LayoutInflater layoutInflater;
    AdapterPenjualanBinding binding;
    Context kContext;
    PenjualanFragment penjualanFragment;
    ArrayList<PenjualanItemDto> penjualanDTOArrayList;


    public PenjualanAdapter(Context kContext, ArrayList<PenjualanItemDto> penjualanDTOArrayList, PenjualanFragment penjualanFragment) {
        this.kContext = kContext;
        this.penjualanFragment = penjualanFragment;
        this.penjualanDTOArrayList =penjualanDTOArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_penjualan, parent, false);
        return new PenjualanAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.binding.namaPenjualan.setText(penjualanDTOArrayList.get(position).getNamaService());
        holder.binding.totalPcs.setText(penjualanDTOArrayList.get(position).getTotalPcs() + "Kg");
        holder.binding.harga.setText(penjualanDTOArrayList.get(position).getTotalHarga());
        holder.binding.batalkan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                alertDialogBatal(position);
            }
        });
        holder.binding.selengkapnya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent in = new Intent(kContext, DetailPenjualanActivity.class);
                kContext.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return penjualanDTOArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterPenjualanBinding binding;

        public MyViewHolder(@NonNull AdapterPenjualanBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }

    public void alertDialogBatal(final int pos) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(kContext, R.style.CustomAlertDialog);
        View dialogView = LayoutInflater.from(kContext).inflate(R.layout.dialog_batal_penjualan, null, false);

        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        FancyButton cancel = dialogView.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        FancyButton ok = dialogView.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelOrder(penjualanDTOArrayList.get(pos).getOrderId());
                alertDialog.dismiss();
            }
        });
    }

    private void cancelOrder(String orderid) {
        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );


        api.getBatalPenjualan("zAd1d3").enqueue(new Callback<BaseResponse<List<PenjualanItemDto>>>() {

            @Override
            public void onResponse(Call<BaseResponse<List<PenjualanItemDto>>> call, Response<BaseResponse<List<PenjualanItemDto>>> response) {
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        penjualanFragment.getPenjualanData();
                        notifyDataSetChanged();
                        penjualanFragment.getPenjualanData();
                    } else {
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<PenjualanItemDto>>> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
            }
        });
    }
}
