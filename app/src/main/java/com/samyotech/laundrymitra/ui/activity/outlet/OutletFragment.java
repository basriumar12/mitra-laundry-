package com.samyotech.laundrymitra.ui.activity.outlet;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.FragmentOutletBinding;
import com.samyotech.laundrymitra.https.HttpsRequest;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.interfaces.Helper;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ResponseOther;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.About;
import com.samyotech.laundrymitra.ui.activity.ChangPassword;
import com.samyotech.laundrymitra.ui.activity.ChatList;
import com.samyotech.laundrymitra.ui.activity.Dashboard;
import com.samyotech.laundrymitra.ui.activity.NotificationActivity;
import com.samyotech.laundrymitra.ui.activity.TicketsActivity;
import com.samyotech.laundrymitra.ui.activity.login.Login;
import com.samyotech.laundrymitra.ui.activity.manage.ManageActivity;
import com.samyotech.laundrymitra.ui.activity.manage.ManagePromosiTokoActivity;
import com.samyotech.laundrymitra.ui.activity.manage.PusatEdukasiActivity;
import com.samyotech.laundrymitra.ui.activity.rekening.ManageTarikRekening;
import com.samyotech.laundrymitra.ui.activity.ulasan.UlasanActivity;
import com.samyotech.laundrymitra.ui.fragment.BottomSheetFragment;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import mehdi.sakout.fancybuttons.FancyButton;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;
import retrofit2.Callback;

public class OutletFragment extends Fragment implements View.OnClickListener {
    private static final int RESULT_OK = -1;
    private final String TAG = OutletFragment.class.getSimpleName();
    FragmentOutletBinding binding;
    Dashboard dashboard;
    SharedPrefrence prefrence;
    UserDTO userDTO;
    HashMap<String, File> fileHashMap = new HashMap<>();
    HashMap<String, String> hashMap = new HashMap<>();
    private BottomSheetFragment bottomSheetFragment;
    private String type;

    File fileImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_outlet, container, false);
        prefrence = SharedPrefrence.getInstance(getActivity());
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        getUpdateProfile();
        hashMap.put(Consts.USER_ID, userDTO.getUser_id());
        setUIAction();
        return binding.getRoot();
    }

    private void getUpdateProfile() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .authenticator(new Authenticator() {
                    @Override
                    public Request authenticate(Route route, Response response) throws IOException {
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
                        try {

                            userDTO = new Gson().fromJson(response.getJSONObject("data").toString(), UserDTO.class);
                            prefrence.setParentUser(userDTO, Consts.USER_DTO);

                            Glide.with(requireActivity())
                                    .load(userDTO.getImage_outlet())
                                    .error(R.drawable.cover)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .into(binding.ivBanner);


                        } catch (IllegalStateException e) {

                        }

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

    private void setUIAction() {
        String userImageBg = "";



        if (userDTO.getImage_outlet().isEmpty() || userDTO.getImage_outlet() == null) {
            userImageBg = "http://blcstore.id/dunia-laundry/assets/images/user/background/default.png";

        } else {
            userImageBg = userDTO.getImage_outlet();
        }



        Glide.with(requireActivity())
                .load(userImageBg)
                .error(R.drawable.cover)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivBanner);


        binding.tvName.setText(userDTO.getName());
        binding.tvPendapatan.setText(userDTO.getTotal_pendapatan());
        binding.tvPendapatanPotongan.setText(userDTO.getTotal_pendapatan_potongan());
        binding.ctvpromosi.setOnClickListener(this);
        binding.ctvChangePassword.setOnClickListener(this);
        binding.ctvnotification.setOnClickListener(this);
        binding.ctvChat.setOnClickListener(this);
        binding.ctvSupport.setOnClickListener(this);
        binding.ctvAbout.setOnClickListener(this);
        binding.ctvLogout.setOnClickListener(this);

        binding.updatePhoto.setOnClickListener(this);
        binding.updateBackground.setOnClickListener(this);
        binding.ctPengaturan.setOnClickListener(this);
        binding.btnTarikPendapatan.setOnClickListener(this);
        binding.ctvulasan.setOnClickListener(this);
        binding.ctvpusatEdukasi.setOnClickListener(this);
        binding.updateBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBs();
                Toast.makeText(getContext(), "upload", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.updateBackground:
//                builder.show();
                showBs();
                break;


        }
    }








    private void showBs() {
        this.type = type;
        bottomSheetFragment = new BottomSheetFragment(new BottomSheetFragment.ClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(int which) {
                switch (which) {
                    case R.id.camera:

                        ImagePicker.Companion.with(OutletFragment.this)
                                .cameraOnly()
                                .crop()
                                .compress(512)
                                .start();
                        Toast.makeText(getContext(), "Camera di pilih", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.gallery:
                        ImagePicker.Companion.with(OutletFragment.this)
                                .galleryOnly()
                                .crop()
                                .compress(512)
                                .start();

                        Toast.makeText(getContext(), "Galery di pilih", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        bottomSheetFragment.show(getChildFragmentManager(), bottomSheetFragment.getTag());
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        File file = ImagePicker.Companion.getFile(data);
        fileImage = ImagePicker.Companion.getFile(data);
        Log.e("TAG","result "+requestCode);

        if (resultCode == RESULT_OK) {

            Toast.makeText(getContext(), "upload progress", Toast.LENGTH_SHORT).show();
                fileHashMap.put(Consts.IMAGE, file);
                hashMap.put(Consts.IMAGE, file.getPath());
                if (bottomSheetFragment != null) {
                    bottomSheetFragment.dismiss();
                }
                updateProfile();




        }
    }

    private void updateProfile() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity(), R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        if (bottomSheetFragment != null) {
            bottomSheetFragment.dismiss();
        }
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("image",
                fileImage.getName(), RequestBody.create(MediaType.parse("image/*"), fileImage));


        RequestBody name = RequestBody.create(MediaType.parse("text/plain"),
                userDTO.getShop_id());
        api.uploadFotoOutlet(name, filePart).enqueue(new Callback<ResponseOther>() {
            @Override
            public void onResponse(Call<ResponseOther> call, retrofit2.Response<ResponseOther> response) {

                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        ProjectUtils.showToast(getContext(), response.body().getMessage());
                        getUpdateProfile();
                        getActivity().overridePendingTransition(R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                    } else {
                        ProjectUtils.showToast(getContext(), response.body().getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseOther> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
                progressDialog.dismiss();
                ProjectUtils.showToast(getContext(), "Gagal Upload, pilih foto yang lain");
            }
        });


    }

}
