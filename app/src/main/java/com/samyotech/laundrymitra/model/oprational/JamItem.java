package com.samyotech.laundrymitra.model.oprational;

import com.google.gson.annotations.SerializedName;

public class JamItem{

	@SerializedName("jam_buka")
	private String jamBuka;

	@SerializedName("jam_tutup")
	private String jamTutup;

	@SerializedName("id")
	private String id;

	@SerializedName("status")
	private String status;

	@SerializedName("hari")
	private String hari;

	@SerializedName("shop_id")
	private String shopId;

	public String getHari() {
		return hari;
	}

	public void setHari(String hari) {
		this.hari = hari;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getJamBuka(){
		return jamBuka;
	}

	public String getJamTutup(){
		return jamTutup;
	}

	public String getId(){
		return id;
	}

	public String getStatus(){
		return status;
	}

	public void setJamBuka(String jamBuka) {
		this.jamBuka = jamBuka;
	}

	public void setJamTutup(String jamTutup) {
		this.jamTutup = jamTutup;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}