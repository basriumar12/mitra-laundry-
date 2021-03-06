package com.samyotech.laundrymitra.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.samyotech.laundrymitra.GlobalState;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityBookingConfirmBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.CurrencyDTO;
import com.samyotech.laundrymitra.model.ItemDTO;
import com.samyotech.laundrymitra.model.PopLaundryDTO;
import com.samyotech.laundrymitra.model.UserDTO;

import java.util.HashMap;

public class BookingConfirmActivity extends AppCompatActivity {
    ActivityBookingConfirmBinding binding;
    Context mContext;
    UserDTO userDTO;
    GlobalState globalState;
    PopLaundryDTO popLaundryDTO;
    ItemDTO itemServiceDTO;
    Dashboard dashboard;
    HashMap<String, String> parmsSubmit = new HashMap<>();
    CurrencyDTO currencyDTO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_booking_confirm);
        mContext = BookingConfirmActivity.this;
        globalState = (GlobalState) getApplication();
        parmsSubmit = (HashMap<String, String>) getIntent().getSerializableExtra("map");

        itemServiceDTO = GlobalState.getInstance().itemServiceDTO();
        popLaundryDTO = GlobalState.getInstance().getPopLaundryDTO();
        setData();

    }

    private void setData() {
        binding.ctvFinalAmountpaid.setText(globalState.getCost());
        binding.ctvShop.setText(popLaundryDTO.getShop_name());
        binding.ctvbOrdernum.setText(parmsSubmit.get(Consts.ORDER_ID));
        binding.ctvbPickupDate.setText(parmsSubmit.get(Consts.PICKUP_DATE) + " " + parmsSubmit.get(Consts.PICKUP_TIME));
        binding.rlgotostatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(mContext, Dashboard.class);
                in.putExtra(Consts.SCREEN_TAG, Consts.BOOKINGFRAGMENT);
                startActivity(in);
                finish();
            }
        });

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
