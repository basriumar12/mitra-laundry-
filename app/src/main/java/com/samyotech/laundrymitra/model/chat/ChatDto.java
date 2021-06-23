package com.samyotech.laundrymitra.model.chat;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ChatDto{

	@SerializedName("data")
	private List<ChatListDto> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public List<ChatListDto> getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}