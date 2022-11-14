package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.mainData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class result (

    @SerializedName("id")
    @Expose
    var id:Int,

    @SerializedName("profileImage")
    @Expose
    var profileImage:String,

    @SerializedName("coverMediaUrl")
    @Expose
    var coverMediaUrl:String,

    @SerializedName("mediaType")
    @Expose
    var mediaType:String,

    @SerializedName("eventName")
    @Expose
    var eventName:String,

    @SerializedName("totalMemberCount")
    @Expose
    var totalMemberCount:Int,

    @SerializedName("rating")
    @Expose
    var rating:Int,

    @SerializedName("sportName")
    @Expose
    var sportName:String,

    @SerializedName("eventTypeName")
    @Expose
    var eventTypeName:String,

    @SerializedName("isLiked")
    @Expose
    var isLiked:Boolean,

    @SerializedName("locationName")
    @Expose
    var locationName:String,

        ){}