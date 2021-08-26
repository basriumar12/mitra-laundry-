package com.samyotech.laundrymitra.model.oprational;

import com.google.gson.annotations.SerializedName;

public class JamItemData {

	@SerializedName("jam_buka")
	private String jamBuka;

	@SerializedName("jam_tutup")
	private String jamTutup;

	@SerializedName("id")
	private String id;

	@SerializedName("status")
	private String status;



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