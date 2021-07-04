package com.samyotech.laundrymitra.ui.activity.manage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityPusatEdukasiBinding;

public class PusatEdukasiActivity extends AppCompatActivity {


    ActivityPusatEdukasiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pusat_edukasi);
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}