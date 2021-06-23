package com.samyotech.laundrymitra.model.penjualan;

import com.google.gson.annotations.SerializedName;

public class PenjualanDetailDto{

	@SerializedName("data")
	private DetailPenjualan detailPenjualan;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setDetailPenjualan(DetailPenjualan detailPenjualan){
		this.detailPenjualan = detailPenjualan;
	}

	public DetailPenjualan getDetailPenjualan(){
		return detailPenjualan;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}