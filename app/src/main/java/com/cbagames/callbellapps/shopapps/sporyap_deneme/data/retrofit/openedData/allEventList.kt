package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.openedData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class allEventList (

        @SerializedName("id")
        @Expose
        var id:Int,

        @SerializedName("title")
        @Expose
        var title:String,

        @SerializedName("eventPhoto")
        @Expose
        var eventPhoto:String,

        @SerializedName("eventType")
        @Expose
        var eventType:String,

        @SerializedName("isPopuler")
        @Expose
        var isPopuler:Boolean,

        @SerializedName("isNew")
        @Expose
        var isNew:Boolean,

        @SerializedName("isMissingOnlyOne")
        @Expose
        var isMissingOnlyOne:Boolean,

        @SerializedName("isStartSoon")
        @Expose
        var isStartSoon:Boolean,

        @SerializedName("isRecommended")
        @Expose
        var isRecommended:Boolean,

        ){
}