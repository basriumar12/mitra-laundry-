package com.samyotech.laundrymitra.model.oprational;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OprationalBody{

	@SerializedName("shop_id")
	private String shopId;

	@SerializedName("jam")
	private List<JamItemData> jam;

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public void setJam(List<JamItemData> jam) {
		this.jam = jam;
	}

	public String getShopId(){
		return shopId;
	}

	public List<JamItemData> getJam(){
		return jam;
	}
}