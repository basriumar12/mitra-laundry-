package com.samyotech.laundrymitra.ui.activity.manage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityManageBinding;
import com.samyotech.laundrymitra.ui.activity.ChangPassword;
import com.samyotech.laundrymitra.ui.activity.outlet.OutletFragment;
import com.samyotech.laundrymitra.ui.activity.outlet.OutletImageActivity;
import com.samyotech.laundrymitra.ui.activity.rekening.ManageProfileRekening;

public class ManageActivity extends AppCompatActivity {

    ActivityManageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage);

        setUi();

    }

    private void setUi() {
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        binding.ctvprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageActivity.this, ManageProfile.class));
            }
        });

        binding.ctOutletImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageActivity.this, OutletImageActivity.class));
            }
        });

        binding.ctvprofileMitra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageActivity.this, ManageProfileMitra.class));
            }
        });

        binding.ctChatDanNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageActivity.this, ManageChatAndEmailProfile.class));
            }
        });

        binding.ctGantiAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageActivity.this, ManageAddressProfile.class));
            }
        });
        binding.ctRekening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageActivity.this, ManageProfileRekening.class));
            }
        });

        binding.ctvChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageActivity.this, ChangPassword.class));
            }
        });

        binding.ctWaktuOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageActivity.this, ManageOperasionalProfile.class));
            }
        });


    }


}