package com.samyotech.laundrymitra.ui.fragment.penjualan;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.FragmentPenjualanBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.penjualan.PenjualanItemDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.NotificationActivity;
import com.samyotech.laundrymitra.ui.activity.SearchActivity;
import com.samyotech.laundrymitra.ui.activity.penjualan.ServiceMenuActivity;
import com.samyotech.laundrymitra.ui.adapter.penjualan.PenjualanAdapter;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PenjualanFragment extends Fragment {


    PenjualanAdapter penjualanAdapter;
    FragmentPenjualanBinding binding;
    View view;
    UserDTO userDTO;
    private SharedPrefrence prefrence;
    LinearLayoutManager linearLayoutManager;


    public PenjualanFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_penjualan, container, false);
        view = binding.getRoot();
        prefrence = SharedPrefrence.getInstance(getActivity());
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        getPenjualanData();
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ServiceMenuActivity.class);
                startActivity(intent);
            }
        });

        binding.ivNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in4 = new Intent(getActivity(), NotificationActivity.class);
                startActivity(in4);
            }
        });

        binding.ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in4 = new Intent(getActivity(), SearchActivity.class);
                startActivity(in4);
            }
        });
        return view;
    }

    public void getPenjualanData() {
        ProjectUtils.showProgressDialog(requireActivity(), true, getResources().getString(R.string.please_wait));

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );


        api.getPenjualanData(userDTO.getUser_id()).enqueue(new Callback<BaseResponse<List<PenjualanItemDto>>>() {

            @Override
            public void onResponse(Call<BaseResponse<List<PenjualanItemDto>>> call, Response<BaseResponse<List<PenjualanItemDto>>> response) {
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                        binding.rvPenjualan.setLayoutManager(linearLayoutManager);
                        penjualanAdapter = new PenjualanAdapter(getActivity(), (ArrayList<PenjualanItemDto>) response.body().getData(), PenjualanFragment.this);
                        binding.rvPenjualan.setAdapter(penjualanAdapter);
                        ProjectUtils.cancelDialog();
                        ProjectUtils.pauseProgressDialog();

                        binding.tvKosong.setVisibility(View.GONE);
                    } else {
                        binding.tvKosong.setVisibility(View.VISIBLE);
                        ProjectUtils.cancelDialog();
                        ProjectUtils.pauseProgressDialog();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<PenjualanItemDto>>> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
                ProjectUtils.cancelDialog();
                ProjectUtils.pauseProgressDialog();

                binding.tvKosong.setVisibility(View.VISIBLE);

            }
        });


    }


}