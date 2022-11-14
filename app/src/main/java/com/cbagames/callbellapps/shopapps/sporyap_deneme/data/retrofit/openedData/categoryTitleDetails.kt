package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.openedData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class categoryTitleDetails (

    @SerializedName("isPopulerTitle")
    @Expose
    var isPopulerTitle:String,

    @SerializedName("isNewTitle")
    @Expose
    var isNewTitle:String,

    @SerializedName("isMissingOnlyOneTitle")
    @Expose
    var isMissingOnlyOneTitle:String,

    @SerializedName("isStartSoonTitle")
    @Expose
    var isStartSoonTitle:String,

    @SerializedName("isRecommendedTitle")
    @Expose
    var isRecommendedTitle:String,

    ) {
}