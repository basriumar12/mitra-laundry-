package com.samyotech.laundrymitra.model.chat;

import com.google.gson.annotations.SerializedName;

public class ChatListDto {

	@SerializedName("message_head_id")
	private String messageHeadId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("to_user_id")
	private String toUserId;

	@SerializedName("jam_pesan")
	private String jamPesan;

	@SerializedName("customer_name")
	private String customerName;

	@SerializedName("pesan_terakhir")
	private String pesanTerakhir;

	@SerializedName("from_user_id")
	private String fromUserId;

	public String getMessageHeadId(){
		return messageHeadId;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getToUserId(){
		return toUserId;
	}

	public String getJamPesan(){
		return jamPesan;
	}

	public String getCustomerName(){
		return customerName;
	}

	public String getPesanTerakhir(){
		return pesanTerakhir;
	}

	public String getFromUserId(){
		return fromUserId;
	}
}