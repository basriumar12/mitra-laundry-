package com.samyotech.laundrymitra.model.penjualan;

import com.google.gson.annotations.SerializedName;

public class UbahStatusDto{

	@SerializedName("order_status")
	private String orderStatus;

	@SerializedName("order_id")
	private String orderId;

	public String getOrderStatus(){
		return orderStatus;
	}

	public String getOrderId(){
		return orderId;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}