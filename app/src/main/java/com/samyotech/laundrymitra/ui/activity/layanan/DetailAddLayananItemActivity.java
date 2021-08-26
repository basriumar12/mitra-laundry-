package com.samyotech.laundrymitra.ui.activity.layanan;

import android.app.ProgressDialog;
import android.content.Context;
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
import com.samyotech.laundrymitra.databinding.ActivityAddDetailLayananItemBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.penjualan.ProdukPerwilayahDto;
import com.samyotech.laundrymitra.model.penjualan.StatusPenjualanDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ResponseOther;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.adapter.layanan.ProdukWilayahAdapter;
import com.samyotech.laundrymitra.ui.adapter.penjualan.StatusPenjualanAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailAddLayananItemActivity extends AppCompatActivity implements ProdukWilayahAdapter.OnItemClickListener {

    ActivityAddDetailLayananItemBinding binding;

    List<ProdukPerwilayahDto> data = new ArrayList<>();
    ProdukPerwilayahDto dataProdukSelected = new ProdukPerwilayahDto();
    Context mContext;
    LayananItemDto layananItemDto;

    UserDTO userDTO;
    private SharedPrefrence prefrence;

    BottomSheetDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_detail_layanan_item);
        mContext = DetailAddLayananItemActivity.this;

        prefrence = SharedPrefrence.getInstance(this);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        layananItemDto = getIntent().getParcelableExtra("LayananItem");
        getListProduk();
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String hargaProdukTambahan = binding.hargaProdukTambahan.getText().toString();

                if (hargaProdukTambahan.isEmpty() || hargaProdukTambahan.equals("")){
                    Toast.makeText(mContext, "harga tidak bisa kosong", Toast.LENGTH_SHORT).show();
                }else if (binding.hargaProduk.getText().toString().isEmpty()){
                    Toast.makeText(mContext, "belum memilih produk", Toast.LENGTH_SHORT).show();
                }
                else {
                    int hargaProdukValue = Integer.valueOf(hargaProdukTambahan);
                    int hargaProduk = Integer.valueOf(dataProdukSelected.getPrice());


                    if (hargaProdukValue < hargaProduk) {
                        Toast.makeText(mContext, "Harga tambahan produk tidak boleh kurang dari harga produk ", Toast.LENGTH_SHORT).show();
                    } else {
                        addHargaProduk();
                    }
                }

            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.namaProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listProduk();

            }
        });


    }

    private void getListProduk() {
        final ProgressDialog progressDialog = new ProgressDialog(DetailAddLayananItemActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        api.getProdukWilayah(userDTO.getUser_id()).enqueue(new Callback<BaseResponse<List<ProdukPerwilayahDto>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<ProdukPerwilayahDto>>> call, Response<BaseResponse<List<ProdukPerwilayahDto>>> response) {

                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {

                        data = response.body().getData();
                    } else {
                        binding.namaProduk.setText(response.body().getMessage());
                    }

                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<ProdukPerwilayahDto>>> call, Throwable t) {

                progressDialog.dismiss();
            }
        });

    }

    private void listProduk() {
        dialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.view_list_produk, null);
        Window window = dialog.getWindow();
        window.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(view);
        RecyclerView recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(linearLayoutManager);
        ProdukWilayahAdapter adapter = new ProdukWilayahAdapter(this, data, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dialog.show();

    }

    public void addHargaProduk() {
        final ProgressDialog progressDialog = new ProgressDialog(DetailAddLayananItemActivity.this, R.style.CustomAlertDialog);
        progressDialog.setMessage("loading");
        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("user_id", userDTO.getUser_id());
        body.put("kode_produk", dataProdukSelected.getItemId());
        body.put("price", binding.hargaProdukTambahan.getText().toString());
        api.postHargaItemLayanan(body).enqueue(new Callback<ResponseOther>() {
            @Override
            public void onResponse(Call<ResponseOther> call, Response<ResponseOther> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    if (response.body().isStatus()) {
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseOther> call, Throwable t) {
                Log.e("TAG", "gagal post produk " + t.getMessage());
                progressDialog.dismiss();
                Toast.makeText(mContext, "Gagal tambah harga, ada kesalahan akses ke server", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onItemClick(ProdukPerwilayahDto item) {
        dialog.dismiss();
        binding.namaProduk.setText(item.getItemName());
        binding.hargaProduk.setText(item.getPrice());
        dataProdukSelected = item;
    }
}