package com.samyotech.laundrymitra.ui.activity.manage;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileOperasionalBinding;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ManageOperasionalProfile extends AppCompatActivity implements View.OnClickListener {
    public boolean checkAdd = true, doubleCheck = true;
    String TAG = ManageOperasionalProfile.class.getSimpleName();
    ActivityManageProfileOperasionalBinding binding;
    Context mContext;
    ProjectUtils projectUtils;
    NetworkManager networkManager;
    SharedPrefrence prefrence;
    UserDTO userDTO;
    HashMap<String, String> params = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_profile_operasional);
        mContext = ManageOperasionalProfile.this;
        prefrence = SharedPrefrence.getInstance(mContext);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        params.put(Consts.USER_ID, userDTO.getUser_id());

        setdata();
        binding.simpan.setOnClickListener(this);

        binding.back.setOnClickListener(this);


    }

    private void setdata() {

        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR_OF_DAY);
        final int minute = c.get(Calendar.MINUTE);
        binding.tvTutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




               TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0"+selectedMinute;
                        } else {
                            minute = ""+selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0"+selectedHour;
                        } else {
                            hours = ""+selectedHour;
                        }
                        binding.tvTutup.setText( hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });




        binding.tvBuka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0"+selectedMinute;
                        } else {
                            minute = ""+selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0"+selectedHour;
                        } else {
                            hours = ""+selectedHour;
                        }
                        binding.tvBuka.setText( hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.simpan:

                if (binding.tvBuka.getText().toString().isEmpty()) {
                    Toast.makeText(mContext, "Silahkan pilih jam buka", Toast.LENGTH_SHORT).show();
                } else if (binding.tvTutup.getText().toString().isEmpty()) {
                    Toast.makeText(mContext, "Silahkan pilih jam tutup", Toast.LENGTH_SHORT).show();
                } else {
                    getParams();
                    updateProfile();
                }
                break;

            case R.id.back:
                onBackPressed();
                break;


        }



    }


    public void updateProfile() {
        ProjectUtils.showProgressDialog(mContext, true, getResources().getString(R.string.please_wait));

        new HttpsRequest(Consts.EDIT_OP, params, mContext).stringPost(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) {
                ProjectUtils.pauseProgressDialog();
                if (flag) {
                    try {
                        Log.e(TAG, "backResponse: " + response.toString());
                        ProjectUtils.showToast(mContext, msg);
                        //userDTO = new Gson().fromJson(response.getJSONObject("data").toString(), UserDTO.class);
                        //prefrence.setParentUser(userDTO, Consts.USER_DTO);

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

        params.put(Consts.JAMBUKA, binding.tvBuka.getText().toString());
        params.put(Consts.JAMTUTUP, binding.tvTutup.getText().toString());
        params.put(Consts.USER_ID, userDTO.getUser_id());
        params.put(Consts.SHOP_ID, userDTO.getShop_id());


        return params;
    }


}
