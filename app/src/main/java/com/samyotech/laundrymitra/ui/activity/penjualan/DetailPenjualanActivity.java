package com.samyotech.laundrymitra.ui.activity.penjualan;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityDetailPenjualanBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanDto;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanList;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.ui.adapter.penjualan.DetailPenjualanAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPenjualanActivity extends AppCompatActivity {

    ActivityDetailPenjualanBinding binding;
    Context mContext;
    LinearLayoutManager linearLayoutManager;
    DetailPenjualanAdapter detailPenjualanAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penjualan);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_penjualan);
        mContext = DetailPenjualanActivity.this;

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getDetailPenjualanData();
    }

    public void getDetailPenjualanData() {
        final ProgressDialog progressDialog = new ProgressDialog(DetailPenjualanActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        api.getDetailPenjualan("9221048015").enqueue(new Callback<BaseResponse<DetailPenjualanDto>>() {

            @Override
            public void onResponse(Call<BaseResponse<DetailPenjualanDto>> call, Response<BaseResponse<DetailPenjualanDto>> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()) {
                        binding.namaPesanan.setText("PEsanan");
                        binding.noOrder.setText(response.body().getData().getOrderId());
                        binding.namaPemesan.setText(response.body().getData().getLandmark());
                        binding.dateTimeJemput.setText(response.body().getData().getPickupDate() + "•" + response.body().getData().getPickupTime());
                        binding.dateTimeAntar.setText(response.body().getData().getDeliveryDate() + "•" + response.body().getData().getDeliveryTime());
                        binding.addressJemput.setText(response.body().getData().getShippingAddress());
                        binding.addressAntar.setText(response.body().getData().getShippingAddress());
                        binding.subtotal.setText(response.body().getData().getCurrencyCode()+" "+response.body().getData().getPrice());
                        binding.diskon.setText(response.body().getData().getCurrencyCode()+" "+response.body().getData().getDiscount());
                        binding.totalPembayaran.setText(response.body().getData().getCurrencyCode()+" "+response.body().getData().getFinalPrice());
                        binding.pajak.setText(response.body().getData().getCurrencyCode()+" "+response.body().getData().getDiscount());
                        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
                        binding.rvDetailPenjualan.setLayoutManager(linearLayoutManager);
                        detailPenjualanAdapter = new DetailPenjualanAdapter(mContext, (ArrayList<DetailPenjualanList>) response.body().getData().getItemDetails(), DetailPenjualanActivity.this);
                        binding.rvDetailPenjualan.setAdapter(detailPenjualanAdapter);
                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<DetailPenjualanDto>> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
                progressDialog.dismiss();
            }
        });


    }

}