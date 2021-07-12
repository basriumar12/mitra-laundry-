package com.samyotech.laundrymitra.ui.activity.ulasan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityUlasanBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.ulasandata.UlasanNewDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.adapter.ulasan.UlasanAdapter;
import com.taufiqrahman.reviewratings.BarLabels;
import com.taufiqrahman.reviewratings.RatingReviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UlasanActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG = UlasanActivity.class.getSimpleName();
    ActivityUlasanBinding binding;
    Context mContext;
    SharedPrefrence prefrence;
    UserDTO userDTO;
    HashMap<String, String> params = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ulasan);
        mContext = UlasanActivity.this;
        prefrence = SharedPrefrence.getInstance(mContext);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        params.put(Consts.USER_ID, userDTO.getUser_id());


        getUlasan();

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        RatingReviews ratingReviews = (RatingReviews) findViewById(R.id.rating_reviews);

        int colors[] = new int[]{
                Color.parseColor("#0e9d58"),
                Color.parseColor("#bfd047"),
                Color.parseColor("#ffc105"),
                Color.parseColor("#ef7e14"),
                Color.parseColor("#d36259")};


        int raters[] = new int[]{
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100)
        };

        ratingReviews.createRatingBars(100, BarLabels.STYPE3, Color.parseColor("#FFC107"), raters);

    }

    private void getUlasan() {
        final ProgressDialog progressDialog = new ProgressDialog(UlasanActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );


        api.getUlasan(
                "YZ65d0"
                //userDTO.getShop_id()


        ).enqueue(new Callback<BaseResponse<List<UlasanNewDto>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<UlasanNewDto>>> call, Response<BaseResponse<List<UlasanNewDto>>> response) {


                progressDialog.dismiss();
                if (response.isSuccessful()) {

                    if (response.body().isStatus()) {


                        int totalUlasan = response.body().getData().size();
                        String totalRating =response.body().getTotalRating();


                        binding.tvTotalRating.setText(totalRating.substring(0, totalRating.length() - 3));
                        binding.tvTotalUlasan.setText(""+totalUlasan + " Ulasan");

                        String rating = response.body().getTotalRating();
                        if (rating.equals("") || rating.equals(null)) {
                            rating = "0.0";
                        }
                        binding.arb.setRating(Float.parseFloat(rating));

                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
                        binding.rvUlasan.setLayoutManager(linearLayoutManager);
                        UlasanAdapter penjualanAdapter = new UlasanAdapter(mContext, (ArrayList<UlasanNewDto>) response.body().getData());
                        binding.rvUlasan.setAdapter(penjualanAdapter);


                    } else {
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }


            }

            @Override
            public void onFailure(Call<BaseResponse<List<UlasanNewDto>>> call, Throwable t) {

            }
        });


    }


    @Override
    public void onClick(View v) {


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }


}
