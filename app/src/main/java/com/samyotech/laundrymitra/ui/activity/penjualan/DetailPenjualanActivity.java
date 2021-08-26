package com.samyotech.laundrymitra.ui.activity.penjualan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityDetailPenjualanBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanDto;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanList;
import com.samyotech.laundrymitra.model.penjualan.StatusPenjualanDto;
import com.samyotech.laundrymitra.model.penjualan.UbahStatusDto;
import com.samyotech.laundrymitra.model.rekening.DaftarRekeningDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ResponseOther;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.ui.activity.chat.ChatActivity;
import com.samyotech.laundrymitra.ui.activity.chat.ChatToKonsumenActivity;
import com.samyotech.laundrymitra.ui.adapter.penjualan.DetailPenjualanAdapter;
import com.samyotech.laundrymitra.ui.adapter.penjualan.StatusPenjualanAdapter;
import com.samyotech.laundrymitra.ui.adapter.rekening.BankAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPenjualanActivity extends AppCompatActivity implements StatusPenjualanAdapter.OnItemClickListener {

    ActivityDetailPenjualanBinding binding;
    Context mContext;
    LinearLayoutManager linearLayoutManager;
    DetailPenjualanAdapter detailPenjualanAdapter;
    String id;

    BottomSheetDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penjualan);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_penjualan);
        mContext = DetailPenjualanActivity.this;
        id = getIntent().getStringExtra("ID");
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getDetailPenjualanData();
        binding.confirmBtnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ubahStatus();
            }
        });



    }

    private void ubahStatus() {
        dialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.view_status_penjualan, null);
        Window window = dialog.getWindow();
        window.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(view);
        RecyclerView recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        List<StatusPenjualanDto> data = new ArrayList<>();
        StatusPenjualanDto itemes1 = new StatusPenjualanDto();
        StatusPenjualanDto itemes2 = new StatusPenjualanDto();
        StatusPenjualanDto itemes3 = new StatusPenjualanDto();
        StatusPenjualanDto itemes4 = new StatusPenjualanDto();
        StatusPenjualanDto itemes5 = new StatusPenjualanDto();
        StatusPenjualanDto itemes6 = new StatusPenjualanDto();
        StatusPenjualanDto itemes7 = new StatusPenjualanDto();

//        itemes1.setId(0);
//        itemes1.setName("Tertunda");
//
//        itemes2.setId(1);
//        itemes2.setName("Konfirmasi");

        itemes3.setId(2);
        itemes3.setName("Di Jemput ");

        itemes4.setId(3);
        itemes4.setName("Proses");

        itemes5.setId(4);
        itemes5.setName("Di Kirim");

        itemes6.setId(5);
        itemes6.setName("Terkirim");

        itemes7.setId(6);
        itemes7.setName("Cancel");


//
//        data.add(itemes1);
//        data.add(itemes2);
        data.add(itemes3);
        data.add(itemes4);
        data.add(itemes5);
        data.add(itemes6);
        data.add(itemes7);

        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(linearLayoutManager);
        StatusPenjualanAdapter adapter = new StatusPenjualanAdapter(this,data,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dialog.show();


    }

    public void getDetailPenjualanData() {
        final ProgressDialog progressDialog = new ProgressDialog(DetailPenjualanActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        binding.layoutParent.setVisibility(View.GONE);

        api.getDetailPenjualan(id).enqueue(new Callback<BaseResponse<DetailPenjualanDto>>() {

            @Override
            public void onResponse(Call<BaseResponse<DetailPenjualanDto>> call, final Response<BaseResponse<DetailPenjualanDto>> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()) {
                        binding.layoutParent.setVisibility(View.VISIBLE);
                        binding.namaPesanan.setText("Pesanan");
                        binding.noOrder.setText(response.body().getData().getOrderId());
                        binding.namaPemesan.setText(response.body().getData().getNamaKonsumen());
                        binding.dateTimeJemput.setText(response.body().getData().getPickupDate() + "•" + response.body().getData().getPickupTime());
                        binding.dateTimeAntar.setText(response.body().getData().getDeliveryDate() + "•" + response.body().getData().getDeliveryTime());
                        binding.addressJemput.setText(response.body().getData().getShippingAddress());
                        binding.addressAntar.setText(response.body().getData().getShippingAddress());
                        binding.subtotal.setText(response.body().getData().getCurrencyCode() + " " + response.body().getData().getPrice());
                        binding.diskon.setText(response.body().getData().getCurrencyCode() + " " + response.body().getData().getDiscount());
                        binding.totalPembayaran.setText(response.body().getData().getCurrencyCode() + " " + response.body().getData().getFinalPrice());
                        binding.pajak.setText(response.body().getData().getCurrencyCode() + " " + response.body().getData().getDiscount());
                        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
                        binding.rvDetailPenjualan.setLayoutManager(linearLayoutManager);
                        detailPenjualanAdapter = new DetailPenjualanAdapter(mContext, (ArrayList<DetailPenjualanList>) response.body().getData().getItemDetails(), DetailPenjualanActivity.this);
                        binding.rvDetailPenjualan.setAdapter(detailPenjualanAdapter);
                        String status = response.body().getData().getStatus();
                        String statusName = "";
                        if (status.equals("0")){
                            statusName = "Tertunda";
                        }
                        else if (status.equals("1")){
                            statusName ="Konfirmasi";
                        }
                        else if (status.equals("2")){
                            statusName ="Di Jemput";
                        }
                        else if (status.equals("3")){
                            statusName ="Proses";
                        }
                        else if (status.equals("4")){
                            statusName ="Di Kirim";
                        }
                        else if (status.equals("5")){
                            statusName ="Terkirim";
                        }
                        else if (status.equals("6")){
                            statusName ="Cancel";

                        }

                        binding.tvStatus.setText(statusName);


                        binding.confirmBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(DetailPenjualanActivity.this, ChatToKonsumenActivity.class);
                                intent.putExtra("TO_USER_ID", response.body().getData().getUserId());
                                intent.putExtra("NAME", response.body().getData().getNamaKonsumen());
                                startActivity(intent);
                            }
                        });

                    } else {
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        binding.layoutParent.setVisibility(View.GONE);


                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<DetailPenjualanDto>> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
                binding.layoutParent.setVisibility(View.GONE);
                Toast.makeText(mContext, "Gagal dapatkan data detail penjualan, akses ke server gagal, silahkan coba beberapa saat lagi", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });


    }

    @Override
    public void onItemClick(StatusPenjualanDto item) {
        Toast.makeText(mContext, "Proses merubah status ke "+item.getName(), Toast.LENGTH_SHORT).show();
        postUbahStatus(item);
        dialog.dismiss();
    }

    private void postUbahStatus(StatusPenjualanDto s) {
        final ProgressDialog progressDialog = new ProgressDialog(DetailPenjualanActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );

        UbahStatusDto body = new UbahStatusDto();
        body.setOrderId(id);
        body.setOrderStatus(String.valueOf(s.getId()));

        api.postUbahStatus(body).enqueue(new Callback<ResponseOther>() {
            @Override
            public void onResponse(Call<ResponseOther> call, Response<ResponseOther> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    if (response.body().isStatus()){
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseOther> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(mContext, "Gagal dapatkan ubah status, akses ke server gagal karena kesalahan respon, silahkan coba beberapa saat lagi", Toast.LENGTH_SHORT).show();

            }
        });
    }
}