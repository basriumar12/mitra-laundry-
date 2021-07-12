package com.samyotech.laundrymitra.model.ulasandata;

import com.google.gson.annotations.SerializedName;

public class UlasanNewDto{

	@SerializedName("service_id")
	private String serviceId;

	@SerializedName("rating")
	private String rating;

	@SerializedName("image")
	private String image;

	@SerializedName("nama_layanan")
	private String namaLayanan;

	public String getServiceId(){
		return serviceId;
	}

	public String getRating(){
		return rating;
	}

	public String getNamaLayanan(){
		return namaLayanan;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}