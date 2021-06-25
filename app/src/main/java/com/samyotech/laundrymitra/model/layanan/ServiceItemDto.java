package com.samyotech.laundrymitra.model.layanan;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ServiceItemDto implements Parcelable {

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

	protected ServiceItemDto(Parcel in) {
		shopId = in.readString();
		image = in.readString();
		updatedAt = in.readString();
		serviceName = in.readString();
		serviceId = in.readString();
		sNo = in.readString();
		description = in.readString();
		createdAt = in.readString();
		status = in.readString();
		urlImage = in.readString();
	}

	public static final Creator<ServiceItemDto> CREATOR = new Creator<ServiceItemDto>() {
		@Override
		public ServiceItemDto createFromParcel(Parcel in) {
			return new ServiceItemDto(in);
		}

		@Override
		public ServiceItemDto[] newArray(int size) {
			return new ServiceItemDto[size];
		}
	};

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

	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}

	public String getServiceName(){
		return serviceName;
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

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
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
		parcel.writeString(serviceName);
		parcel.writeString(serviceId);
		parcel.writeString(sNo);
		parcel.writeString(description);
		parcel.writeString(createdAt);
		parcel.writeString(status);
		parcel.writeString(urlImage);
	}
}