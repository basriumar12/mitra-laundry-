package com.samyotech.laundrymitra.ui.activity.register;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityRegisterBinding;
import com.samyotech.laundrymitra.databinding.ActivityRegisterChooseBinding;
import com.samyotech.laundrymitra.https.HttpsRequest;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.interfaces.Helper;
import com.samyotech.laundrymitra.model.RegisterNewDto;
import com.samyotech.laundrymitra.network.NetworkManager;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.login.Login;
import com.samyotech.laundrymitra.utils.ProjectUtils;
import com.schibstedspain.leku.LocationPickerActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.michaelrocks.libphonenumber.android.Phonenumber;

public class ChooseRegister extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = ChooseRegister.class.getSimpleName();
    private SharedPrefrence prefrence;
    Context mContext;
    ActivityRegisterChooseBinding binding;
    private int type = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        mContext = ChooseRegister.this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_choose);
        prefrence = SharedPrefrence.getInstance(this);

        setUiAction();


    }

    public void setUiAction() {
        binding.cvRegister.setVisibility(View.GONE);


        binding.parentAgen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.parentAgen.setBackground(getResources().getDrawable(R.drawable.bg_button_register_2));

                binding.parentMitra.setBackground(getDrawable(R.drawable.bg_button_register));
                binding.cvRegister.setVisibility(View.VISIBLE);
                type = 1;
            }
        });

        binding.parentMitra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.parentAgen.setBackground(getDrawable(R.drawable.bg_button_register));
                binding.parentMitra.setBackground(getDrawable(R.drawable.bg_button_register_2));
                binding.cvRegister.setVisibility(View.VISIBLE);
                type = 2;
            }
        });

        binding.cvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseRegister.this, Register.class)
                        .putExtra("TYPE", String.valueOf(type))
                );


            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_now:

                break;


        }
    }


}
