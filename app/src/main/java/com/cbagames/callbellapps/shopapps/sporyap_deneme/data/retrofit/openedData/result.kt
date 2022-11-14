package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.openedData

import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.searchData.allSearchList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class result (

    @SerializedName("maxSlidePerCategory")
    @Expose
    var maxSlidePerCategory:Int,

    @SerializedName("categoryTitleDetails")
    @Expose
    var categoryTitleDetails: categoryTitleDetails,

    @SerializedName("allEventList")
    @Expose
    var allEventList:List<allEventList>,

        ) {
}