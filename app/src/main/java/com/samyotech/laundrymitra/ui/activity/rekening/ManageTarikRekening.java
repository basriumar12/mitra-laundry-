package com.samyotech.laundrymitra.ui.activity.rekening;

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
import com.samyotech.laundrymitra.databinding.ActivityManageProfileRekeningBinding;
import com.samyotech.laundrymitra.databinding.ActivityManageTarikRekeningBinding;
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

public class ManageTarikRekening extends AppCompatActivity implements View.OnClickListener {
    public boolean checkAdd = true, doubleCheck = true;
    String TAG = ManageTarikRekening.class.getSimpleName();
    ActivityManageTarikRekeningBinding binding;
    Context mContext;
    ProjectUtils projectUtils;
    NetworkManager networkManager;
    SharedPrefrence prefrence;
    UserDTO userDTO;
    HashMap<String, String> params = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_tarik_rekening);
        mContext = ManageTarikRekening.this;
        prefrence = SharedPrefrence.getInstance(mContext);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        params.put(Consts.USER_ID, userDTO.getUser_id());

        setdata();
        binding.simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!ProjectUtils.isEditTextFilled(binding.edtPenarikan) || binding.edtPenarikan.getText().toString().isEmpty() || binding.edtPenarikan.getText().toString().equals("")) {
                    Toast.makeText(mContext, "Silahkan isi jumlah penarikan", Toast.LENGTH_SHORT).show();
                } else {
                    String saldo = userDTO.getTotal_pendapatan().replaceFirst("Rp. ", "");

                    if (saldo.isEmpty() || saldo.equals("0") || saldo.equals("")) {
                        Toast.makeText(mContext, "Saldo anda Rp. 0", Toast.LENGTH_SHORT).show();
                    }
                    int jumlahSaldo = Integer.parseInt(saldo);
                    int jumlahPenarikan = Integer.parseInt(binding.edtPenarikan.getText().toString());

                    if (jumlahPenarikan > jumlahSaldo) {
                        Toast.makeText(mContext, "Jumlah penarikan terlalu besar dan saldo anda "+userDTO.getTotal_pendapatan(), Toast.LENGTH_SHORT).show();
                    } else {

                        getParams();
                        updateProfile();
                    }
                }
            }
        });
        binding.back.setOnClickListener(this);

    }

    private void setdata() {
        Log.e(TAG, "setdata: " + userDTO.getUser_id());

        if (userDTO.getRekening() != null) {
            binding.tvPendapatan.setText(userDTO.getTotal_pendapatan());
            binding.tvNamaMitra.setText(userDTO.getNama_mitra());
            binding.tvDataRekening.setText(
                    userDTO.getRekening().getAccountName() +
                            " - " +
                            userDTO.getRekening().getBankName() +
                            " - "
                            + userDTO.getRekening().getNumberBank()


            );

        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.simpan:


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

        new HttpsRequest(Consts.PENGAJUANDANA, params, mContext).stringPost(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) {
                ProjectUtils.pauseProgressDialog();
                if (flag) {
                    try {
                        Log.e(TAG, "backResponse: " + response.toString());
                        ProjectUtils.showToast(mContext, msg);
                        userDTO = new Gson().fromJson(response.getJSONObject("data").toString(), UserDTO.class);

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

        params.put(Consts.DANA_TOTAL, ProjectUtils.getEditTextValue(binding.edtPenarikan));
        params.put(Consts.USER_ID, userDTO.getUser_id());
        params.put(Consts.SHOP_ID, userDTO.getShop_id());


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

            params.put(Consts.ADDRESS, obj.getAddressLine(0));
            params.put(Consts.LATITUDE, String.valueOf(obj.getLatitude()));
            params.put(Consts.LONGITUDE, String.valueOf(obj.getLongitude()));


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        checkAdd = true;

    }


}
