package com.samyotech.laundrymitra.ui.activity.manage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityPusatEdukasiBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.home.KhususUntukmuDto;
import com.samyotech.laundrymitra.model.home.KhususUntukmuListDto;
import com.samyotech.laundrymitra.model.home.PentingHariIniDto;
import com.samyotech.laundrymitra.model.home.TerlarisHariIniDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.Dashboard;
import com.samyotech.laundrymitra.ui.adapter.home.KhususUntukmuAdapter;
import com.samyotech.laundrymitra.ui.adapter.home.TerlarisAdapter;
import com.samyotech.laundrymitra.ui.fragment.HomeFragment;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PusatEdukasiActivity extends AppCompatActivity {
    LinearLayoutManager linearLayoutManager;
    KhususUntukmuAdapter khususUntukmuAdapter;
    String TAG = HomeFragment.class.getSimpleName();

    ActivityPusatEdukasiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pusat_edukasi);
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        getData();
    }

    private void getData() {
        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );

        api.getArtikel("edukasi").enqueue(new Callback<KhususUntukmuDto>() {
            @Override
            public void onResponse(Call<KhususUntukmuDto> call, Response<KhususUntukmuDto> response) {
                ProjectUtils.cancelDialog();
                ProjectUtils.pauseProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {

                        List<KhususUntukmuListDto> data = response.body().getData();


                        //binding.tvSelengkapnya.setVisibility(View.VISIBLE);
                        linearLayoutManager = new LinearLayoutManager(PusatEdukasiActivity.this, LinearLayoutManager.VERTICAL, false);
                        binding.rvKhususUntukmu.setLayoutManager(linearLayoutManager);
                        khususUntukmuAdapter = new KhususUntukmuAdapter(PusatEdukasiActivity.this, data);
                        binding.rvKhususUntukmu.setAdapter(khususUntukmuAdapter);
                        binding.tvKosong.setVisibility(View.GONE);
                    } else {
                        binding.tvKosong.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onFailure(Call<KhususUntukmuDto> call, Throwable t) {
                ProjectUtils.cancelDialog();
                ProjectUtils.pauseProgressDialog();
                binding.tvKosong.setVisibility(View.VISIBLE);
            }
        });
    }
}