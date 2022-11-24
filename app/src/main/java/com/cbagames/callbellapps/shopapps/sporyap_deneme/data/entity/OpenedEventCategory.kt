package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OpenedEventCategory (
    var id:Int,
    var categoryTitle:String,
    var photoType:String,
    var OpenedEventList:ArrayList<OpenedEvent>
    ) : Parcelable {}