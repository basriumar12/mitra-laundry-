package com.samyotech.laundrymitra.model.home;

import com.google.gson.annotations.SerializedName;

public class PentingHariIniDto{


	@SerializedName("pesanan_komplain")
	private int pesananKomplain;

	@SerializedName("pesanan_baru")
	private int pesananBaru;

	@SerializedName("ulasan_selesai")
	private int ulasanSelesai;

	@SerializedName("chat_belum_dibaca")
	private int chatBelumDibaca;

	@SerializedName("pesanan_selesai")
	private int pesananSelesai;

	@SerializedName("pendapatan_bersih_baru")
	private String pendapatan_bersih_baru ="Rp. 0";

	public int getPesananKomplain(){
		return pesananKomplain;
	}

	public int getPesananBaru(){
		return pesananBaru;
	}

	public int getUlasanSelesai(){
		return ulasanSelesai;
	}

	public int getChatBelumDibaca(){
		return chatBelumDibaca;
	}

	public int getPesananSelesai(){
		return pesananSelesai;
	}

	public String getPendapatan_bersih_baru(){
		return pendapatan_bersih_baru;
	}
}
