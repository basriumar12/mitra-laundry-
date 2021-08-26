package com.samyotech.laundrymitra.model.base;

import com.google.gson.annotations.SerializedName;
import com.samyotech.laundrymitra.model.ulasandata.RataRataUlasanDto;

public class BaseResponse<T>{

	@SerializedName("data")
	private T data;

	@SerializedName("message")
	private String message;

	@SerializedName("total_rating")
	private String totalRating;

	@SerializedName("status")
	private boolean status;

	@SerializedName("rata_rata")
	private RataRataUlasanDto rataUlasanDto;

	public RataRataUlasanDto getRataUlasanDto() {
		return rataUlasanDto;
	}

	public void setRataUlasanDto(RataRataUlasanDto rataUlasanDto) {
		this.rataUlasanDto = rataUlasanDto;
	}

	public String getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(String totalRating) {
		this.totalRating = totalRating;
	}

	public void setData(T data){
		this.data = data;
	}

	public T getData(){
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