package com.samyotech.laundrymitra.ui.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.HomeFragmentBinding;
import com.samyotech.laundrymitra.https.HttpsRequest;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.interfaces.Helper;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.home.PentingHariIniDto;
import com.samyotech.laundrymitra.model.home.TerlarisHariIniDto;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.Dashboard;
import com.samyotech.laundrymitra.ui.activity.NotificationActivity;
import com.samyotech.laundrymitra.ui.activity.SearchActivity;
import com.samyotech.laundrymitra.ui.activity.TopServices;
import com.samyotech.laundrymitra.ui.adapter.home.TerlarisAdapter;
import com.samyotech.laundrymitra.utils.ProjectUtils;
import com.schibstedspain.leku.LocationPickerActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import mehdi.sakout.fancybuttons.FancyButton;

import static android.app.Activity.RESULT_OK;


public class HomeFragment extends Fragment implements View.OnClickListener {

    HomeFragmentBinding binding;
    View view;
    LinearLayoutManager linearLayoutManager;
    TerlarisHariIniDto terlarisHariIniDto;
    Dashboard dashBoard;
    TerlarisAdapter terlarisAdapter;
    String TAG = HomeFragment.class.getSimpleName();
    HashMap<String, String> params = new HashMap<>();
    PentingHariIniDto dataDto = new PentingHariIniDto();
    UserDTO userDTO;
    private SharedPrefrence prefrence;
    private FusedLocationProviderClient fusedLocationClient;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);
        view = binding.getRoot();
        prefrence = SharedPrefrence.getInstance(getActivity());
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        if (userDTO.getImage_ktp().isEmpty() || userDTO.getImage_ktp().equals(null)){
          //  startActivity(new Intent(getActivity(), UploadKtpActivity.class));
            //getActivity().finish();
        }


        getPentingHariIni();
        getAllTerlaris();

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }

        return view;
    }

    void dialogLokasi() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.CustomAlertDialog);
        ViewGroup viewGroup = requireView().findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(requireActivity()).inflate(R.layout.dialog_logout, viewGroup, false);
        TextView tv = dialogView.findViewById(R.id.text);
        tv.setText("Data lokasi tidak di dapatkan. \n Aktikan lokasi gps di handphone anda dan coba tutup aplikasi kemudian buka kembali dan akses menu ini.");
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();


        FancyButton cancel = dialogView.findViewById(R.id.cancel);

        cancel.setVisibility(View.GONE);

        FancyButton ok = dialogView.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();


            }
        });
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getPentingHariIni();
        binding.tvNameHome.setText(userDTO.getName());

        binding.tvPesanBaru.setText("tee");

        if (dataDto != null){
            Log.e("TAG",new Gson().toJson(dataDto)+" "+dataDto.getPendapatan_bersih_baru()+" "+dataDto.getChatBelumDibaca());

            binding.tvPesanBaru.setText(""+dataDto.getPesananBaru());
            binding.tvChatBelumDibaca.setText(""+dataDto.getChatBelumDibaca());
            binding.tvPendapatanBersihBaru.setText(""+dataDto.getPendapatan_bersih_baru());
            binding.tvUlasanBaru.setText(""+dataDto.getUlasanSelesai());
            binding.tvPesananKomplain.setText(""+dataDto.getPesananKomplain());
            binding.tvPesananSelesai.setText(""+dataDto.getPesananSelesai());
        }else {
            getPentingHariIni();
            binding.tvPesanBaru.setText(""+dataDto.getPesananBaru());
            binding.tvChatBelumDibaca.setText(""+dataDto.getChatBelumDibaca());
            binding.tvPendapatanBersihBaru.setText(""+dataDto.getPendapatan_bersih_baru());
            binding.tvUlasanBaru.setText(""+dataDto.getUlasanSelesai());
            binding.tvPesananKomplain.setText(""+dataDto.getPesananKomplain());
            binding.tvPesananSelesai.setText(""+dataDto.getPesananSelesai());
        }



    }






    private void findPlace() {
        Intent locationPickerIntent = new LocationPickerActivity.Builder()
                .withGooglePlacesEnabled()
                .withLocation(Double.parseDouble(prefrence.getValue(Consts.LATITUDE)),
                        Double.parseDouble(prefrence.getValue(Consts.LONGITUDE)))
                .build(requireActivity());

        startActivityForResult(locationPickerIntent, 101);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                try {
                    getAddress(data.getDoubleExtra(Consts.LATITUDE, 0.0), data.getDoubleExtra(Consts.LONGITUDE, 0.0));
                    //updateProfile();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getAddress(double lat, double lng) {

        try {
            Geocoder geocoder = new Geocoder(requireActivity(), Locale.getDefault());
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

            prefrence.setValue(Consts.LATITUDE, String.valueOf(obj.getLatitude()));
            prefrence.setValue(Consts.LONGITUDE, String.valueOf(obj.getLongitude()));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void getPentingHariIni() {
       // ProjectUtils.showProgressDialog(requireActivity(), true, getResources().getString(R.string.please_wait));

        new HttpsRequest(Consts.HOME_PENTING, getActivity(), userDTO.getUser_id().toString(), "").stringResendOTP("TAG", new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) throws JSONException {
                ProjectUtils.cancelDialog();
                ProjectUtils.pauseProgressDialog();

                if (flag) {

                    try {
                             dataDto = new Gson().fromJson(response.getJSONObject("data").toString(), PentingHariIniDto.class);
                        Log.e("TAG",new Gson().toJson(dataDto)+" "+dataDto.getPendapatan_bersih_baru()+" "+dataDto.getChatBelumDibaca());


                        binding.tvPesanBaru.setText(dataDto.getPesananBaru());
                        binding.tvChatBelumDibaca.setText(dataDto.getChatBelumDibaca()+" aaa"+dataDto.getPendapatan_bersih_baru());
                        binding.tvPendapatanBersihBaru.setText(dataDto.getPendapatan_bersih_baru());
                        binding.tvUlasanBaru.setText(dataDto.getUlasanSelesai());
                        binding.tvPesananKomplain.setText(dataDto.getPesananKomplain());
                        binding.tvPesananSelesai.setText(dataDto.getPesananSelesai());
                        TextView tv = view.findViewById(R.id.tv_chat_belum_dibaca);
                        tv.setText(dataDto.getChatBelumDibaca());

                    } catch (Exception e) {
                        e.getMessage();
                        ProjectUtils.cancelDialog();
                        ProjectUtils.pauseProgressDialog();

                    }


                } else {
                    ProjectUtils.cancelDialog();
                    ProjectUtils.pauseProgressDialog();
                }
            }
        });


    }

    public void updateProfile() {
        ProjectUtils.showProgressDialog(requireActivity(), true, getResources().getString(R.string.please_wait)).show();

        new HttpsRequest(Consts.USERUPDATE, params, requireActivity()).stringPost(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) {
                ProjectUtils.pauseProgressDialog();
                if (flag) {
                    try {


                        Log.e(TAG, "backResponse: " + response.toString());
                        //   ProjectUtils.showToast(requireContext(), msg);
                        userDTO = new Gson().fromJson(response.getJSONObject("data").toString(), UserDTO.class);
                        prefrence.setParentUser(userDTO, Consts.USER_DTO);
                        prefrence.setBooleanValue(Consts.IS_REGISTERED, true);
                        Intent in = new Intent(requireContext(), Dashboard.class);
                        startActivity(in);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
//                    ProjectUtils.showToast(mContext, msg);
                }

            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        //  stopLocationUpdates();
        super.onPause();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dashBoard = (Dashboard) context;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lihat_semua_laundry_terdekat:
                Intent in2 = new Intent(getActivity(), TopServices.class);
                startActivity(in2);
                break;
//            case R.id.lihat_semua_layanan_kami:
//                Intent in = new Intent(getActivity(), AllServices.class);
//                startActivity(in);
//                break;
            case R.id.ivSearch:
                Intent in3 = new Intent(getActivity(), SearchActivity.class);
                startActivity(in3);
                break;
            case R.id.ivNotification:
                Intent in4 = new Intent(getActivity(), NotificationActivity.class);
                startActivity(in4);
                break;
        }
    }

    public void getAllTerlaris() {
        //ProjectUtils.getProgressDialog(getActivity());
        params.put(Consts.USER_ID, userDTO.getUser_id());
        new HttpsRequest(Consts.GET_TERLARIS+"?user_id="+userDTO.getUser_id()+"&shop_id=YZ65d0", params, getActivity()).stringOTP(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) throws JSONException {
                ProjectUtils.pauseProgressDialog();
                if (flag) {
                    Log.e("TAG","data terlaris "+flag +" "+new Gson().toJson(response));
                    try {
                        terlarisHariIniDto = new Gson().fromJson(response.getJSONObject("data").toString(), TerlarisHariIniDto.class);
                        Log.e("TAG","data terlaris "+new Gson().toJson(terlarisHariIniDto));
                        setData();
                    } catch (Exception e) {
                        terlarisHariIniDto = new Gson().fromJson(response.getJSONObject("data").toString(), TerlarisHariIniDto.class);

                        ProjectUtils.pauseProgressDialog();
                        e.printStackTrace();
                        Log.e("TAG","error data terlaris "+e.getMessage());
                        terlarisHariIniDto = new Gson().fromJson(response.getJSONObject("data").toString(), TerlarisHariIniDto.class);

                    }

                }
            }
        });


    }

    private void setData() {

        Log.e("TAG","set data terlaris "+terlarisHariIniDto);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        binding.rvTerlaris.setLayoutManager(linearLayoutManager);
        terlarisAdapter = new TerlarisAdapter(getActivity(), terlarisHariIniDto.getOrder_list());
        binding.rvTerlaris.setAdapter(terlarisAdapter);
    }


}
