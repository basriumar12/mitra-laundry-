package com.samyotech.laundrymitra.model.home;

import com.google.gson.annotations.SerializedName;
import com.samyotech.laundrymitra.model.OrderListDTO;

import java.io.Serializable;
import java.util.ArrayList;

public class TerlarisHariIniDto implements Serializable {

	ArrayList<TerlarisHariIniListDto> order_list = new ArrayList<>();

	public ArrayList<TerlarisHariIniListDto> getOrder_list() {
		return order_list;
	}

	public void setOrder_list(ArrayList<TerlarisHariIniListDto> order_list) {
		this.order_list = order_list;
	}
}
