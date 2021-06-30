package com.samyotech.laundrymitra.model.home;

import com.google.gson.annotations.SerializedName;

public class KhususUntukmuListDto {

	@SerializedName("image")
	private String image;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("url_image")
	private String urlImage;

	public String getImage(){
		return image;
	}

	public String getDescription(){
		return description;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getUrlImage(){
		return urlImage;
	}
}