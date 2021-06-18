package com.samyotech.laundrymitra.model.home;

public class PentingHariIniDto{
	private int pesananKomplain;
	private int pesananBaru;
	private int ulasanSelesai;
	private int chatBelumDibaca;
	private int pesananSelesai;
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
