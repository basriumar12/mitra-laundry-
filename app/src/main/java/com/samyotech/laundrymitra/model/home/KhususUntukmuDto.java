package com.samyotech.laundrymitra.model.home;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class KhususUntukmuDto{

	@SerializedName("data")
	private List<KhususUntukmuListDto> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public List<KhususUntukmuListDto> getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}