package com.samyotech.laundrymitra.model.layanan;

import com.google.gson.annotations.SerializedName;

public class ItemLayananListDto {

	@SerializedName("shop_id")
	private String shopId;

	@SerializedName("image")
	private String image;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("item_id")
	private String itemId;

	@SerializedName("price")
	private String price;

	@SerializedName("service_id")
	private String serviceId;

	@SerializedName("s_no")
	private String sNo;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("item_name")
	private String itemName;

	@SerializedName("type")
	private String type;

	@SerializedName("status")
	private String status;

	@SerializedName("url_image")
	private String urlImage;

	public void setShopId(String shopId){
		this.shopId = shopId;
	}

	public String getShopId(){
		return shopId;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setItemId(String itemId){
		this.itemId = itemId;
	}

	public String getItemId(){
		return itemId;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setServiceId(String serviceId){
		this.serviceId = serviceId;
	}

	public String getServiceId(){
		return serviceId;
	}

	public void setSNo(String sNo){
		this.sNo = sNo;
	}

	public String getSNo(){
		return sNo;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getItemName(){
		return itemName;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setUrlImage(String urlImage){
		this.urlImage = urlImage;
	}

	public String getUrlImage(){
		return urlImage;
	}
}