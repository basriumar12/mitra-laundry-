package com.samyotech.laundrymitra.model.ulasandata;

import com.google.gson.annotations.SerializedName;

public class RataRataUlasanDto{

	@SerializedName("1")
	private String jsonMember1;

	@SerializedName("2")
	private String jsonMember2;

	@SerializedName("3")
	private String jsonMember3;

	@SerializedName("4")
	private String jsonMember4;

	@SerializedName("5")
	private String jsonMember5;

	public String getJsonMember1(){
		return jsonMember1;
	}

	public String getJsonMember2(){
		return jsonMember2;
	}

	public String getJsonMember3(){
		return jsonMember3;
	}

	public String getJsonMember4(){
		return jsonMember4;
	}

	public String getJsonMember5(){
		return jsonMember5;
	}
}