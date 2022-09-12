package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.repo

import androidx.lifecycle.MutableLiveData
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.MediaObject

class MediaObjectDaoRepository {
    var mediaObjectList:MutableLiveData<List<MediaObject>>

    init {
        mediaObjectList = MutableLiveData()
    }

    fun getMutableList():MutableLiveData<List<MediaObject>>{
        return mediaObjectList
    }

    fun getAllObjects() {
        val mList = ArrayList<MediaObject>()
        val i1 = MediaObject(1,"bir","buz","","Koşu | Eğitim", "Jogging","Bakırköy Sahil / İstanbul",4,6,false)
        val i2 = MediaObject(2,"iki","golf","","Yoga | Eğitim", "Yoga","Avcılar / İstanbul",3,23,true)
        val i3 = MediaObject(3,"üç","kurek","","Kürek | Eğitim", "Kürek","Tuzla / İstanbul",4,8,false)
        val i4 = MediaObject(4,"dört","yuzme","","Yüzme | Eğitim", "Yüzme","Gürün / Sivas",5,12,true)
        val i5 = MediaObject(5,"beş","parasut","","Paraşüt | Eğitim", "Paraşüt","Etimesgut / Ankara",2,23,false)
        val i6 = MediaObject(6,"altı","ruzgar","","Rüzgar | Eğitim", "Rüzgar","Ataköy / İstanbul",3,8,true)
        val i7 = MediaObject(7,"yedi","tennis","","Tenis | Eğitim", "Tenis","Merter / İstanbul",1,6,false)


        mList.add(i1)
        mList.add(i2)
        mList.add(i3)
        mList.add(i4)
        mList.add(i5)
        mList.add(i6)
        mList.add(i7)

        mediaObjectList.value = mList
    }
}