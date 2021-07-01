package com.samyotech.laundrymitra.network;


import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanDto;
import com.samyotech.laundrymitra.model.penjualan.PenjualanItemDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {


    @Multipart
    @POST("register/foto_ktp")
    Call<ResponseOther> uploadKtp(@Part("user_id") RequestBody user_id, @Part MultipartBody.Part file
    );

    @GET("penjualan")
    Call<BaseResponse<List<PenjualanItemDto>>> getPenjualanData(@Query("shop_id") String shop_id);

    @GET("penjualan/batal")
    Call<BaseResponse<List<PenjualanItemDto>>> getBatalPenjualan(@Query("order_id") String order_id);

    @GET("penjualan/selengkapnya")
    Call<BaseResponse<DetailPenjualanDto>> getDetailPenjualan(@Query("order_id") String order_id);

    @GET("layanan")
    Call<BaseResponse<List<ServiceItemDto>>> getListLayanan(@Query("user_id") String user_id, @Query("shop_id") String shop_id);

    @GET("layanan/item_layanan")
    Call<BaseResponse<List<LayananItemDto>>> getLayanan(@Query("service_id") String service_id);

    @GET("layanan/detail_layanan")
    Call<BaseResponse<ServiceItemDto>> getDetailLayanan(@Query("service_id") String service_id);

    @POST("layanan/update_layanan")
    Call<BaseResponse<ServiceItemDto>> postDataLayanan(@Body HashMap<String, String> body);

    @POST("layanan/edit_item")
    Call<BaseResponse<LayananItemDto>> postDataItemLayanan(@Body HashMap<String, String> body);

    @POST("penjualan/tambah")
    Call<BaseResponse> postTambahPenjualan(@Body Map<String, String> body);

}