package com.samyotech.laundrymitra.ui.activity.penjualan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.View;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityDetailPenjualanBinding;
import com.samyotech.laundrymitra.databinding.ActivityServiceMenuBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.layanan.LayananDto;
import com.samyotech.laundrymitra.model.layanan.LayananListDto;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanList;
import com.samyotech.laundrymitra.model.penjualan.PenjualanDetailDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.adapter.penjualan.DetailPenjualanAdapter;
import com.samyotech.laundrymitra.ui.adapter.penjualan.ServiceMenuAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceMenuActivity extends AppCompatActivity {


    ActivityServiceMenuBinding binding;
    Context mContext;
    GridLayoutManager gridLayoutManager;
    ServiceMenuAdapter serviceMenuAdapter;
    private SharedPrefrence prefrence;
    UserDTO userDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_menu);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service_menu);
        mContext = ServiceMenuActivity.this;
        prefrence = SharedPrefrence.getInstance(mContext);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        getListLayanan();
    }

    public void getListLayanan() {
        final ProgressDialog progressDialog = new ProgressDialog(ServiceMenuActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        api.getListLayanan(userDTO.getUser_id(),"YZ65d0").enqueue(new Callback<LayananDto>() {

            @Override
            public void onResponse(Call<LayananDto> call, Response<LayananDto> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()) {
                        gridLayoutManager = new GridLayoutManager(mContext,3);
                        binding.gvServiceMenu.setLayoutManager(gridLayoutManager);
                        serviceMenuAdapter = new ServiceMenuAdapter(mContext, (ArrayList<LayananListDto>) response.body().getData(), ServiceMenuActivity.this);
                        binding.gvServiceMenu.setAdapter(serviceMenuAdapter);
                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<LayananDto> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
                progressDialog.dismiss();
            }
        });


    }

}