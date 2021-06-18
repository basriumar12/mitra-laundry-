package com.samyotech.laundrymitra.model.home;

import com.google.gson.annotations.SerializedName;

public class TerlarisHariIniListDto {

	@SerializedName("shop_id")
	private String shopId;

	@SerializedName("image")
	private String image;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("service_name")
	private String serviceName;

	@SerializedName("service_id")
	private String serviceId;

	@SerializedName("s_no")
	private String sNo;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("status")
	private String status;

	@SerializedName("url_image")
	private String urlImage;

	public String getShopId(){
		return shopId;
	}

	public String getImage(){
		return image;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getServiceName(){
		return serviceName;
	}

	public String getServiceId(){
		return serviceId;
	}

	public String getSNo(){
		return sNo;
	}

	public String getDescription(){
		return description;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getStatus(){
		return status;
	}

	public String getUrlImage(){
		return urlImage;
	}
}