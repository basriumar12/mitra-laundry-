package com.samyotech.laundrymitra.ui.activity.penjualan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityServicePenjualanBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.ItemServiceDTO;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.PreviewOrderActivity;
import com.samyotech.laundrymitra.ui.activity.layanan.EditServiceActivity;
import com.samyotech.laundrymitra.ui.adapter.layanan.LayananItemAdapter;
import com.samyotech.laundrymitra.ui.adapter.penjualan.OtherServicePenjualanAdapter;
import com.samyotech.laundrymitra.ui.adapter.penjualan.PenjualanLayananItemAdapter;
import com.samyotech.laundrymitra.utils.AppFormat;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicePenjualanActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityServicePenjualanBinding binding;
    Context mContext;
    LinearLayoutManager linearLayoutManager;
    LinearLayoutManager otherLinearLayoutManager;
    OtherServicePenjualanAdapter otherServicePenjualanAdapter;
    PenjualanLayananItemAdapter penjualanLayananItemAdapter;
    SharedPrefrence prefrence;
    UserDTO userDTO;
    ServiceItemDto otherServiceData;
    ArrayList<ServiceItemDto> otherServiceListData;
    ArrayList<LayananItemDto> layananItemDtos;
    int quantity = 0, check = 0;
    float price = 0;
    boolean doubleClick = true;
    LayananItemDto layananItemDto;


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
        binding.des.setText(otherServiceData.getDescription());
        binding.bookingBtn.setOnClickListener(this);
//        binding.ctvItemName.setText(otherServiceData.getSe());
        getListLayanan();
        getLayananItem();
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
                        otherLinearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
                        binding.rvOtherService.setLayoutManager(otherLinearLayoutManager);
                        otherServiceListData = (ArrayList<ServiceItemDto>) response.body().getData();
                        for (int i = 0; i < otherServiceListData.size(); i++){
                            if (otherServiceListData.get(i).getServiceId().equals(otherServiceData.getServiceId())){
                                otherServiceListData.remove(otherServiceListData.get(i));
                            }
                        }
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

    public void getLayananItem() {
        final ProgressDialog progressDialog = new ProgressDialog(ServicePenjualanActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        api.getLayanan(otherServiceData.getServiceId(),userDTO.getUser_id()).enqueue(new Callback<BaseResponse<List<LayananItemDto>>>() {

            @Override
            public void onResponse(Call<BaseResponse<List<LayananItemDto>>> call, Response<BaseResponse<List<LayananItemDto>>> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()) {
                        linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
                        binding.rvLayananItem.setLayoutManager(linearLayoutManager);
                        layananItemDtos = (ArrayList<LayananItemDto>) response.body().getData();
                        for (int i = 0; i < layananItemDtos.size(); i++){
                            layananItemDtos.get(i).setCount("0");
                            System.out.println(layananItemDtos.get(i).toString());
                        }
                        penjualanLayananItemAdapter = new PenjualanLayananItemAdapter(mContext, (ArrayList<LayananItemDto>) layananItemDtos,ServicePenjualanActivity.this);
                        binding.rvLayananItem.setAdapter(penjualanLayananItemAdapter);
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

    public void addData(LayananItemDto layananItemDto) {
        Boolean status = false;
        int x, y;

        for (int i = 0; i < layananItemDtos.size(); i++){
            if (layananItemDtos.get(i).getItemId().equals(layananItemDto.getItemId())){

                layananItemDtos.get(i).getCount().replace(layananItemDtos.get(i).getCount(),layananItemDto.getCount());
                quantity = quantity + 1;
                price = price + (Float.parseFloat(layananItemDto.getPrice()));
                Log.e("QUANTITY", "addData:quantity " + quantity);
                Log.e("QUANTITY", "addData:price " + price);
//                prefrence.setCurrency(layananItemDto.getCurrency_code());
                binding.priceTotal.setText(getResources().getText(R.string.total) + " " + "Rp. " + AppFormat.addDelimiter(((int)price) + ""));
                binding.quantityTotal.setText(quantity + " " + getResources().getText(R.string.itemsadd));
            }

        }
    }

    public void subData(LayananItemDto layananItemDto) {
        Boolean status = false;
        int x, y;

        for (int i = 0; i < layananItemDtos.size(); i++){
            if (layananItemDtos.get(i).getItemId().equals(layananItemDto.getItemId())){

                layananItemDtos.get(i).getCount().replace(layananItemDtos.get(i).getCount(),layananItemDto.getCount());
                quantity = quantity - 1;
                price = price - (Float.parseFloat(layananItemDto.getPrice()));
                Log.e("QUANTITY", "addData:quantity " + quantity);
                Log.e("QUANTITY", "addData:price " + price);
//                prefrence.setCurrency(layananItemDto.getCurrency_code());
                binding.priceTotal.setText(getResources().getText(R.string.total) + " " + "Rp. " + AppFormat.addDelimiter(((int)price) + ""));
                binding.quantityTotal.setText(quantity + " " + getResources().getText(R.string.itemsadd));
            }

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.booking_btn:
                if (doubleClick) {
                    if (price == 0) {
                        ProjectUtils.showToast(mContext, getResources().getString(R.string.val_Item));
                    } else {
                        Intent in = new Intent(mContext, PickupActivity.class);
                        in.putExtra(Consts.TOTAL_PRICE, String.valueOf(price));
                        System.out.println(String.valueOf(price));
                        in.putExtra("LayananData", layananItemDtos);
                        in.putExtra("ServiceData", otherServiceData);
                        startActivity(in);
                        doubleClick = false;
                    }
                }
                break;
        }
    }
}