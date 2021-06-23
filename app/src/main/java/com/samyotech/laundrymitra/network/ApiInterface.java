package com.samyotech.laundrymitra.network;


import com.samyotech.laundrymitra.model.chat.ChatDto;
import com.samyotech.laundrymitra.model.home.KhususUntukmuDto;
import com.samyotech.laundrymitra.model.home.TerlarisHariIniDto;
import com.samyotech.laundrymitra.model.layanan.ItemLayananDto;
import com.samyotech.laundrymitra.model.layanan.LayananDto;
import com.samyotech.laundrymitra.model.penjualan.PenjualanDetailDto;
import com.samyotech.laundrymitra.model.penjualan.PenjualanListDto;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
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
    Call<PenjualanListDto> getPenjualanData(@Query("shop_id") String shop_id);

    @GET("penjualan/batal")
    Call<PenjualanListDto> getBatalPenjualan(@Query("order_id") String order_id);

    @GET("penjualan/selengkapnya")
    Call<PenjualanDetailDto> getDetailPenjualan(@Query("order_id") String order_id);

    @GET("layanan")
    Call<LayananDto> getListLayanan(@Query("user_id") String user_id, @Query("shop_id") String shop_id);

    @GET("layanan/item_layanan")
    Call<ItemLayananDto> getLayanan(@Query("service_id") String service_id);

    @GET("chatt")
    Call<ChatDto> getChat(@Query("user_id") String userId);

    @GET("home/terlaris")
    Call<TerlarisHariIniDto> getTerlaris(@Query("user_id") String user_id, @Query("shop_id") String shop_id);

    @GET("home/artikel")
    Call<KhususUntukmuDto> getArtikel();


}