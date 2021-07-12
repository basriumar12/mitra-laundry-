package com.samyotech.laundrymitra.ui.activity.manage;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.gson.Gson;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileBinding;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileMitraBinding;
import com.samyotech.laundrymitra.https.HttpsRequest;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.interfaces.Helper;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.network.NetworkManager;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.Dashboard;
import com.samyotech.laundrymitra.utils.ProjectUtils;
import com.schibstedspain.leku.LocationPickerActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ManageProfileMitra extends AppCompatActivity implements View.OnClickListener {
    public boolean checkAdd = true, doubleCheck = true;
    String TAG = ManageProfileMitra.class.getSimpleName();
    ActivityManageProfileMitraBinding binding;
    Context mContext;
    ProjectUtils projectUtils;
    NetworkManager networkManager;
    SharedPrefrence prefrence;
    UserDTO userDTO;
    HashMap<String, String> params = new HashMap<>();

    String latLong = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_profile_mitra);
        mContext = ManageProfileMitra.this;
        prefrence = SharedPrefrence.getInstance(mContext);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        params.put(Consts.USER_ID, userDTO.getUser_id());

        setdata();
        binding.simpan.setOnClickListener(this);
        binding.location.setOnClickListener(this);
        binding.back.setOnClickListener(this);

    }

    private void setdata() {
        Log.e(TAG, "setdata: " + userDTO.getUser_id());

        binding.namaLengkap.setText(userDTO.getName());
        binding.nomorHp.setText(userDTO.getMobile());
        binding.email.setText(userDTO.getEmail());

        if (!userDTO.getAddress().equalsIgnoreCase("")) {
            binding.alamat.setText(userDTO.getAddress());
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.simpan:

                if (!ProjectUtils.isEditTextFilled(binding.alamat)) {
                    Toast.makeText(mContext, R.string.addAddress, Toast.LENGTH_SHORT).show();
                }

                else if (latLong.equals("")){
                    Toast.makeText(mContext, "Belum memilih lokasi di map (caranya klik icon map)", Toast.LENGTH_SHORT).show();
                }
                else {


                    getParams();
                    updateProfile();
                }
                break;
            case R.id.location:
                findPlace();
                break;
            case R.id.back:
                onBackPressed();
                break;


        }


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

    public void updateProfile() {
        ProjectUtils.showProgressDialog(mContext, true, getResources().getString(R.string.please_wait));

        new HttpsRequest(Consts.REGISTER_MITRA, params, mContext).stringPost(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) {
                ProjectUtils.pauseProgressDialog();
                if (flag) {
                    try {
                        Log.e(TAG, "backResponse: " + response.toString());
                        ProjectUtils.showToast(mContext, msg);
                        prefrence.setBooleanValue(Consts.IS_REGISTERED, true);
                        Intent in = new Intent(mContext, Dashboard.class);
                        startActivity(in);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ProjectUtils.showToast(mContext, msg);
                }

            }
        });
    }

    private HashMap<String, String> getParams() {

        params.put(Consts.NAME_MITRA, ProjectUtils.getEditTextValue(binding.alamat));
        params.put(Consts.ALAMAT_MITRA, ProjectUtils.getEditTextValue(binding.namaLengkap));
        params.put(Consts.USER_ID, userDTO.getUser_id());


        return params;
    }


    private void findPlace() {
        Intent locationPickerIntent = new LocationPickerActivity.Builder()
                .withGooglePlacesEnabled()
                .withLocation(Double.parseDouble(prefrence.getValue(Consts.LATITUDE)),
                        Double.parseDouble(prefrence.getValue(Consts.LONGITUDE)))
                .build(mContext);

        startActivityForResult(locationPickerIntent, 101);
    }


    public void getAddress(double lat, double lng) {
        latLong = ""+lat;
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
            Log.e("IGA", "Address" + add + " " + lat + " " + lng);
            // Toast.makeText(this, "Address=>" + add,
            // Toast.LENGTH_SHORT).show();

            // TennisAppActivity.showDialog(add);
            binding.alamat.setText(obj.getAddressLine(0));

            params.put(Consts.ALAMAT_MITRA, obj.getAddressLine(0));
            params.put(Consts.LATITUDE, String.valueOf(lat));
            params.put(Consts.LONGITUDE, String.valueOf(lng));


        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e("TAG", " errror lat " + e.getMessage());
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        checkAdd = true;

    }


}
