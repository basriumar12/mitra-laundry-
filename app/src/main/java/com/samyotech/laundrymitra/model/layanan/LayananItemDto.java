package com.samyotech.laundrymitra.model.layanan;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LayananItemDto implements Parcelable {

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

	private String count;


	protected LayananItemDto(Parcel in) {
		shopId = in.readString();
		image = in.readString();
		updatedAt = in.readString();
		itemId = in.readString();
		price = in.readString();
		serviceId = in.readString();
		sNo = in.readString();
		createdAt = in.readString();
		itemName = in.readString();
		type = in.readString();
		status = in.readString();
		urlImage = in.readString();
		count = in.readString();
	}

	public static final Creator<LayananItemDto> CREATOR = new Creator<LayananItemDto>() {
		@Override
		public LayananItemDto createFromParcel(Parcel in) {
			return new LayananItemDto(in);
		}

		@Override
		public LayananItemDto[] newArray(int size) {
			return new LayananItemDto[size];
		}
	};

	@Override
	public String toString() {
		return "LayananItemDto{" +
				"shopId='" + shopId + '\'' +
				", image='" + image + '\'' +
				", updatedAt='" + updatedAt + '\'' +
				", itemId='" + itemId + '\'' +
				", price='" + price + '\'' +
				", serviceId='" + serviceId + '\'' +
				", sNo='" + sNo + '\'' +
				", createdAt='" + createdAt + '\'' +
				", itemName='" + itemName + '\'' +
				", type='" + type + '\'' +
				", status='" + status + '\'' +
				", urlImage='" + urlImage + '\'' +
				", count='" + count + '\'' +
				'}';
	}

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



	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(shopId);
		parcel.writeString(image);
		parcel.writeString(updatedAt);
		parcel.writeString(itemId);
		parcel.writeString(price);
		parcel.writeString(serviceId);
		parcel.writeString(sNo);
		parcel.writeString(createdAt);
		parcel.writeString(itemName);
		parcel.writeString(type);
		parcel.writeString(status);
		parcel.writeString(urlImage);
		parcel.writeString(count);
	}
}