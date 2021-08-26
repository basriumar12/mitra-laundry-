package com.samyotech.laundrymitra.model;

import java.io.Serializable;

public class ChatListDTO implements Serializable {


    String message_head_id = "";
    String updated_at = "";
    String pesan_terakhir = "";
    String customer_name = "";
    String user_id = "";
    String user_image = "";

    public String getMessage_head_id() {
        return message_head_id;
    }

    public void setMessage_head_id(String message_head_id) {
        this.message_head_id = message_head_id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPesan_terakhir() {
        return pesan_terakhir;
    }

    public void setPesan_terakhir(String pesan_terakhir) {
        this.pesan_terakhir = pesan_terakhir;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }
}
