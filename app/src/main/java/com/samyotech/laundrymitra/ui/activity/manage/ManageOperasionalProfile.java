package com.samyotech.laundrymitra.ui.activity.manage;

import android.app.ProgressDialog;
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

import com.google.gson.Gson;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityManageProfileOperasionalBinding;
import com.samyotech.laundrymitra.https.HttpsRequest;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.interfaces.Helper;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.home.PentingHariIniDto;
import com.samyotech.laundrymitra.model.oprational.JamItem;
import com.samyotech.laundrymitra.model.oprational.JamItemData;
import com.samyotech.laundrymitra.model.oprational.OprationalBody;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.NetworkManager;
import com.samyotech.laundrymitra.network.ResponseOther;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.Dashboard;
import com.samyotech.laundrymitra.ui.activity.ulasan.UlasanActivity;
import com.samyotech.laundrymitra.utils.ProjectUtils;
import com.schibstedspain.leku.LocationPickerActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageOperasionalProfile extends AppCompatActivity implements View.OnClickListener {
    public boolean checkAdd = true, doubleCheck = true;
    String TAG = ManageOperasionalProfile.class.getSimpleName();
    ActivityManageProfileOperasionalBinding binding;
    Context mContext;
    ProjectUtils projectUtils;
    NetworkManager networkManager;
    SharedPrefrence prefrence;
    List<JamItemData> jamItems = new ArrayList<>();
    List<JamItem> jamItemsFromApi = new ArrayList<>();
    UserDTO userDTO;

    JamItemData jamItemsenin = new JamItemData();
    JamItemData jamItemselasa = new JamItemData();
    JamItemData jamItemrabu = new JamItemData();
    JamItemData jamItemkamis = new JamItemData();
    JamItemData jamItemjumat = new JamItemData();
    JamItemData jamItemsabtu = new JamItemData();
    JamItemData jamItemminggu = new JamItemData();

    String statusSenin, statusSelasa, statusRabu, statusKamis, statusJumat, statusSabtu, statusMinggu;
    HashMap<String, String> params = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_profile_operasional);
        mContext = ManageOperasionalProfile.this;
        prefrence = SharedPrefrence.getInstance(mContext);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        params.put(Consts.USER_ID, userDTO.getUser_id());
        getData();
        setdata();
        binding.simpan.setOnClickListener(this);

        binding.back.setOnClickListener(this);


    }

    private void setdata() {


        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR_OF_DAY);
        final int minute = c.get(Calendar.MINUTE);
        binding.tvTutupSenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvTutupSenin.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });


        binding.tvBukaSenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvBukaSenin.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });
        binding.tvBukaSelasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvBukaSelasa.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });


        binding.tvTutupSelasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvTutupSelasa.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        binding.tvBukaRabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvBukaRabu.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });


        binding.tvTutupRabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvTutupRabu.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        binding.tvBukaKamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvBukaKamis.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        binding.tvTutupKamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvTutupKamis.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        binding.tvBukaJumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvBukaJumat.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });


        binding.tvTutupJumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvTutupJumat.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        binding.tvBukaSabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvBukaSabtu.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        binding.tvTutupSabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvTutupSabtu.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        binding.tvBukaMinggu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvBukaMinggu.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        binding.tvTutupMinggu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ManageOperasionalProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minute = "";
                        String hours = "";
                        if (selectedMinute < 10) {
                            minute = "0" + selectedMinute;
                        } else {
                            minute = "" + selectedMinute;
                        }

                        if (selectedHour < 10) {
                            hours = "0" + selectedHour;
                        } else {
                            hours = "" + selectedHour;
                        }
                        binding.tvTutupMinggu.setText(hours + ":" + minute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        binding.senin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.senin.isChecked()) {
                    statusSenin = "1";
                } else {
                    statusSenin = "0";
                }
                jamItemsenin.setStatus(statusSenin);
            }
        });


        binding.selasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.selasa.isChecked()) {
                    statusSelasa = "1";
                } else {
                    statusSelasa = "0";
                }

                jamItemselasa.setStatus(statusSelasa);
            }
        });

        binding.rabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.rabu.isChecked()) {
                    statusRabu = "1";
                } else {
                    statusRabu = "0";
                }
                jamItemrabu.setStatus(statusRabu);
            }
        });

        binding.kamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.kamis.isChecked()) {
                    statusKamis = "1";
                } else {
                    statusKamis = "0";
                }
                jamItemkamis.setStatus(statusKamis);
            }
        });


        binding.jumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.jumat.isChecked()) {
                    statusJumat = "1";
                } else {
                    statusJumat = "0";
                }
                jamItemjumat.setStatus(statusJumat);

            }
        });

        binding.sabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.sabtu.isChecked()) {
                    statusSabtu = "1";
                } else {
                    statusSabtu = "0";
                }
                jamItemsabtu.setStatus(statusSabtu);

            }
        });


        binding.minggu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.minggu.isChecked()) {
                    statusMinggu = "1";
                } else {
                    statusMinggu = "0";
                }
                jamItemminggu.setStatus(statusMinggu);

            }
        });


//        if (binding.senin.isChecked()) {
//            statusSenin = "1";
//        } else {
//            statusSenin = "0";
//        }
//
//
//        if (binding.selasa.isChecked()) {
//            statusSelasa = "1";
//        } else {
//            statusSelasa = "0";
//        }
//
//
//        if (binding.rabu.isChecked()) {
//            statusRabu = "1";
//        } else {
//            statusRabu = "0";
//        }
//        if (binding.kamis.isChecked()) {
//            statusKamis = "1";
//        } else {
//            statusKamis = "0";
//        }
//        if (binding.jumat.isChecked()) {
//            statusJumat = "1";
//        } else {
//            statusJumat = "0";
//        }
//
//        if (binding.sabtu.isChecked()) {
//            statusSabtu = "1";
//        } else {
//            statusSabtu = "0";
//        }
//
//        if (binding.minggu.isChecked()) {
//            statusMinggu = "1";
//        } else {
//            statusMinggu = "0";
//        }



    }

    public void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(ManageOperasionalProfile.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        api.getJamOpertational(userDTO.getUser_id(), userDTO.getShop_id()).enqueue(new Callback<BaseResponse<List<JamItem>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<JamItem>>> call, Response<BaseResponse<List<JamItem>>> response) {


                progressDialog.dismiss();
                if (response.isSuccessful()) {

                    if (response.body().isStatus()) {
                        //senin

                        if (!response.body().getData().isEmpty())


                            binding.tvBukaSenin.setText(response.body().getData().get(0).getJamBuka());
                        binding.tvTutupSenin.setText(response.body().getData().get(0).getJamTutup());

                        binding.tvBukaSelasa.setText(response.body().getData().get(1).getJamBuka());
                        binding.tvTutupSelasa.setText(response.body().getData().get(1).getJamTutup());

                        binding.tvBukaRabu.setText(response.body().getData().get(2).getJamBuka());
                        binding.tvTutupRabu.setText(response.body().getData().get(2).getJamTutup());

                        binding.tvBukaKamis.setText(response.body().getData().get(3).getJamBuka());
                        binding.tvTutupKamis.setText(response.body().getData().get(3).getJamTutup());

                        binding.tvBukaJumat.setText(response.body().getData().get(4).getJamBuka());
                        binding.tvTutupJumat.setText(response.body().getData().get(4).getJamTutup());

                        binding.tvBukaSabtu.setText(response.body().getData().get(5).getJamBuka());
                        binding.tvTutupSabtu.setText(response.body().getData().get(5).getJamTutup());

                        binding.tvBukaMinggu.setText(response.body().getData().get(6).getJamBuka());
                        binding.tvTutupMinggu.setText(response.body().getData().get(6).getJamTutup());


                        binding.senin.setChecked(response.body().getData().get(0).getStatus().equals("1"));
                        binding.selasa.setChecked(response.body().getData().get(1).getStatus().equals("1"));
                        binding.rabu.setChecked(response.body().getData().get(2).getStatus().equals("1"));
                        binding.kamis.setChecked(response.body().getData().get(3).getStatus().equals("1"));
                        binding.jumat.setChecked(response.body().getData().get(4).getStatus().equals("1"));
                        binding.sabtu.setChecked(response.body().getData().get(5).getStatus().equals("1"));
                        binding.minggu.setChecked(response.body().getData().get(6).getStatus().equals("1"));

                        statusSenin = response.body().getData().get(0).getStatus();
                        statusSelasa = response.body().getData().get(1).getStatus();
                        statusRabu = response.body().getData().get(2).getStatus();
                        statusKamis = response.body().getData().get(3).getStatus();
                        statusJumat = response.body().getData().get(4).getStatus();
                        statusSabtu = response.body().getData().get(5).getStatus();
                        statusMinggu = response.body().getData().get(6).getStatus();

                        jamItemjumat.setStatus(statusJumat);
                        jamItemselasa.setStatus(statusSelasa);
                        jamItemsenin.setStatus(statusSenin);
                        jamItemkamis.setStatus(statusKamis);
                        jamItemsabtu.setStatus(statusSabtu);
                        jamItemrabu.setStatus(statusRabu);
                        jamItemminggu.setStatus(statusMinggu);


                        jamItemsFromApi = response.body().getData();
                        if (!jamItemsFromApi.isEmpty() || jamItemsFromApi != null) {
                            setDataFromApi();
                        }


                    }

                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<JamItem>>> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(mContext, "Gagal dapatkan data jam operasional", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setDataFromApi() {


        if (!jamItemsFromApi.isEmpty()) {
            //senin
            jamItemsenin.setId(jamItemsFromApi.get(0).getId());
            //selasa
            jamItemselasa.setId(jamItemsFromApi.get(1).getId());
            //rabu
            jamItemrabu.setId(jamItemsFromApi.get(2).getId());
            //kamis
            jamItemkamis.setId(jamItemsFromApi.get(3).getId());
            //jumat
            jamItemjumat.setId(jamItemsFromApi.get(4).getId());
            //sabtu
            jamItemsabtu.setId(jamItemsFromApi.get(5).getId());
            //minggu
            jamItemminggu.setId(jamItemsFromApi.get(6).getId());


        }


        jamItemsenin.setJamBuka(binding.tvBukaSenin.getText().toString());
        jamItemsenin.setJamTutup(binding.tvTutupSenin.getText().toString());
        jamItemsenin.setStatus(statusSenin);


        jamItemselasa.setJamBuka(binding.tvBukaSelasa.getText().toString());
        jamItemselasa.setJamTutup(binding.tvTutupSelasa.getText().toString());
        jamItemselasa.setStatus(statusSelasa);

        jamItemrabu.setJamBuka(binding.tvBukaRabu.getText().toString());
        jamItemrabu.setJamTutup(binding.tvTutupRabu.getText().toString());
        jamItemrabu.setStatus(statusRabu);

        jamItemkamis.setJamBuka(binding.tvBukaKamis.getText().toString());
        jamItemkamis.setJamTutup(binding.tvTutupKamis.getText().toString());
        jamItemkamis.setStatus(statusKamis);

        jamItemjumat.setJamBuka(binding.tvBukaJumat.getText().toString());
        jamItemjumat.setJamTutup(binding.tvTutupJumat.getText().toString());
        jamItemjumat.setStatus(statusJumat);

        jamItemsabtu.setJamBuka(binding.tvBukaSabtu.getText().toString());
        jamItemsabtu.setJamTutup(binding.tvTutupSabtu.getText().toString());
        jamItemsabtu.setStatus(statusSabtu);


        jamItemminggu.setJamBuka(binding.tvBukaMinggu.getText().toString());
        jamItemminggu.setJamTutup(binding.tvTutupMinggu.getText().toString());
        jamItemminggu.setStatus(statusMinggu);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.simpan:
                updateProfile();

                break;

            case R.id.back:
                onBackPressed();
                break;


        }


    }


    public void updateProfile() {

        jamItemsenin.setJamBuka(binding.tvBukaSenin.getText().toString());
        jamItemsenin.setJamTutup(binding.tvTutupSenin.getText().toString());



        jamItemselasa.setJamBuka(binding.tvBukaSelasa.getText().toString());
        jamItemselasa.setJamTutup(binding.tvTutupSelasa.getText().toString());


        jamItemrabu.setJamBuka(binding.tvBukaRabu.getText().toString());
        jamItemrabu.setJamTutup(binding.tvTutupRabu.getText().toString());


        jamItemkamis.setJamBuka(binding.tvBukaKamis.getText().toString());
        jamItemkamis.setJamTutup(binding.tvTutupKamis.getText().toString());


        jamItemjumat.setJamBuka(binding.tvBukaJumat.getText().toString());
        jamItemjumat.setJamTutup(binding.tvTutupJumat.getText().toString());


        jamItemsabtu.setJamBuka(binding.tvBukaSabtu.getText().toString());
        jamItemsabtu.setJamTutup(binding.tvTutupSabtu.getText().toString());



        jamItemminggu.setJamBuka(binding.tvBukaMinggu.getText().toString());
        jamItemminggu.setJamTutup(binding.tvTutupMinggu.getText().toString());





        jamItems.add(jamItemsenin);
        jamItems.add(jamItemselasa);
        jamItems.add(jamItemrabu);
        jamItems.add(jamItemkamis);
        jamItems.add(jamItemjumat);
        jamItems.add(jamItemsabtu);
        jamItems.add(jamItemminggu);


        final ProgressDialog progressDialog = new ProgressDialog(ManageOperasionalProfile.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );

        OprationalBody body = new OprationalBody();
        body.setShopId(userDTO.getShop_id());
        body.setJam(jamItems);
        Log.e("TAG", "body " + new Gson().toJson(body));
        api.postJamOpertational(body).enqueue(new Callback<ResponseOther>() {
            @Override
            public void onResponse(Call<ResponseOther> call, Response<ResponseOther> response) {

                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        finish();
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseOther> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(mContext, "Gagal update jam operasional", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
