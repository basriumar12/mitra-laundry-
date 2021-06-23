package com.samyotech.laundrymitra.model.penjualan;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PenjualanListDto{

	@SerializedName("data")
	private List<DataItemPenjulan> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(List<DataItemPenjulan> data){
		this.data = data;
	}

	public List<DataItemPenjulan> getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}