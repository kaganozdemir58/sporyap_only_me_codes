package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.searchData


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class result (

    @SerializedName("maxSlidePerCategory")
    @Expose
    var maxSlidePerCategory:Int,

    @SerializedName("eventSearchCategoryTitleDetails")
    @Expose
    var eventSearchCategoryTitleDetails:eventSearchCategoryTitleDetails,

    @SerializedName("allSearchList")
    @Expose
    var allSearchList:List<allSearchList>,

    ) {
}