package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


import java.io.Serializable
@Parcelize
data class OpenedEvent(
    var id:Int,
    var title:String,
    var eventPhoto:String,
    var eventType:String
): Parcelable {
}