package com.samyotech.laundrymitra.ui.fragment.layanan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.FragmentLayananBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.NotificationActivity;
import com.samyotech.laundrymitra.ui.activity.SearchActivity;
import com.samyotech.laundrymitra.ui.adapter.layanan.LayananAdapter;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Route;
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
        getUpdateProfile();
        Log.e("TAG","date premium "+userDTO.getPremium());
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


    private void getUpdateProfile() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .authenticator(new Authenticator() {
                    @Override
                    public Request authenticate(Route route, okhttp3.Response response) throws IOException {
                        return response.request().newBuilder()
                                .header("Authorization", Credentials.basic(Consts.username, Consts.pass))
                                .build();
                    }
                })
                .build();
        final ANRequest request =
                AndroidNetworking.get(Consts.API_URL + Consts.lainya + "?user_id=" + userDTO.getUser_id() + "&" + "shop_id=" + userDTO.getShop_id())
                        .setOkHttpClient(okHttpClient)
                        .setTag("test")
//                        .addQueryParameter("id_user", userid)
//                        .addQueryParameter("otp", otpSms)
                        .setPriority(Priority.HIGH)
                        .build();
        ProjectUtils.showLog("TAG", " url data --->" + request.getUrl());

        request.getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    boolean flag = response.getBoolean("status");
                    String msg = response.getString("message");

                    //ProjectUtils.showToast(getContext(), msg);

                    if (flag) {
                        userDTO = new Gson().fromJson(response.getJSONObject("data").toString(), UserDTO.class);
                        prefrence.setParentUser(userDTO, Consts.USER_DTO);
                        ProjectUtils.showLog("TAG", "  data --->" +new Gson().toJson(response.getJSONObject("data")));


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onError(ANError anError) {
            }
        });

    }

    public void getLayananData() {



            ProjectUtils.showProgressDialog(requireActivity(), true, getResources().getString(R.string.please_wait));

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );

//"YZ65d0"
        api.getListLayanan(userDTO.getUser_id(), userDTO.getShop_id()).enqueue(new Callback<BaseResponse<List<ServiceItemDto>>>() {

            @Override
            public void onResponse(Call<BaseResponse<List<ServiceItemDto>>> call, Response<BaseResponse<List<ServiceItemDto>>> response) {
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {

                        binding.tvKosong.setVisibility(View.GONE);
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

                        if (response.body().getData().isEmpty()){
                            binding.tvKosong.setVisibility(View.VISIBLE);
                            binding.tvKosong.setText(response.body().getMessage());
                        }

                    } else {
                        binding.tvKosong.setText(response.body().getMessage());
                        ProjectUtils.cancelDialog();
                        ProjectUtils.pauseProgressDialog();

                        binding.tvKosong.setVisibility(View.VISIBLE);
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