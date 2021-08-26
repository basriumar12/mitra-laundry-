package com.samyotech.laundrymitra.ui.activity.manage;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileChatEmailBinding;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileOperasionalBinding;
import com.samyotech.laundrymitra.https.HttpsRequest;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.interfaces.Helper;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.network.NetworkManager;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.Dashboard;
import com.samyotech.laundrymitra.ui.activity.register.OtpActivity;
import com.samyotech.laundrymitra.ui.activity.register.UploadKtpActivity;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class ManageChatAndEmailProfile extends AppCompatActivity implements View.OnClickListener {
    public boolean checkAdd = true, doubleCheck = true;
    String TAG = ManageChatAndEmailProfile.class.getSimpleName();
    ActivityManageProfileChatEmailBinding binding;
    Context mContext;
    ProjectUtils projectUtils;
    NetworkManager networkManager;
    SharedPrefrence prefrence;
    UserDTO userDTO;
    HashMap<String, String> params = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_profile_chat_email);
        mContext = ManageChatAndEmailProfile.this;
        prefrence = SharedPrefrence.getInstance(mContext);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        params.put(Consts.USER_ID, userDTO.getUser_id());

        setdata();

        binding.back.setOnClickListener(this);
        binding.notifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifikasiUpdate();
            }
        });
        binding.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifikasiUpdateEmail();
            }
        });



    }

    private void setdata() {

        if (userDTO.getNotif_email().equals("1")){
            binding.email.setChecked(true);
        }else {
            binding.email.setChecked(false);
        }

        if (userDTO.getNotif_firebase().equals("1")){
            binding.notifikasi.setChecked(true);
        }else {
            binding.notifikasi.setChecked(false);
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.back:
                onBackPressed();
                break;


        }


    }

    public void notifikasiUpdate() {

        final ProgressDialog progressDialog = new ProgressDialog(this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();
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
                AndroidNetworking.get(Consts.API_URL + Consts.edit_notif + "?user_id=" + userDTO.getUser_id() + "&" + "shop_id=" + userDTO.getShop_id())
                        .setOkHttpClient(okHttpClient)
                        .setTag("test")
//                        .addQueryParameter("id_user", userid)
//                        .addQueryParameter("otp", otpSms)
                        .setPriority(Priority.HIGH)
                        .build();
        ProjectUtils.showLog("TAG", " url data --->" + request.getUrl());

        request
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        ProjectUtils.showLog("TAG", " response body --->" + response.toString());

                        try {
                            boolean flag = response.getBoolean("status");
                            String msg = response.getString("message");


                            if (flag) {

                                try {

                                    Intent in = new Intent(ManageChatAndEmailProfile.this, Dashboard.class);
                                    startActivity(in);
                                       ProjectUtils.showToast(getBaseContext(), msg);
                                    finish();

                                } catch (Exception e) {
                                    e.getMessage();
                                }


                            } else {

                                ProjectUtils.showToast(getBaseContext(), msg);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        progressDialog.dismiss();
                        ProjectUtils.showToast(getBaseContext(), "Gagal");
                        ProjectUtils.showLog("TAG", " error body --->" + anError.getErrorBody() + " error msg --->" + anError.getMessage());
                    }
                });

    }

    public void notifikasiUpdateEmail() {

        final ProgressDialog progressDialog = new ProgressDialog(this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();
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
                AndroidNetworking.get(Consts.API_URL + Consts.edit_notif_email + "?user_id=" + userDTO.getUser_id() + "&" + "shop_id=" + userDTO.getShop_id())
                        .setOkHttpClient(okHttpClient)
                        .setTag("test")
//                        .addQueryParameter("id_user", userid)
//                        .addQueryParameter("otp", otpSms)
                        .setPriority(Priority.HIGH)
                        .build();
        ProjectUtils.showLog("TAG", " url data --->" + request.getUrl());

        request
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        ProjectUtils.showLog("TAG", " response body --->" + response.toString());

                        try {
                            boolean flag = response.getBoolean("status");
                            String msg = response.getString("message");


                            if (flag) {

                                try {

                                    Intent in = new Intent(ManageChatAndEmailProfile.this, Dashboard.class);
                                    startActivity(in);
                                    ProjectUtils.showToast(getBaseContext(), msg);
                                    finish();

                                } catch (Exception e) {
                                    e.getMessage();
                                }


                            } else {

                                ProjectUtils.showToast(getBaseContext(), msg);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        progressDialog.dismiss();
                        ProjectUtils.showToast(getBaseContext(), "Gagal");
                        ProjectUtils.showLog("TAG", " error body --->" + anError.getErrorBody() + " error msg --->" + anError.getMessage());
                    }
                });

    }

    public void updateProfile() {
        ProjectUtils.showProgressDialog(mContext, true, getResources().getString(R.string.please_wait));

        new HttpsRequest(Consts.edit_notif_email, params, mContext).stringPost(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) {
                ProjectUtils.pauseProgressDialog();
                if (flag) {
                    try {
                        Log.e(TAG, "backResponse: " + response.toString());
                        ProjectUtils.showToast(mContext, msg);
                        //userDTO = new Gson().fromJson(response.getJSONObject("data").toString(), UserDTO.class);
                        //prefrence.setParentUser(userDTO, Consts.USER_DTO);
                        prefrence.setBooleanValue(Consts.IS_REGISTERED, true);
                        Intent in = new Intent(mContext, Dashboard.class);
                        startActivity(in);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ProjectUtils.showToast(mContext, msg);
                }

            }
        });
    }

    private HashMap<String, String> getParams() {


        params.put(Consts.USER_ID, userDTO.getUser_id());
        params.put(Consts.SHOP_ID, userDTO.getShop_id());


        return params;
    }


}
