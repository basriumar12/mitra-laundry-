package com.samyotech.laundrymitra.ui.activity.detailkhususuntukmu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityDetailKhususUntukmuBinding;
import com.samyotech.laundrymitra.databinding.ActivityListKhususUntukmuBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.home.KhususUntukmuDto;
import com.samyotech.laundrymitra.model.home.KhususUntukmuListDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.ui.adapter.home.KhususUntukmuAdapter;
import com.samyotech.laundrymitra.ui.adapter.home.ListKhususUntukmuAdapter;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListKhususUntukmuActivity extends AppCompatActivity {
    private ActivityListKhususUntukmuBinding binding;

    ListKhususUntukmuAdapter khususUntukmuAdapter;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_list_khusus_untukmu);

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

        api.getArtikel("publik").enqueue(new Callback<KhususUntukmuDto>() {
            @Override
            public void onResponse(Call<KhususUntukmuDto> call, Response<KhususUntukmuDto> response) {
                ProjectUtils.cancelDialog();
                ProjectUtils.pauseProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {

                        List<KhususUntukmuListDto> data = response.body().getData();

                        linearLayoutManager = new LinearLayoutManager(ListKhususUntukmuActivity.this, LinearLayoutManager.VERTICAL, false);
                        binding.rvKhususUntukmu.setLayoutManager(linearLayoutManager);
                        khususUntukmuAdapter = new ListKhususUntukmuAdapter(ListKhususUntukmuActivity.this, data);
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