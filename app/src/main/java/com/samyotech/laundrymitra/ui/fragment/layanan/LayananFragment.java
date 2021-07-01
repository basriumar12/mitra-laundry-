package com.samyotech.laundrymitra.ui.fragment.layanan;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.FragmentLayananBinding;
import com.samyotech.laundrymitra.databinding.FragmentPenjualanBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.model.penjualan.PenjualanItemDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.NotificationActivity;
import com.samyotech.laundrymitra.ui.activity.SearchActivity;
import com.samyotech.laundrymitra.ui.adapter.layanan.LayananAdapter;
import com.samyotech.laundrymitra.ui.adapter.penjualan.PenjualanAdapter;
import com.samyotech.laundrymitra.ui.fragment.penjualan.PenjualanFragment;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LayananFragment extends Fragment {

    LayananAdapter layananAdapter;
    FragmentLayananBinding binding;
    View view;
    UserDTO userDTO;
    private SharedPrefrence prefrence;
    LinearLayoutManager linearLayoutManager;


    public LayananFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_layanan, container, false);
        view = binding.getRoot();
        prefrence = SharedPrefrence.getInstance(getActivity());
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        getLayananData();

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


    public void getLayananData() {



            ProjectUtils.showProgressDialog(requireActivity(), true, getResources().getString(R.string.please_wait));

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );


        api.getListLayanan(userDTO.getUser_id(), "YZ65d0").enqueue(new Callback<BaseResponse<List<ServiceItemDto>>>() {

            @Override
            public void onResponse(Call<BaseResponse<List<ServiceItemDto>>> call, Response<BaseResponse<List<ServiceItemDto>>> response) {
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                        binding.rvBooking.setLayoutManager(linearLayoutManager);
                        layananAdapter = new LayananAdapter(getActivity(), (ArrayList<ServiceItemDto>) response.body().getData(), LayananFragment.this);
                        binding.rvBooking.setAdapter(layananAdapter);
                        ProjectUtils.cancelDialog();
                        ProjectUtils.pauseProgressDialog();
                        layananAdapter.setOnItemClickListener(new LayananAdapter.ClickListener() {
                            @Override
                            public void onItemClick(int position, View v) {
                                getLayananData();
                            }
                        });

                    } else {
                        ProjectUtils.cancelDialog();
                        ProjectUtils.pauseProgressDialog();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<ServiceItemDto>>> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
                ProjectUtils.cancelDialog();
                ProjectUtils.pauseProgressDialog();

            }
        });


    }


}