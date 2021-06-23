package com.samyotech.laundrymitra.model.penjualan;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DetailPenjualan {

	@SerializedName("payment_status")
	private String paymentStatus;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("discount")
	private String discount;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("delivery_time")
	private String deliveryTime;

	@SerializedName("currency_code")
	private String currencyCode;

	@SerializedName("shop_id")
	private String shopId;

	@SerializedName("order_status")
	private String orderStatus;

	@SerializedName("pickup_date")
	private String pickupDate;

	@SerializedName("delivery_date")
	private String deliveryDate;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("final_price")
	private String finalPrice;

	@SerializedName("item_details")
	private List<DetailPenjualanList> itemDetails;

	@SerializedName("price")
	private String price;

	@SerializedName("s_no")
	private String sNo;

	@SerializedName("shipping_address")
	private String shippingAddress;

	@SerializedName("pickup_time")
	private String pickupTime;

	@SerializedName("landmark")
	private String landmark;

	@SerializedName("order_id")
	private String orderId;

	@SerializedName("longitude")
	private String longitude;

	@SerializedName("status")
	private String status;

	public void setPaymentStatus(String paymentStatus){
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentStatus(){
		return paymentStatus;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setDiscount(String discount){
		this.discount = discount;
	}

	public String getDiscount(){
		return discount;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setDeliveryTime(String deliveryTime){
		this.deliveryTime = deliveryTime;
	}

	public String getDeliveryTime(){
		return deliveryTime;
	}

	public void setCurrencyCode(String currencyCode){
		this.currencyCode = currencyCode;
	}

	public String getCurrencyCode(){
		return currencyCode;
	}

	public void setShopId(String shopId){
		this.shopId = shopId;
	}

	public String getShopId(){
		return shopId;
	}

	public void setOrderStatus(String orderStatus){
		this.orderStatus = orderStatus;
	}

	public String getOrderStatus(){
		return orderStatus;
	}

	public void setPickupDate(String pickupDate){
		this.pickupDate = pickupDate;
	}

	public String getPickupDate(){
		return pickupDate;
	}

	public void setDeliveryDate(String deliveryDate){
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryDate(){
		return deliveryDate;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setFinalPrice(String finalPrice){
		this.finalPrice = finalPrice;
	}

	public String getFinalPrice(){
		return finalPrice;
	}

	public void setItemDetails(List<DetailPenjualanList> itemDetails){
		this.itemDetails = itemDetails;
	}

	public List<DetailPenjualanList> getItemDetails(){
		return itemDetails;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setSNo(String sNo){
		this.sNo = sNo;
	}

	public String getSNo(){
		return sNo;
	}

	public void setShippingAddress(String shippingAddress){
		this.shippingAddress = shippingAddress;
	}

	public String getShippingAddress(){
		return shippingAddress;
	}

	public void setPickupTime(String pickupTime){
		this.pickupTime = pickupTime;
	}

	public String getPickupTime(){
		return pickupTime;
	}

	public void setLandmark(String landmark){
		this.landmark = landmark;
	}

	public String getLandmark(){
		return landmark;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public String getOrderId(){
		return orderId;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}