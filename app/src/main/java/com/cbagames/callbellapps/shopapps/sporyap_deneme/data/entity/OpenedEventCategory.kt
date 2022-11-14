package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity

import java.io.Serializable

data class OpenedEventCategory (
    var id:Int,
    var categoryTitle:String,
    var photoType:String,
    var OpenedEventList:ArrayList<OpenedEvent>
    ) : Serializable{}