package com.samyotech.laundrymitra.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityTicketsBinding;
import com.samyotech.laundrymitra.databinding.DialogBuatTiketBinding;
import com.samyotech.laundrymitra.https.HttpsRequest;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.interfaces.Helper;
import com.samyotech.laundrymitra.model.TicketDTO;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.network.NetworkManager;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.adapter.TicketAdapter;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class TicketsActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = TicketsActivity.class.getSimpleName();
    private final HashMap<String, String> parmsadd = new HashMap<>();
    private final HashMap<String, String> parmsGet = new HashMap<>();
    Context mContext;
    ActivityTicketsBinding binding;
    DialogBuatTiketBinding binding1;
    JSONObject jsonObject = new JSONObject();
    JSONObject getjsonObject = new JSONObject();
    String ranDom = "";
    private TicketAdapter ticketAdapter;
    private ArrayList<TicketDTO> ticketDTOSList;
    private LinearLayoutManager mLayoutManager;
    private SharedPrefrence prefrence;
    private UserDTO userDTO;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tickets);

        mContext = TicketsActivity.this;

        prefrence = SharedPrefrence.getInstance(mContext);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);

        binding.back.setOnClickListener(this);

        try {
            parmsadd.put(Consts.USER_ID, userDTO.getUser_id());
            parmsGet.put(Consts.USER_ID, userDTO.getUser_id());
            parmsadd.put(Consts.SHOP_ID, userDTO.getShop_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        binding.buatTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogBuatTiket();
            }
        });

    }

    public void alertDialogBuatTiket() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
        binding1 = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.dialog_buat_tiket, null, false);
        builder.setView(binding1.getRoot());
        dialog = builder.create();
        dialog.show();

        binding1.tambahkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (NetworkManager.isConnectToInternet(mContext)) {
            getTicket();

        } else {
            ProjectUtils.showToast(mContext, getResources().getString(R.string.internet_connection));
        }
    }

    public void getTicket() {

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
                AndroidNetworking.get(Consts.API_URL + Consts.TIKETLIST + "?user_id=" + userDTO.getUser_id() + "&" + "shop_id=" + userDTO.getShop_id())
                        .setOkHttpClient(okHttpClient)
                        .setTag("test")
//                        .addQueryParameter("id_user", userid)
//                        .addQueryParameter("otp", otpSms)
                        .setPriority(Priority.HIGH)
                        .build();
        ProjectUtils.showLog("TAG", " url data --->" + request.getUrl());

        ProjectUtils.showProgressDialog(mContext, true, getResources().getString(R.string.please_wait));


        request.getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {

                boolean flag = false;
                try {
                    flag = response.getBoolean("status");
                    String msg = response.getString("message");

                    ProjectUtils.pauseProgressDialog();
                    if (flag) {
//                    binding.tvNo.setVisibility(View.GONE);
                        binding.rvChatList.setVisibility(View.VISIBLE);
                        try {
                            ticketDTOSList = new ArrayList<>();
                            Type getpetDTO = new TypeToken<List<TicketDTO>>() {
                            }.getType();
                            ticketDTOSList = new Gson().fromJson(response.getJSONArray("data").toString(), getpetDTO);
                            showData();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    } else {
//                    binding.tvNo.setVisibility(View.VISIBLE);
                        binding.rvChatList.setVisibility(View.GONE);
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


    public void showData() {
        binding.rvChatList.setLayoutManager(new LinearLayoutManager(mContext));
        ticketAdapter = new TicketAdapter(TicketsActivity.this, mContext, ticketDTOSList, userDTO);
        binding.rvChatList.setAdapter(ticketAdapter);
        binding.rvChatList.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
    }

    public void submitForm() {
        if (!validateReason()) {
            return;
        } else if (!validateDescription()) {
            return;
        } else {
            addTicket();

        }
    }

    public boolean validateReason() {
        if (binding1.judul.getText().toString().trim().equalsIgnoreCase("")) {
            binding1.judul.setError(getResources().getString(R.string.val_title));
            binding1.judul.requestFocus();
            return false;
        } else {
            binding1.judul.setError(null);
            binding1.judul.clearFocus();
            return true;
        }
    }

    public boolean validateDescription() {
        if (binding1.deskripsi.getText().toString().trim().equalsIgnoreCase("")) {
            binding1.deskripsi.setError(getResources().getString(R.string.val_description));
            binding1.deskripsi.requestFocus();
            return false;
        } else {
            binding1.deskripsi.setError(null);
            binding1.deskripsi.clearFocus();
            return true;
        }
    }


    public void addTicket() {
        Random otp1 = new Random();
        StringBuilder builder = new StringBuilder();
        for (int count = 0; count <= 3; count++) {
            builder.append(otp1.nextInt(10));
        }
        ranDom = builder.toString();

        try {

            parmsadd.put(Consts.DESCRIPTION, ProjectUtils.getEditTextValue(binding1.deskripsi));
            parmsadd.put(Consts.TITLE, ProjectUtils.getEditTextValue(binding1.judul));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectUtils.showProgressDialog(mContext, true, getResources().getString(R.string.please_wait));
        new HttpsRequest(Consts.ADDTIKET, parmsadd, mContext).stringPost(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) {
                ProjectUtils.pauseProgressDialog();
                if (flag) {
                    if (dialog != null)
                        dialog.dismiss();
                    ProjectUtils.showToast(mContext, msg);
                    getTicket();
                } else {
                    ProjectUtils.showToast(mContext, msg);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;
//            case R.id.ivPost:
//                dialogshow();
//                break;
        }

    }
}
