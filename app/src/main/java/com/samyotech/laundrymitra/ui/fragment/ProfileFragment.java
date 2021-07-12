package com.samyotech.laundrymitra.ui.fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import com.samyotech.laundrymitra.databinding.FragmentProfileBinding;
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
import com.samyotech.laundrymitra.ui.activity.manage.ManageActivity;
import com.samyotech.laundrymitra.ui.activity.manage.ManageProfile;
import com.samyotech.laundrymitra.ui.activity.NotificationActivity;
import com.samyotech.laundrymitra.ui.activity.TicketsActivity;
import com.samyotech.laundrymitra.ui.activity.login.Login;
import com.samyotech.laundrymitra.ui.activity.manage.ManagePromosiTokoActivity;
import com.samyotech.laundrymitra.ui.activity.manage.PusatEdukasiActivity;
import com.samyotech.laundrymitra.ui.activity.rekening.ManageTarikRekening;
import com.samyotech.laundrymitra.ui.activity.ulasan.UlasanActivity;
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

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private static final int RESULT_OK = -1;
    private final String TAG = ProfileFragment.class.getSimpleName();
    FragmentProfileBinding binding;
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
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
                        Glide.with(requireActivity())
                                .load(userDTO.getUrl_image())
                                .error(R.drawable.profile)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(binding.ivAvtaimg);
                        Glide.with(requireActivity())
                                .load(userDTO.getUrl_background())
                                .error(R.drawable.cover)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(binding.ivBanner);

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
        String userImage = "";
        String userImageBg = "";

        if (userDTO.getUrl_image().isEmpty() || userDTO.getUrl_image() == null) {
            userImage = "http://blcstore.id/dunia-laundry/assets/images/user/default.png";

        } else {
            userImage = userDTO.getUrl_image();
        }


        if (userDTO.getUrl_background().isEmpty() || userDTO.getUrl_background() == null) {
            userImageBg = "http://blcstore.id/dunia-laundry/assets/images/user/background/default.png";

        } else {
            userImageBg = userDTO.getUrl_background();
        }


        Glide.with(requireActivity())
                .load(userImage)
                .error(R.drawable.profile)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivAvtaimg);
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

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctvLogout:
                alertDialogLogout();
                break;
            case R.id.ctvpromosi:
                Intent in123 = new Intent(getActivity(), ManagePromosiTokoActivity.class);
                startActivity(in123);
                break;
            case R.id.ctvSupport:
                Intent in = new Intent(getActivity(), TicketsActivity.class);
                startActivity(in);
                break;
            case R.id.ctvChat:
                Intent in1 = new Intent(getActivity(), ChatList.class);
                startActivity(in1);
                break;
            case R.id.ctvnotification:
                Intent in2 = new Intent(getActivity(), NotificationActivity.class);
                startActivity(in2);
                break;
            case R.id.ctvChangePassword:
                Intent in3 = new Intent(getActivity(), ChangPassword.class);
                startActivity(in3);
                break;
            case R.id.ctvAbout:
                Intent in4 = new Intent(getActivity(), About.class);
                startActivity(in4);
                break;

            case R.id.ctPengaturan:
                Intent in6 = new Intent(getActivity(), ManageActivity.class);
                startActivity(in6);
                break;

            case R.id.btn_tarik_pendapatan:
                Intent in7 = new Intent(getActivity(), ManageTarikRekening.class);
                startActivity(in7);
                break;
            case R.id.updatePhoto:
//                builder.show();
                showBs("image");
                break;
            case R.id.updateBackground:
//                builder.show();
                showBs("background");
                break;

            case R.id.ctvpusatEdukasi:
                startActivity(new Intent(getContext(), PusatEdukasiActivity.class));
                break;

            case R.id.ctvulasan:
                startActivity(new Intent(getContext(), UlasanActivity.class));
//                try {
//                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.windigitalkhatulistiwa.laundry"));
//                    startActivity(myIntent);
//                } catch (ActivityNotFoundException e) {
//                    Toast.makeText(getActivity(), "No application can handle this request." + " Please install a webbrowser", Toast.LENGTH_LONG).show();
//                    e.printStackTrace();
//                }
                break;
        }
    }


    public void logout() {
        prefrence.clearAllPreferences();
        Intent i = new Intent(dashboard, Login.class);
        i.putExtra("finish", true);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        dashboard.finish();

    }

    public void alertDialogLogout() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.CustomAlertDialog);
        ViewGroup viewGroup = requireView().findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(requireActivity()).inflate(R.layout.dialog_logout, viewGroup, false);

        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        FancyButton cancel = dialogView.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        FancyButton ok = dialogView.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

                logout();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dashboard = (Dashboard) context;
    }

    public void deleteAccount() {
        ProjectUtils.showProgressDialog(getActivity(), true, getResources().getString(R.string.please_wait));
        new HttpsRequest(Consts.DELETEACCOUNT, hashMap, getActivity()).stringPost(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) {
                ProjectUtils.pauseProgressDialog();
                if (flag) {
                    try {
                        prefrence.clearAllPreferences();
                        dashboard.finish();
                        Intent i = new Intent(dashboard, Login.class);
                        i.putExtra("finish", true);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        dashboard.finish();
                        startActivity(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    ProjectUtils.showToast(getActivity(), msg);
                }
            }
        });
    }


    public void alertDialogDelete() {
        new AlertDialog.Builder(dashboard)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(getString(R.string.app_name))
                .setMessage(getResources().getString(R.string.deleteMsg))
                .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        deleteAccount();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void showBs(String type) {
        this.type = type;
        bottomSheetFragment = new BottomSheetFragment(new BottomSheetFragment.ClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(int which) {
                switch (which) {
                    case R.id.camera:

                        ImagePicker.Companion.with(ProfileFragment.this)
                                .cameraOnly()
                                .crop()
                                .compress(512)
                                .start();
                        break;
                    case R.id.gallery:
                        ImagePicker.Companion.with(ProfileFragment.this)
                                .galleryOnly()
                                .crop()
                                .compress(512)
                                .start();
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

        if (resultCode == RESULT_OK) {
            if (type.equals("image")) {

                fileHashMap.put(Consts.IMAGE, file);
                hashMap.put(Consts.IMAGE, file.getPath());
                if (bottomSheetFragment != null) {
                    bottomSheetFragment.dismiss();
                }
                updateProfile();
            } else if (type.equals("background")) {

                fileHashMap.put(Consts.IMAGE, file);
                hashMap.put(Consts.IMAGE, file.getPath());
                if (bottomSheetFragment != null) {
                    bottomSheetFragment.dismiss();
                }
                updateProfileBackground();
            }
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
                userDTO.getUser_id());
        api.uploadFotoProfile(name, filePart).enqueue(new Callback<ResponseOther>() {
            @Override
            public void onResponse(Call<ResponseOther> call, retrofit2.Response<ResponseOther> response) {

                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        ProjectUtils.showToast(getContext(), "Berhasil Upload Fotp Profile");
                        getUpdateProfile();
                        getActivity().overridePendingTransition(R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                    } else {
                        ProjectUtils.showToast(getContext(), "Gagal Upload, pilih foto yang lain");
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

    private void updateProfileBackground() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity(), R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();
        if (bottomSheetFragment != null) {
            bottomSheetFragment.dismiss();
        }
        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );

        MultipartBody.Part filePart = MultipartBody.Part.createFormData("image",
                fileImage.getName(), RequestBody.create(MediaType.parse("image/*"), fileImage));


        RequestBody name = RequestBody.create(MediaType.parse("text/plain"),
                userDTO.getUser_id());
        api.uploadFotoBackground(name, filePart).enqueue(new Callback<ResponseOther>() {
            @Override
            public void onResponse(Call<ResponseOther> call, retrofit2.Response<ResponseOther> response) {

                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        ProjectUtils.showToast(getContext(), "Berhasil Upload Foto Background");
                        getUpdateProfile();
                        getActivity().overridePendingTransition(R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                    } else {
                        ProjectUtils.showToast(getContext(), "Gagal Upload, pilih foto yang lain");
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
