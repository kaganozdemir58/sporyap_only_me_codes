package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity

import java.io.Serializable

data class OpenedEvent(
    var id:Int,
    var title:String,
    var eventPhoto:String,
    var eventType:String
):Serializable {
}