package com.samyotech.laundrymitra.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable



data class BaseResponseNew<T> (
    var message: String? = null,
    var status: Boolean?  = null,
    val data: T? = null,
    val danaTotal : String? =null

)

data class ResponseOther (
    var message: String? = null,
    var status: Boolean?  = null

)

open class BaseResponse(val message: String? = null)
