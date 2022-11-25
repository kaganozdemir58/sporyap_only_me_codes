package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchEvent (

    var id:Int,
    var eventType:String,
    var eventPhoto:String,


    ) : Parcelable {  }