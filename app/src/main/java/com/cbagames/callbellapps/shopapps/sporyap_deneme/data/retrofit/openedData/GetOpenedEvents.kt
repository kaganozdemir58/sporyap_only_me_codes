package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.openedData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetOpenedEvents (

    @SerializedName("success")
    @Expose
    var success:Boolean,

    @SerializedName("message")
    @Expose
    var message:String,

    @SerializedName("errors")
    @Expose
    var errors:List<String>,

    @SerializedName("result")
    @Expose
    var result: result,
        ) {
}