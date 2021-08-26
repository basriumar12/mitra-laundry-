package com.samyotech.laundrymitra.network;


import com.samyotech.laundrymitra.model.chat.ChatDto;
import com.samyotech.laundrymitra.model.home.KhususUntukmuDto;
import com.samyotech.laundrymitra.model.home.PentingHariIniDto;
import com.samyotech.laundrymitra.model.home.TerlarisHariIniDto;
import com.samyotech.laundrymitra.model.base.BaseResponse;
import com.samyotech.laundrymitra.model.layanan.LayananItemDto;
import com.samyotech.laundrymitra.model.layanan.ServiceItemDto;
import com.samyotech.laundrymitra.model.oprational.JamItem;
import com.samyotech.laundrymitra.model.oprational.OprationalBody;
import com.samyotech.laundrymitra.model.penjualan.DetailPenjualanDto;
import com.samyotech.laundrymitra.model.penjualan.PenjualanItemDto;
import com.samyotech.laundrymitra.model.penjualan.ProdukPerwilayahDto;
import com.samyotech.laundrymitra.model.penjualan.UbahStatusDto;
import com.samyotech.laundrymitra.model.rekening.DaftarRekeningDto;
import com.samyotech.laundrymitra.model.ulasandata.UlasanNewDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
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

    @Multipart
    @POST("lainnya/edit_foto_profile")
    Call<ResponseOther> uploadFotoProfile(@Part("user_id") RequestBody user_id, @Part MultipartBody.Part file
    );

    @Multipart
    @POST("lainnya/edit_foto_outlet")
    Call<ResponseOther> uploadFotoOutlet(@Part("shop_id") RequestBody user_id, @Part MultipartBody.Part file
    );

    @Multipart
    @POST("chatt/kirim_pesan")
    Call<ResponseOther> sendMessage(
            @Part("user_id") RequestBody user_id,
            @Part("message_head") RequestBody messagehead,
            @Part("message") RequestBody message,
            @Part MultipartBody.Part media
    );

    @Multipart
    @POST("penjualan/chat")
    Call<ResponseOther> sendMessageToKonsumen(
            @Part("user_id") RequestBody user_id,
            @Part("to_user_id") RequestBody messagehead,
            @Part("message") RequestBody message,
            @Part MultipartBody.Part media
    );

    @Multipart
    @POST("lainnya/edit_foto_background")
    Call<ResponseOther> uploadFotoBackground(@Part("user_id") RequestBody user_id, @Part MultipartBody.Part file
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
    Call<BaseResponse<List<LayananItemDto>>> getLayanan(@Query("service_id") String service_id,@Query("user_id") String user_id);

   @GET("layanan/produk_wilayah")
    Call<BaseResponse<List<ProdukPerwilayahDto>>> getProdukWilayah(@Query("user_id") String userId);


    @GET("layanan/detail_layanan")
    Call<BaseResponse<ServiceItemDto>> getDetailLayanan(@Query("service_id") String service_id);

    @GET("lainnya/ulasan")
    Call<BaseResponse<List<UlasanNewDto>>> getUlasan(@Query("shop_id") String shopId);

    @GET("chatt")
    Call<ChatDto> getChat(@Query("user_id") String userId);


    @GET("layanan/update_status")
    Call<BaseResponse<ServiceItemDto>> getUpdateStatusLayanan(@Query("service_id") String service_id);

    @POST("layanan/update_layanan")
    Call<BaseResponse<ServiceItemDto>> postDataLayanan(@Body HashMap<String, String> body);

    @POST("layanan/edit_item")
    Call<BaseResponse<LayananItemDto>> postDataItemLayanan(@Body HashMap<String, String> body);

   @POST("layanan/add_item")
    Call<ResponseOther> postHargaItemLayanan(@Body HashMap<String, String> body);

    @POST("penjualan/tambah")
    Call<BaseResponse> postTambahPenjualan(@Body Map<String, String> body);


    @GET("home/terlaris")
    Call<TerlarisHariIniDto> getTerlaris(@Query("user_id") String user_id, @Query("shop_id") String shop_id);

    @GET("mul14/gudang-data/master/bank/bank.json")
    Call<List<DaftarRekeningDto>> getDatarekening();

    @GET("home/artikel")
    Call<KhususUntukmuDto> getArtikel(@Query("kategori") String kategori);

    @GET("home")
    Call<BaseResponse<PentingHariIniDto>> getPentingHariIni(@Query("id_user") String idUser);

    @GET("lainnya/jam_buka")
    Call<BaseResponse<List<JamItem>>> getJamOpertational(@Query("id_user") String idUser
            , @Query("shop_id") String shop_id);

    @POST("lainnya/update_jam")
    Call<ResponseOther> postJamOpertational(@Body OprationalBody body);

    @POST("penjualan/ubah_status_pesanan")
    Call<ResponseOther> postUbahStatus(@Body UbahStatusDto body);

    @POST("home/update_lokasi")
    Call<ResponseOther> updateLokasi(@Body UbahStatusDto body);


}