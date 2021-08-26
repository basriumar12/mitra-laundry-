package com.samyotech.laundrymitra.ui.activity.layanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityEditServiceBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanDto;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanList;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.penjualan.DetailPenjualanActivity;
import com.samyotech.laundrymitra.ui.adapter.layanan.LayananItemAdapter;
import com.samyotech.laundrymitra.ui.adapter.penjualan.DetailPenjualanAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditServiceActivity extends AppCompatActivity {

    ActivityEditServiceBinding binding;
    Context mContext;
    LinearLayoutManager linearLayoutManager;
    String serviceId;
    ServiceItemDto serviceItemDto;
    LayananItemAdapter layananItemAdapter;

    UserDTO userDTO;
    private SharedPrefrence prefrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_service);
        mContext = EditServiceActivity.this;

        prefrence = SharedPrefrence.getInstance(this);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        serviceId = getIntent().getStringExtra("ServiceId");
        getDetailLayananData();
        getLayananItem();
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (userDTO.getPremium().equals("0")) {
                    Toast.makeText(EditServiceActivity.this, "Hanya bisa di akses oleh User Premium", Toast.LENGTH_SHORT).show();

                }
                if (userDTO.getPremium().equals("1")) {
                    updateDataLayanan();
                }
            }
        });

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (userDTO.getPremium().equals("0")) {
                    Toast.makeText(EditServiceActivity.this, "Hanya bisa di akses oleh User Premium", Toast.LENGTH_SHORT).show();

                }
                if (userDTO.getPremium().equals("1")) {
                   startActivity(new Intent(EditServiceActivity.this, DetailAddLayananItemActivity.class));
                }
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void getDetailLayananData() {
        final ProgressDialog progressDialog = new ProgressDialog(EditServiceActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        api.getDetailLayanan(serviceId).enqueue(new Callback<BaseResponse<ServiceItemDto>>() {

            @Override
            public void onResponse(Call<BaseResponse<ServiceItemDto>> call, Response<BaseResponse<ServiceItemDto>> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()) {
                        serviceItemDto = response.body().getData();
                        binding.des.setText(serviceItemDto.getDescription());
                        binding.serviceName.setText(serviceItemDto.getServiceName());
                        binding.ivShopName.setText(serviceItemDto.getServiceName());
                        Glide.with(mContext)
                                .load(serviceItemDto.getUrlImage())
                                .into(binding.ivBanner);


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

    public void getLayananItem() {
        final ProgressDialog progressDialog = new ProgressDialog(EditServiceActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        api.getLayanan(serviceId,userDTO.getUser_id()).enqueue(new Callback<BaseResponse<List<LayananItemDto>>>() {

            @Override
            public void onResponse(Call<BaseResponse<List<LayananItemDto>>> call, Response<BaseResponse<List<LayananItemDto>>> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()) {
                        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
                        binding.rvServiceItem.setLayoutManager(linearLayoutManager);
                        layananItemAdapter = new LayananItemAdapter(mContext, (ArrayList<LayananItemDto>) response.body().getData(), EditServiceActivity.this);
                        binding.rvServiceItem.setAdapter(layananItemAdapter);

                        if (response.body().getData().isEmpty()){

                            binding.tvDataProdukKoosong.setVisibility(View.VISIBLE);
                        }
                    } else {

                        binding.tvDataProdukKoosong.setVisibility(View.VISIBLE);

                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<LayananItemDto>>> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
                progressDialog.dismiss();
            }
        });


    }

    public void updateDataLayanan() {
        final ProgressDialog progressDialog = new ProgressDialog(EditServiceActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("service_id", serviceId);
        body.put("service_name", binding.serviceName.getText().toString());
        body.put("description", binding.des.getText().toString());
        api.postDataLayanan(body).enqueue(new Callback<BaseResponse<ServiceItemDto>>() {

            @Override
            public void onResponse(Call<BaseResponse<ServiceItemDto>> call, Response<BaseResponse<ServiceItemDto>> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()) {
                        finish();
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

        System.out.println(binding.des.getText());
        System.out.println(binding.serviceName.getText());

    }

}