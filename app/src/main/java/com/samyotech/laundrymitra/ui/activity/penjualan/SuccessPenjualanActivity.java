package com.samyotech.laundrymitra.ui.activity.penjualan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivitySuccessPenjualanBinding;
import com.samyotech.laundrymitra.ui.activity.BookingConfirmActivity;
import com.samyotech.laundrymitra.ui.activity.Dashboard;

public class SuccessPenjualanActivity extends AppCompatActivity {

    ActivitySuccessPenjualanBinding binding;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_success_penjualan);
        mContext = SuccessPenjualanActivity.this;

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(mContext, Dashboard.class);
                startActivity(in);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent in = new Intent(mContext, Dashboard.class);
        startActivity(in);

    }
}