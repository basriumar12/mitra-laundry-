package com.samyotech.laundrymitra.ui.activity.penjualan;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityDetailPenjualanBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.penjualan.DataItemPenjulan;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualan;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanList;
import com.samyotech.laundrymitra.model.penjualan.PenjualanDetailDto;
import com.samyotech.laundrymitra.model.penjualan.PenjualanListDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.BookingConfirmActivity;
import com.samyotech.laundrymitra.ui.activity.register.UploadKtpActivity;
import com.samyotech.laundrymitra.ui.adapter.penjualan.DetailPenjualanAdapter;
import com.samyotech.laundrymitra.ui.adapter.penjualan.PenjualanAdapter;
import com.samyotech.laundrymitra.ui.fragment.penjualan.PenjualanFragment;
import com.samyotech.laundrymitra.utils.ProjectUtils;

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
        api.getDetailPenjualan("9221048015").enqueue(new Callback<PenjualanDetailDto>() {

            @Override
            public void onResponse(Call<PenjualanDetailDto> call, Response<PenjualanDetailDto> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()) {
                        binding.namaPesanan.setText("PEsanan");
                        binding.noOrder.setText(response.body().getDetailPenjualan().getOrderId());
                        binding.namaPemesan.setText(response.body().getDetailPenjualan().getLandmark());
                        binding.dateTimeJemput.setText(response.body().getDetailPenjualan().getPickupDate() + "•" + response.body().getDetailPenjualan().getPickupTime());
                        binding.dateTimeAntar.setText(response.body().getDetailPenjualan().getDeliveryDate() + "•" + response.body().getDetailPenjualan().getDeliveryTime());
                        binding.addressJemput.setText(response.body().getDetailPenjualan().getShippingAddress());
                        binding.addressAntar.setText(response.body().getDetailPenjualan().getShippingAddress());
                        binding.subtotal.setText(response.body().getDetailPenjualan().getCurrencyCode()+" "+response.body().getDetailPenjualan().getPrice());
                        binding.diskon.setText(response.body().getDetailPenjualan().getCurrencyCode()+" "+response.body().getDetailPenjualan().getDiscount());
                        binding.totalPembayaran.setText(response.body().getDetailPenjualan().getCurrencyCode()+" "+response.body().getDetailPenjualan().getFinalPrice());
                        binding.pajak.setText(response.body().getDetailPenjualan().getCurrencyCode()+" "+response.body().getDetailPenjualan().getDiscount());
                        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
                        binding.rvDetailPenjualan.setLayoutManager(linearLayoutManager);
                        detailPenjualanAdapter = new DetailPenjualanAdapter(mContext, (ArrayList<DetailPenjualanList>) response.body().getDetailPenjualan().getItemDetails(), DetailPenjualanActivity.this);
                        binding.rvDetailPenjualan.setAdapter(detailPenjualanAdapter);
                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<PenjualanDetailDto> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
                progressDialog.dismiss();
            }
        });


    }

}