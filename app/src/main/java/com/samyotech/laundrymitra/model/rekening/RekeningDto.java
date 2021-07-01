package com.samyotech.laundrymitra.model.rekening;

import com.google.gson.annotations.SerializedName;

public class RekeningDto{

	@SerializedName("number_bank")
	private String numberBank;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("account_name")
	private String accountName;

	@SerializedName("bank_name")
	private String bankName;

	@SerializedName("nama_usaha")
	private Object namaUsaha;

	@SerializedName("id")
	private String id;

	@SerializedName("logo_usaha")
	private Object logoUsaha;

	public String getNumberBank(){
		return numberBank;
	}

	public String getUserId(){
		return userId;
	}

	public String getAccountName(){
		return accountName;
	}

	public String getBankName(){
		return bankName;
	}

	public Object getNamaUsaha(){
		return namaUsaha;
	}

	public String getId(){
		return id;
	}

	public Object getLogoUsaha(){
		return logoUsaha;
	}
}