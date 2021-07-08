package com.samyotech.laundrymitra.ui.activity.detailkhususuntukmu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityDetailKhususUntukmuBinding;

public class DetailKhususUntukmuActivity extends AppCompatActivity {


    private ActivityDetailKhususUntukmuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_khusus_untukmu);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        setData();


    }

    private void setData() {
        String desk = getIntent().getStringExtra("DESK");
        if (desk== null || desk.isEmpty()){
            desk ="Tidak ada deskripsi";
        }

        binding.tvTitleD.setText(getIntent().getStringExtra("TITLE"));
        binding.tvDesk.setText(desk);
        binding.tvDate.setText(getIntent().getStringExtra("DATE"));

        Glide.with(this)

                .load(getIntent().getStringExtra("IMAGE"))
                .placeholder(R.drawable.laundryshop)
                .error(R.drawable.laundryshop)
                .into(binding.imgDetail);
    }
}