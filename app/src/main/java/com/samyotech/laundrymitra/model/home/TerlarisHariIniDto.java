package com.samyotech.laundrymitra.model.home;

import com.google.gson.annotations.SerializedName;
import com.samyotech.laundrymitra.model.OrderListDTO;
import com.samyotech.laundrymitra.model.layanan.ItemLayananListDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TerlarisHariIniDto implements Serializable {

	@SerializedName("data")
	private List<TerlarisHariIniListDto> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public List<TerlarisHariIniListDto> getData() {
		return data;
	}

	public void setData(List<TerlarisHariIniListDto> data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
