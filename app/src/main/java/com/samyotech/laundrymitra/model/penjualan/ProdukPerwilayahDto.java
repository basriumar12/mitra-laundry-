package com.samyotech.laundrymitra.model.penjualan;

import com.google.gson.annotations.SerializedName;

public class ProdukPerwilayahDto{

	@SerializedName("item_id")
	private String itemId;

	@SerializedName("price")
	private String price;

	@SerializedName("regencies_id")
	private String regenciesId;

	@SerializedName("service_id")
	private String serviceId;

	@SerializedName("service_region_id")
	private String serviceRegionId;

	@SerializedName("item_name")
	private String itemName;

	@SerializedName("id")
	private String id;

	@SerializedName("price_list_id")
	private String priceListId;

	@SerializedName("type")
	private String type;

	@SerializedName("status")
	private String status;

	public String getItemId(){
		return itemId;
	}

	public String getPrice(){
		return price;
	}

	public String getRegenciesId(){
		return regenciesId;
	}

	public String getServiceId(){
		return serviceId;
	}

	public String getServiceRegionId(){
		return serviceRegionId;
	}

	public String getItemName(){
		return itemName;
	}

	public String getId(){
		return id;
	}

	public String getPriceListId(){
		return priceListId;
	}

	public String getType(){
		return type;
	}

	public String getStatus(){
		return status;
	}
}