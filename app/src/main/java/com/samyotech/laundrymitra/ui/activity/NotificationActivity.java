package com.samyotech.laundrymitra.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityNotificationBinding;
import com.samyotech.laundrymitra.https.HttpsRequest;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.interfaces.Helper;
import com.samyotech.laundrymitra.model.NotificationDTO;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.adapter.AdapterNotifcation;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    private final String TAG = NotificationActivity.class.getCanonicalName();
    ActivityNotificationBinding binding;
    Context mContext;
    SharedPrefrence sharedPrefrence;
    UserDTO userDTO;
    AdapterNotifcation adapterNotifcation;
    RecyclerView.LayoutManager layoutManager;
    List<NotificationDTO> originalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification);
        mContext = NotificationActivity.this;
        sharedPrefrence = SharedPrefrence.getInstance(mContext);
        userDTO = sharedPrefrence.getParentUser(Consts.USER_DTO);
        setData();
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setData() {
        new HttpsRequest(Consts.GET_NOTIFICATION, getBaseContext(), userDTO.getUser_id(), "").stringResendOTP("TAG", new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) throws JSONException {

                boolean flags = response.getBoolean("status");
                String msgs = response.getString("message");
                if (flags) {

                    Type getpetDTO = new TypeToken<List<NotificationDTO>>() {
                    }.getType();
                    List<NotificationDTO> items = new Gson().fromJson(response.getJSONArray("data").toString(), getpetDTO);
                    originalList.addAll(items);
                    if (originalList.isEmpty()) {

                        binding.tvKosong.setVisibility(View.VISIBLE);
                    } else {

                        binding.tvKosong.setVisibility(View.GONE);
                    }
                    showData();

                } else {
                    binding.tvKosong.setVisibility(View.VISIBLE);
                    ProjectUtils.showToast(mContext, msg);
                }
            }
        });
    }

    private void showData() {
        layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        binding.rvNotification.setLayoutManager(new LinearLayoutManager(mContext));
        adapterNotifcation = new AdapterNotifcation(mContext, originalList);
        binding.rvNotification.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.rvNotification.setAdapter(adapterNotifcation);
        adapterNotifcation.notifyDataSetChanged();
    }
}
