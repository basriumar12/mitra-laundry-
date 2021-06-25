package com.samyotech.laundrymitra.model.base;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T>{

	@SerializedName("data")
	private T data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

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