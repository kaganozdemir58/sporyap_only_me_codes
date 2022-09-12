package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity

import java.io.Serializable

data class MediaObject (var id:Int,
                        var title:String,
                        var media_url:String,
                        var profilePictureUrl:String,
                        var educationName:String,
                        var SporName:String,
                        var adress:String,
                        var rating:Int,
                        var personTotal:Int,
                        var likeState:Boolean) : Serializable {
}