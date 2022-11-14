package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.searchData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class eventSearchCategoryTitleDetails (

    @SerializedName("isPopulerSearchTitle")
    @Expose
    var isPopulerSearchTitle:String,

    @SerializedName("isRecommendedTitle")
    @Expose
    var isRecommendedTitle:String,

    @SerializedName("isPopulerAtheleteTitle")
    @Expose
    var isPopulerAtheleteTitle:String,

    @SerializedName("isPopulerTrainerTitle")
    @Expose
    var isPopulerTrainerTitle:String,

    @SerializedName("isPopulerCorporateTitle")
    @Expose
    var isPopulerCorporateTitle:String,

    @SerializedName("isPopulerFacilitiesTitle")
    @Expose
    var isPopulerFacilitiesTitle:String,

    @SerializedName("isPopulerGroupsTitle")
    @Expose
    var isPopulerGroupsTitle:String,

    @SerializedName("isPopulerTeamsTitle")
    @Expose
    var isPopulerTeamsTitle:String,

        ) {
}