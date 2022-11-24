package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaObject (var id:Int,
                        var coverMediaUrl:String,
                        var profileImage:String,
                        var sportName:String,
                        var eventTypeName:String,
                        var eventName:String,
                        var locationName:String,
                        var rating:Int,
                        var totalMemberCount:Int,
                        var isLiked:Boolean,
                        var mediaType:String,
) : Parcelable {  }