package com.samyotech.laundrymitra.ui.activity.layanan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityServiceAcitivityBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.PopLaundryDTO;
import com.samyotech.laundrymitra.model.ServicesDTO;
import com.samyotech.laundrymitra.model.ShopServicesDTO;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.Schedule_Activity;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceActivity extends AppCompatActivity {
    ArrayList<PopLaundryDTO> popLaundryDTO = new ArrayList<>();
    ServicesDTO servicesDTO;
    ActivityServiceAcitivityBinding binding;
    HashMap<String, String> params = new HashMap<>();
    UserDTO userDTO;
    SharedPrefrence sharedPrefrence;
    Context mContext;
    private ShopServicesDTO shopServicesDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service_acitivity);
        mContext = ServiceActivity.this;
        sharedPrefrence = SharedPrefrence.getInstance(mContext);
        userDTO = sharedPrefrence.getParentUser(Consts.USER_DTO);

        if (getIntent().hasExtra(Consts.SERVICEDTO)) {
            servicesDTO = (ServicesDTO) getIntent().getSerializableExtra(Consts.SERVICEDTO);
            setupUi();
        }

        if (getIntent().hasExtra(Consts.SHOPSERVICEDTO)) {
            shopServicesDTO = (ShopServicesDTO) getIntent().getSerializableExtra(Consts.SHOPSERVICEDTO);
            setupUi2();
        }
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        binding.bookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Schedule_Activity.class);
                in.putExtra(Consts.SHOP_ID, "YZ65d0");
                in.putExtra(Consts.SERVICEDTO, servicesDTO);
                startActivity(in);
            }
        });
    }

    private void setupUi2() {
        binding.ivShopName.setText(shopServicesDTO.getService_name());
        binding.des.setText(shopServicesDTO.getDescription());
        Glide.with(this).load(Consts.BASE_URL + shopServicesDTO.getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.serviceIcon);
    }

    private void setupUi() {
        binding.ivShopName.setText(servicesDTO.getService_name());
        binding.des.setText(servicesDTO.getDescription());
        Glide.with(this).load(Consts.BASE_URL + servicesDTO.getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.serviceIcon);
    }
}