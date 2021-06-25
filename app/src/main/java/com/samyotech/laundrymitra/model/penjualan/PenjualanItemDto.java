package com.samyotech.laundrymitra.model.penjualan;

import com.google.gson.annotations.SerializedName;

public class PenjualanItemDto {

	@SerializedName("total_pcs")
	private int totalPcs;

	@SerializedName("total_harga")
	private String totalHarga;

	@SerializedName("order_id")
	private String orderId;

	@SerializedName("nama_service")
	private String namaService;

	public void setTotalPcs(int totalPcs){
		this.totalPcs = totalPcs;
	}

	public int getTotalPcs(){
		return totalPcs;
	}

	public void setTotalHarga(String totalHarga){
		this.totalHarga = totalHarga;
	}

	public String getTotalHarga(){
		return totalHarga;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public String getOrderId(){
		return orderId;
	}

	public void setNamaService(String namaService){
		this.namaService = namaService;
	}

	public String getNamaService(){
		return namaService;
	}
}