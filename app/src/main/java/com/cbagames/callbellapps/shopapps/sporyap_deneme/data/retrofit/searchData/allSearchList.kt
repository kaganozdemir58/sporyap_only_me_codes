package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.searchData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class allSearchList (

    @SerializedName("id")
    @Expose
    var id:Int,

    @SerializedName("eventPhoto")
    @Expose
    var eventPhoto:String,

    @SerializedName("eventType")
    @Expose
    var eventType:String,

    @SerializedName("isPopulerSearch")
    @Expose
    var isPopulerSearch:Boolean,

    @SerializedName("isRecommended")
    @Expose
    var isRecommended:Boolean,

    @SerializedName("isPopulerAthelete")
    @Expose
    var isPopulerAthelete:Boolean,

    @SerializedName("isPopulerTrainer")
    @Expose
    var isPopulerTrainer:Boolean,

    @SerializedName("isPopulerCorporate")
    @Expose
    var isPopulerCorporate:Boolean,

    @SerializedName("isPopulerFacilities")
    @Expose
    var isPopulerFacilities:Boolean,

    @SerializedName("isPopulerGroups")
    @Expose
    var isPopulerGroups:Boolean,

    @SerializedName("isPopulerTeams")
    @Expose
    var isPopulerTeams:Boolean,

    ) {}