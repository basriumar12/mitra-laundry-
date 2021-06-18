package com.samyotech.laundrymitra.interfaces;

import org.json.JSONException;
import org.json.JSONObject;


public interface Helper {
    void backResponse(boolean flag, String msg, JSONObject response) throws JSONException;
}
