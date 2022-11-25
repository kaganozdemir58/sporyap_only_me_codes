package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SearchEventCategory(
    var id:Int,
    var categoryTitle:String,
    var searchEventList:ArrayList<SearchEvent>) : Parcelable {
}