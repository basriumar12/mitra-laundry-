package com.samyotech.laundrymitra.ui.activity.register;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.gson.Gson;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityRegisterMitraBinding;
import com.samyotech.laundrymitra.https.HttpsRequest;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.interfaces.Helper;
import com.samyotech.laundrymitra.model.RegisterNewDto;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.login.Login;
import com.samyotech.laundrymitra.utils.ProjectUtils;
import com.schibstedspain.leku.LocationPickerActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class RegisterMitraActivity extends AppCompatActivity {
    private final String TAG = RegisterMitraActivity.class.getSimpleName();
    private SharedPrefrence prefrence;
    Context mContext;
    ActivityRegisterMitraBinding binding;

    boolean doubleClick = true;
    boolean numCheck = false;
    private boolean isHide = false;
    HashMap<String, String> params = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        mContext = RegisterMitraActivity.this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_mitra);
        prefrence = SharedPrefrence.getInstance(this);

        binding.cariAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findPlace();
            }

        });

        binding.cvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ProjectUtils.isEditTextFilled(binding.cetName)) {
                    Toast.makeText(mContext, R.string.addname, Toast.LENGTH_SHORT).show();
                } else if (!ProjectUtils.isEditTextFilled(binding.cetAlamat)) {
                    Toast.makeText(mContext, R.string.addAddress, Toast.LENGTH_SHORT).show();
                } else {
                    registerMitra();
                }
            }
        });


    }

    private void findPlace() {
        Intent locationPickerIntent = new LocationPickerActivity.Builder()
                .withGooglePlacesEnabled()
                .withLocation(Double.parseDouble(prefrence.getValue(Consts.LATITUDE)),
                        Double.parseDouble(prefrence.getValue(Consts.LONGITUDE)))
                .build(mContext);

        startActivityForResult(locationPickerIntent, 101);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                try {
                    getAddress(data.getDoubleExtra(Consts.LATITUDE, 0.0), data.getDoubleExtra(Consts.LONGITUDE, 0.0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getAddress(double lat, double lng) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            Address obj = addresses.get(0);
            String add = obj.getAddressLine(0);
            add = add + "\n" + obj.getCountryName();
            add = add + "\n" + obj.getCountryCode();
            add = add + "\n" + obj.getAdminArea();
            add = add + "\n" + obj.getPostalCode();
            add = add + "\n" + obj.getSubAdminArea();
            add = add + "\n" + obj.getLocality();
            add = add + "\n" + obj.getSubThoroughfare();
            Log.e("IGA", "Address" + add);
            // Toast.makeText(this, "Address=>" + add,
            // Toast.LENGTH_SHORT).show();

            // TennisAppActivity.showDialog(add);
            RegisterNewDto userDTO = prefrence.getParentUserRegister(Consts.REGISTER_DTO);

            binding.cetAlamat.setText(obj.getAddressLine(0));
            params.put(Consts.USER_ID, userDTO.getUserId());
            params.put(Consts.NAMA_MITRA, binding.cetName.getText().toString());
            params.put(Consts.ALAMAT_MITRA, obj.getAddressLine(0));
            params.put(Consts.LATITUDE, String.valueOf(obj.getLatitude()));
            params.put(Consts.LONGITUDE, String.valueOf(obj.getLongitude()));


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void registerMitra() {
        ProjectUtils.showProgressDialog(mContext, true, getResources().getString(R.string.please_wait));

        Log.e(TAG, "backResponse: param " + new Gson().toJson(params));
        new HttpsRequest(Consts.REGISTER_MITRA, getParams(), mContext).stringPost(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) {
                ProjectUtils.pauseProgressDialog();
               // JSONObject flagd = null;
                boolean flagd= true;
                try {
                    flagd = response.getBoolean("status");
                    if (flagd) {
                        try {
                            Log.e(TAG, "backResponse: " + response.toString());
                            ProjectUtils.showToast(mContext, "Masih gagal daftar");



                            Intent in = new Intent(mContext, Login.class);
                            startActivity(in);
                            finish();
                            prefrence.setIntValue("DAFTAR-", 3);
                            overridePendingTransition(R.anim.anim_slide_in_left,
                                    R.anim.anim_slide_out_left);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        ProjectUtils.showToast(mContext, msg);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.e(TAG, "backResponse: flagd " + flagd + " " + flag);

            }
        });
    }

    public HashMap<String, String> getParams() {
        params.put(Consts.NAME_MITRA, ProjectUtils.getEditTextValue(binding.cetName));
        params.put(Consts.ALAMAT_MITRA, ProjectUtils.getEditTextValue(binding.cetAlamat));


        return params;
    }
}