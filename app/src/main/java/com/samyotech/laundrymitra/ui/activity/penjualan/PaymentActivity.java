package com.samyotech.laundrymitra.ui.activity.penjualan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.samyotech.laundrymitra.GlobalState;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityBookingPaymentBinding;
import com.samyotech.laundrymitra.databinding.ActivityPaymentBinding;
import com.samyotech.laundrymitra.https.HttpsRequest;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.interfaces.Helper;
import com.samyotech.laundrymitra.model.CurrencyDTO;
import com.samyotech.laundrymitra.model.ItemDTO;
import com.samyotech.laundrymitra.model.PopLaundryDTO;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.ui.activity.BookingConfirmActivity;
import com.samyotech.laundrymitra.ui.activity.BookingPaymentActivity;
import com.samyotech.laundrymitra.ui.activity.PreviewOrderActivity;
import com.samyotech.laundrymitra.ui.activity.layanan.EditServiceActivity;
import com.samyotech.laundrymitra.utils.AppFormat;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityPaymentBinding binding;
    Context mContext;
    UserDTO userDTO;
    JSONArray jsonArray = new JSONArray();
    String TAG = PreviewOrderActivity.class.getSimpleName();
    String totalPrice = "0", totalPriceBef = "0", promoCode = "", latitude = "", longitude = "", discounted_price = "0", discounted_value = "0";
    String otpGenrate = "";
    float discountValue = 0;
    HashMap<String, String> parms = new HashMap<>();
    HashMap<String, String> parmsSubmit = new HashMap<>();
    boolean checkCoup = true;
    int k = 0;
    CurrencyDTO currencyDTO;
    private SharedPrefrence prefrence;
    ArrayList<LayananItemDto> layananItemDtos;
    ServiceItemDto serviceItemDto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payment);
        mContext = PaymentActivity.this;

        parmsSubmit = (HashMap<String, String>) getIntent().getSerializableExtra("map");
        layananItemDtos = getIntent().getParcelableArrayListExtra("LayananData");
        serviceItemDto = getIntent().getParcelableExtra("ServiceData");
        totalPrice = getIntent().getStringExtra(Consts.TOTAL_PRICE);
        System.out.println(totalPrice);
        prefrence = SharedPrefrence.getInstance(mContext);
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        currencyDTO = prefrence.getCurrency(Consts.CURRENCYDTO);

        setUiAction();
    }


    private void setUiAction() {
        binding.total.setText("Rp. " + totalPrice);
        binding.subtotal.setText("Rp. " + totalPrice);
//        if (!globalState.getCost().equals("") && !globalState.getCostbefo().equals("")) {
//            binding.total.setText(prefrence.getCurrency() + " " + AppFormat.addDelimiter(((int) Double.parseDouble(globalState.getCost())) + ""));
//            binding.subtotal.setText(prefrence.getCurrency() + " " + AppFormat.addDelimiter(((int) Double.parseDouble(globalState.getCostbefo())) + ""));
//        } else {
//            if (globalState.getCost().equals("")) {
//                binding.total.setText(prefrence.getCurrency() + " " + AppFormat.addDelimiter((0 + "")));
//            } else {
//                binding.subtotal.setText(prefrence.getCurrency() + " " + AppFormat.addDelimiter((0 + "")));
//            }
//        }
//
//        totalPriceBef = globalState.getCostbefo();
//        totalPrice = globalState.getCost();
//        promoCode = globalState.getPromoCode();
//
//        if (globalState.getDiscountcost().equals("")) {
//            discountValue = 0F;
//        } else {
//            discountValue = Float.parseFloat(globalState.getDiscountcost());
//        }
//        if (discountValue == 0) {
//            binding.promoBtn.setOnClickListener(this);
//        } else {
//            binding.discount.setText(globalState.getDiscountcost());
//            discounted_value = globalState.getDiscountcost();
//        }
//        Log.e(TAG, "setUiAction: " + discountValue);
//
        binding.confirmPayment.setOnClickListener(this);


    }


    private void addPromocode() {

        parms.put(Consts.TOTAL_PRICE, totalPrice);
        parms.put(Consts.SHOP_ID, layananItemDtos.get(0).getShopId());
        parms.put(Consts.PROMOCODE, ProjectUtils.getEditTextValue(binding.kodePromo));
        new HttpsRequest(Consts.APPLYPROMOCODE, parms, mContext).stringPost(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) throws JSONException {
                if (flag) {
                    discounted_price = (response.getString("data"));
                    Log.e(TAG, "backResponse: " + discounted_price);
                    discounted_value = String.valueOf(Float.valueOf(discounted_price) - Float.valueOf(totalPrice));
                    checkCoup = false;

                    binding.kodePromo.setFocusable(false);

                    binding.discount.setText("Rp. " + discounted_value);
                    binding.total.setText(" " + discounted_price);
                    totalPrice = discounted_price;
                } else {

                    ProjectUtils.showToast(mContext, msg);
                }

            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.promo_btn:
                if (checkCoup) {
                    addPromocode();
                } else {
                    binding.kodePromo.setText("");
//                    totalPriceBef = globalState.getCostbefo();
//                    totalPrice = globalState.getCost();

                    binding.kodePromo.setFocusableInTouchMode(true);
                    binding.discount.setText("Rp. 0");
                    binding.total.setText("Rp. " + totalPrice);
                    checkCoup = true;

                }

                break;
            case R.id.confirm_payment:
                setData();
                System.out.println("KEPANGGIL");
                break;
        }
    }

    private void setData() {
        Random otp1 = new Random();
        StringBuilder builder = new StringBuilder();
        for (int count = 0; count <= 9; count++) {
            builder.append(otp1.nextInt(10));
        }
        otpGenrate = builder.toString();

        for (int j = 0; j < layananItemDtos.size(); j++) {

            JSONObject jsonObject = new JSONObject();
            int count = Integer.parseInt(layananItemDtos.get(j).getCount());
            if (count > 0) {
                try {
                    jsonObject.putOpt(Consts.ITEM_ID, layananItemDtos.get(j).getItemId());
                    jsonObject.putOpt(Consts.ITEM_NAME, layananItemDtos.get(j).getItemName());
                    jsonObject.putOpt(Consts.PRICE, layananItemDtos.get(j).getPrice());
                    jsonObject.putOpt(Consts.IMAGE, layananItemDtos.get(j).getImage());
                    jsonObject.putOpt(Consts.QUANTITY, layananItemDtos.get(j).getCount());
                    jsonObject.putOpt(Consts.S_NO, layananItemDtos.get(j).getSNo());
                    jsonObject.putOpt(Consts.STATUS, layananItemDtos.get(j).getStatus());
                    jsonObject.putOpt(Consts.CREATED_AT, layananItemDtos.get(j).getCreatedAt());
                    jsonObject.putOpt(Consts.UPDATED_AT, layananItemDtos.get(j).getUpdatedAt());
                    jsonObject.putOpt(Consts.SERVICE_NAME, serviceItemDto.getServiceName());

                    jsonArray.put(k, jsonObject);
                    k++;
                /*        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                            }
                        }, 200);
*/

                } catch (Exception e) {
                    System.out.println("ADD ITEM "+e);
                }
            }
        }

        confirmorder();


    }


    private void confirmorder() {
//        JSONObject json = new JSONObject();

        parmsSubmit.put(Consts.ORDER_ID, String.valueOf(otpGenrate));//
        parmsSubmit.put(Consts.USER_ID, userDTO.getUser_id());//
        try {
            parmsSubmit.put(Consts.SHOP_ID, serviceItemDto.getShopId());//
        } catch (Exception ex) {
            parmsSubmit.put(Consts.SHOP_ID, "YZ65d0");//
            System.out.println("CASH " + ex);
        }

        parmsSubmit.put(Consts.PRICE, totalPrice);////
        parmsSubmit.put(Consts.DISCOUNT, discounted_value);////
        parmsSubmit.put(Consts.FINAL_PRICE, totalPrice);////
        parmsSubmit.put(Consts.CURRENCY_CODE, "Rp");//
        parmsSubmit.put(Consts.ITEM_DETAILS, String.valueOf(jsonArray));
//        globalState.setCost(binding.total.getText().toString().trim());

//        System.out.println(parmsSubmit);
//        HashMap<String, Object> body = new HashMap<String, Object>();
//        body.put(Consts.ORDER_ID,otpGenrate);
//        body.put(Consts.USER_ID,userDTO.getUser_id());
//        try {
//            body.put(Consts.SHOP_ID, serviceItemDto.getShopId());//
//        } catch (Exception ex) {
//            body.put(Consts.SHOP_ID, "YZ65d0");//
//        }
//        body.put(Consts.PRICE, totalPrice);////
//        body.put(Consts.DISCOUNT, discounted_value);////
//        body.put(Consts.FINAL_PRICE, totalPrice);////
//        body.put(Consts.CURRENCY_CODE, "Rp");//
//        body.put(Consts.ITEM_DETAILS, String.valueOf(jsonArray));
        System.out.println("BODY : "+ new Gson().toJson(parmsSubmit));

//        final ProgressDialog progressDialog = new ProgressDialog(PaymentActivity.this, R.style.CustomAlertDialog);
//        progressDialog.setMessage("loading");
//        progressDialog.show();

        ApiInterface api = ServiceGenerator.createService(
                ApiInterface.class,
                Consts.username,
                Consts.pass
        );

        api.postTambahPenjualan(parmsSubmit).enqueue(new Callback<BaseResponse>() {

            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        System.out.println(response.body().getMessage());
                        Intent in = new Intent(mContext, SuccessPenjualanActivity.class);
                        startActivity(in);
                        finish();
                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.e("TAG", "gagal upload " + t.getMessage());
            }
        });
//        new HttpsRequest(Consts.ORDERSUBMIT, parmsSubmit, mContext).stringPost(TAG, new Helper() {
//            @Override
//            public void backResponse(boolean flag, String msg, JSONObject response) throws JSONException {
//                if (flag) {
//
//                    Intent in = new Intent(mContext, BookingConfirmActivity.class);
//                    in.putExtra("map", parmsSubmit);
//                    startActivity(in);
//                    finish();
//                } else {
//                    ProjectUtils.showToast(mContext, msg);
//                }
//            }
//        });
    }
}