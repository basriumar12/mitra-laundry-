package com.samyotech.laundrymitra.ui.activity.register;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.samyotech.laundrymitra.R;
import com.samyotech.laundrymitra.databinding.ActivityUploadKtpBinding;
import com.samyotech.laundrymitra.interfaces.Consts;
import com.samyotech.laundrymitra.model.UserDTO;
import com.samyotech.laundrymitra.network.ApiInterface;
import com.samyotech.laundrymitra.network.ResponseOther;
import com.samyotech.laundrymitra.network.ServiceGenerator;
import com.samyotech.laundrymitra.preferences.SharedPrefrence;
import com.samyotech.laundrymitra.utils.ProjectUtils;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;


public class UploadKtpActivity extends AppCompatActivity {
    Context mContext;
    ActivityUploadKtpBinding binding;
    private SharedPrefrence prefrence;
    HashMap<String, File> fileHashMap = new HashMap<>();
    HashMap<String, String> hashMap = new HashMap<>();
    UserDTO userDTO;
    File fileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        mContext = UploadKtpActivity.this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_upload_ktp);
        prefrence = SharedPrefrence.getInstance(this);

        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        hashMap.put(Consts.USER_ID, userDTO.getUser_id());


        uploadKtp();
    }

    private void uploadKtp() {


        binding.tvCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(UploadKtpActivity.this)
                        .cameraOnly()
                        .crop()
                        .compress(512)
                        .start();
            }
        });

        binding.tvGalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(UploadKtpActivity.this)
                        .galleryOnly()
                        .crop()
                        .compress(512)
                        .start();
            }
        });
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(UploadKtpActivity.this, R.style.CustomAlertDialog);
                progressDialog.setMessage("loading");
                progressDialog.show();

                ApiInterface api = ServiceGenerator.createService(
                        ApiInterface.class,
                        Consts.username,
                        Consts.pass
                );

                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file",
                        fileImage.getName(), RequestBody.create(MediaType.parse("image/*"), fileImage));


                RequestBody name = RequestBody.create(MediaType.parse("text/plain"),
                        userDTO.getUser_id());
                api.uploadKtp(name, filePart).enqueue(new Callback<ResponseOther>() {
                    @Override
                    public void onResponse(Call<ResponseOther> call, retrofit2.Response<ResponseOther> response) {

                        progressDialog.dismiss();
                        if (response.isSuccessful()) {
                            if (response.body().isStatus()) {
                                ProjectUtils.showToast(mContext, "Berhasil Upload");
                                prefrence.setIntValue("DAFTAR-", 2);
                                Intent in = new Intent(mContext, RegisterMitraActivity.class);
                                startActivity(in);
                                overridePendingTransition(R.anim.anim_slide_in_left,
                                        R.anim.anim_slide_out_left);
                            } else {
                                ProjectUtils.showToast(mContext, "Gagal Upload, pilih foto yang lain");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseOther> call, Throwable t) {
                        Log.e("TAG", "gagal upload " + t.getMessage());
                        progressDialog.dismiss();
                        ProjectUtils.showToast(mContext, "Gagal Upload, pilih foto yang lain");
                    }
                });

//                new HttpsRequest(Consts.UPLOAD_KTP, hashMap, fileHashMap, UploadKtpActivity.this)
//                        .imagePost("TAG", new Helper() {
//                            @Override
//                            public void backResponse(boolean flag, String msg, JSONObject response) throws JSONException {
//
//                                Log.e("TAG","berhasil "+msg);
//                                progressDialog.dismiss();
//                                if (flag) {
//                                    prefrence.setIntValue("DAFTAR-",2);
//
//                                    Glide.with(UploadKtpActivity.this)
//                                            .load(Consts.BASE_URL + "assets/images/user/")
//                                            .error(R.drawable.ic_avatar)
//                                            .diskCacheStrategy(DiskCacheStrategy.ALL)
//                                            .into(binding.imgKtp);
//                                    Intent in = new Intent(mContext, RegisterMitraActivity.class);
//                                    startActivity(in);
//
//                                } else {
//                                    ProjectUtils.showToast(UploadKtpActivity.this, msg);
//                                }
//                            }
//                        });
//
//
//
//                OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                        .authenticator(new Authenticator() {
//                            @Override
//                            public Request authenticate(Route route, Response response) throws IOException {
//                                return response.request().newBuilder()
//                                        .header("Authorization", Credentials.basic(Consts.username, Consts.pass))
//                                        .build();
//                            }
//                        })
//                        .build();
//                ANRequest request = AndroidNetworking.upload(Consts.API_URL + Consts.UPLOAD_KTP)
//                        .setOkHttpClient(okHttpClient)
//                        .addMultipartFile("file", fileImage)
//                        .addMultipartParameter("user_id",userDTO.getUser_id())
//                        .setTag("uploadTest")
//                        .setPriority(Priority.HIGH)
//                        .setExecutor(Executors.newSingleThreadExecutor())
//                        .build()
//                        .setUploadProgressListener(new UploadProgressListener() {
//                            @Override
//                            public void onProgress(long bytesUploaded, long totalBytes) {
//                                ProjectUtils.showLog("Byte", bytesUploaded + "  !!! " + totalBytes);
//                            }
//                        });
//
//                ProjectUtils.showLog("TAG", " url uploadt --->" + request.getUrl() +" - "+fileHashMap +" - "+hashMap);
//
//                request.getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                      Log.e("TAG","response good"+new Gson().toJson(response));
//
//
//
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//
//                        ProjectUtils.pauseProgressDialog();
//                        ProjectUtils.showLog("TAG", " good error body --->" + anError.getErrorBody() + " error msg --->" + anError.getMessage() +"Error code " +anError.getErrorCode()+" error detail" +anError.getErrorDetail());
//                    }
//                });
//


            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            File file = ImagePicker.Companion.getFile(data);
            fileImage = ImagePicker.Companion.getFile(data);
            fileHashMap.put(Consts.FILE, file);
            hashMap.put(Consts.FILE, file.getPath());

            Glide.with(UploadKtpActivity.this)
                    .load(file.getPath())
                    .error(R.drawable.ic_avatar)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.imgKtp);

        }
    }
}