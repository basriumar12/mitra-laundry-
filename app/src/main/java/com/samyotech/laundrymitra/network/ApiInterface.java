package com.samyotech.laundrymitra.network;


import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {


    @Multipart
    @POST("register/foto_ktp")
    Call<ResponseOther> uploadKtp(@Part("user_id") RequestBody user_id, @Part MultipartBody.Part file
    );


}