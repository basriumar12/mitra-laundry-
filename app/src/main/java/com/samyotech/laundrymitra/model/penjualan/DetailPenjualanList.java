package com.samyotech.laundrymitra.model.penjualan;

import com.google.gson.annotations.SerializedName;

public class DetailPenjualanList {

	@SerializedName("image")
	private String image;

	@SerializedName("quantity")
	private String quantity;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("item_id")
	private String itemId;

	@SerializedName("price")
	private String price;

	@SerializedName("service_name")
	private String serviceName;

	@SerializedName("s_no")
	private String sNo;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("item_name")
	private String itemName;

	@SerializedName("status")
	private String status;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setQuantity(String quantity){
		this.quantity = quantity;
	}

	public String getQuantity(){
		return quantity;
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

	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}

	public String getServiceName(){
		return serviceName;
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

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}