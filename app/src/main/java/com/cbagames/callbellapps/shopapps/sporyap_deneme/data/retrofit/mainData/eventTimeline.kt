package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.mainData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class eventTimeline (

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
    var result: List<result>,
        ) {
}