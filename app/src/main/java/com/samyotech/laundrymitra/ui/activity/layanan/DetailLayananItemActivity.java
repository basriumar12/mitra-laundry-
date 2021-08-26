package com.samyotech.laundrymitra.ui.activity.layanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityDetailLayananItemBinding;
import com.samyotech.laundrymitra.databinding.ActivityEditServiceBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailLayananItemActivity extends AppCompatActivity {

    ActivityDetailLayananItemBinding binding;
    Context mContext;
    LayananItemDto layananItemDto;

    UserDTO userDTO;
    private SharedPrefrence prefrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_layanan_item);
        mContext = DetailLayananItemActivity.this;

        prefrence = SharedPrefrence.getInstance(this);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        layananItemDto = getIntent().getParcelableExtra("LayananItem");
        binding.des.setText(layananItemDto.getItemName());
        binding.serviceName.setText(layananItemDto.getPrice());
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userDTO.getPremium().equals("0")) {
                    Toast.makeText(DetailLayananItemActivity.this, "Hanya bisa di akses oleh User Premium", Toast.LENGTH_SHORT).show();

                }
                if (userDTO.getPremium().equals("1")) {
                    updateDataItemLayanan();
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

    public void updateDataItemLayanan() {
        final ProgressDialog progressDialog = new ProgressDialog(DetailLayananItemActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("item_id", layananItemDto.getItemId());
        body.put("price", binding.serviceName.getText().toString());
        body.put("item_name", binding.des.getText().toString());
        api.postDataItemLayanan(body).enqueue(new Callback<BaseResponse<LayananItemDto>>() {
            @Override
            public void onResponse(Call<BaseResponse<LayananItemDto>> call, Response<BaseResponse<LayananItemDto>> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()) {
                        finish();
                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<LayananItemDto>> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
                progressDialog.dismiss();
            }
        });
        System.out.println(binding.des.getText());
        System.out.println(binding.serviceName.getText());
    }

}