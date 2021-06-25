package com.samyotech.laundrymitra.ui.activity.penjualan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityServicePenjualanBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.adapter.penjualan.OtherServicePenjualanAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicePenjualanActivity extends AppCompatActivity {
    ActivityServicePenjualanBinding binding;
    Context mContext;
    LinearLayoutManager linearLayoutManager;
    OtherServicePenjualanAdapter otherServicePenjualanAdapter;
    SharedPrefrence prefrence;
    UserDTO userDTO;
    ServiceItemDto otherServiceData;
    ArrayList<ServiceItemDto> otherServiceListData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penjualan);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service_penjualan);
        mContext = ServicePenjualanActivity.this;
        prefrence = SharedPrefrence.getInstance(mContext);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        otherServiceData = getIntent().getParcelableExtra("ServiceData");
        Glide.with(ServicePenjualanActivity.this)
                .load(otherServiceData.getUrlImage())
                .into(binding.ivBanner);
        Glide.with(ServicePenjualanActivity.this)
                .load(otherServiceData.getUrlImage())
                .into(binding.ivServiceItem);
        binding.des.setText(otherServiceData.getDescription());
//        binding.ctvItemName.setText(otherServiceData.getSe());
        getListLayanan();
//        getDetailPenjualanData();
    }

    public void getListLayanan() {
        final ProgressDialog progressDialog = new ProgressDialog(ServicePenjualanActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        api.getListLayanan(userDTO.getUser_id(),"YZ65d0").enqueue(new Callback<BaseResponse<List<ServiceItemDto>>>() {

            @Override
            public void onResponse(Call<BaseResponse<List<ServiceItemDto>>> call, Response<BaseResponse<List<ServiceItemDto>>> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()) {
                        linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
                        binding.rvOtherService.setLayoutManager(linearLayoutManager);
                        otherServiceListData = (ArrayList<ServiceItemDto>) response.body().getData();
//                        for (LayananListDto data : otherServiceListData) {
//                            if (data.getServiceId().equals(otherServiceData.getServiceId())) {
//                                otherServiceListData.remove(data);
//                            }
//                        }
//                        System.out.println(otherServiceListData);
                        otherServicePenjualanAdapter = new OtherServicePenjualanAdapter(mContext, otherServiceListData, ServicePenjualanActivity.this);
                        binding.rvOtherService.setAdapter(otherServicePenjualanAdapter);
                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<ServiceItemDto>>> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
                progressDialog.dismiss();
            }
        });


    }

    public void getLayanan() {
        final ProgressDialog progressDialog = new ProgressDialog(ServicePenjualanActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        api.getLayanan(otherServiceData.getServiceId()).enqueue(new Callback<BaseResponse<List<LayananItemDto>>>() {

            @Override
            public void onResponse(Call<BaseResponse<List<LayananItemDto>>> call, Response<BaseResponse<List<LayananItemDto>>> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()) {
//                        linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
//                        binding.rvOtherService.setLayoutManager(linearLayoutManager);
//                        otherServiceListData = (ArrayList<LayananListDto>) response.body().getData();
//                        for (LayananListDto data : response.body().getData()) {
//                            if (data.getServiceId().equals(otherServiceData.getServiceId())) {
//                                otherServiceListData.remove(data);
//                            }
//                        }
//                        otherServicePenjualanAdapter = new OtherServicePenjualanAdapter(mContext, otherServiceListData, ServicePenjualanActivity.this);
//                        binding.rvOtherService.setAdapter(otherServicePenjualanAdapter);
                    } else {

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

}