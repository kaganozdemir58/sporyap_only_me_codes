package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.MediaObject
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.ApiUtils
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.Constants
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.mainData.eventTimeline
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainMediaObjectDaoRepository {
    var mediaObjectList:MutableLiveData<List<MediaObject>>

    init {
        mediaObjectList = MutableLiveData()
    }

    fun getMutableList():MutableLiveData<List<MediaObject>>{
        return mediaObjectList
    }

    fun getAllObjects() {

        val mList = ArrayList<MediaObject>()
/*
        val i1 = MediaObject(1,"buz","","Koşu", "Eğitim","Jogging","Bakırköy Sahil / İstanbul",4,6,false,"")
        val i2 = MediaObject(2,"golf","","Yoga","Eğitim", "Yoga","Avcılar / İstanbul",3,23,true,"")
        val i3 = MediaObject(3,"kurek","","Kürek", "Eğitim","Kürek","Tuzla / İstanbul",4,8,false,"")
        val i4 = MediaObject(4,"yuzme","","Yüzme", "Eğitim","Yüzme","Gürün / Sivas",5,12,true,"")
        val i5 = MediaObject(5,"parasut","","Paraşüt", "Eğitim","Paraşüt","Etimesgut / Ankara",2,23,false,"")
        val i6 = MediaObject(6,"ruzgar","","Rüzgar", "Eğitim","Rüzgar","Ataköy / İstanbul",3,8,true,"")
        val i7 = MediaObject(7,"tennis","","Tenis", "Eğitim","Tenis","Merter / İstanbul",1,6,false,"")
*/

        val i1 = MediaObject(1,"https://sporyaproot@sporyap.app/photos/video/buz_pateni_video.mp4","","Koşu", "Eğitim","Jogging","Bakırköy Sahil / İstanbul",4,6,false,"")
        val i2 = MediaObject(2,"https://sporyaproot@sporyap.app/photos/video/golf_video.mp4","","Yoga","Eğitim", "Yoga","Avcılar / İstanbul",3,23,true,"")
        val i3 = MediaObject(3,"https://sporyaproot@sporyap.app/photos/video/kurek_video.mp4","","Kürek", "Eğitim","Kürek","Tuzla / İstanbul",4,8,false,"")
        val i4 = MediaObject(4,"https://sporyaproot@sporyap.app/photos/video/yuzme_video.mp4","","Yüzme", "Eğitim","Yüzme","Gürün / Sivas",5,12,true,"")
        val i5 = MediaObject(5,"https://sporyaproot@sporyap.app/photos/video/parasut_video.mp4","","Paraşüt", "Eğitim","Paraşüt","Etimesgut / Ankara",2,23,false,"")
        val i6 = MediaObject(6,"https://sporyaproot@sporyap.app/photos/video/ruzgar_sorfu_video.mp4","","Rüzgar", "Eğitim","Rüzgar","Ataköy / İstanbul",3,8,true,"")
        val i7 = MediaObject(7,"https://sporyaproot@sporyap.app/photos/video/tenis_video.mp4","","Tenis", "Eğitim","Tenis","Merter / İstanbul",1,6,false,"")

        mList.add(i1)
        mList.add(i2)
        mList.add(i3)
        mList.add(i4)
        mList.add(i5)
        mList.add(i6)
        mList.add(i7)

        mediaObjectList.value = mList
    }

    fun getAllData(){
        val kdi = ApiUtils.mainEventDaoInterface()

        val xList = ArrayList<MediaObject>()

        val token = "eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VyTmFtZSI6InRlc3Quc3BvcmN1IiwiRW1haWwiOiJzcG9yY3VAZ21haWwuY29tIiwiUGhvbmUiOiIwNTU1NTU1NTU1NSIsIjAiOiI5MSIsIlJvbGVJZCI6IjMiLCJVc2VyVHlwZSI6IlNwb3JjdSIsIklzTG9naW5Nb2JpbGUiOiIxIiwiZXhwIjoxNjc2NjQ5MDg2fQ.KyjOELtBJoaydCCnWioKHJa0JLT2Hcx-J_GAWn6mMZY"
        val accept =  "application/json"
        kdi.allData(Constants.BEARER_KEY + token, Constants.API_TOKEN,accept).enqueue(object :
            Callback<eventTimeline> {
            override fun onFailure(call: Call<eventTimeline>?, t: Throwable?) {
                Log.e("response ","bbb"+t.toString())
            }

            override fun onResponse(call: Call<eventTimeline>?, response: Response<eventTimeline>?) {
                if (response != null){
                    val mList = response.body().result
                    Log.e("response ","aaaaa"+response.toString())


                    if (mList != null){

                        for (k in mList){
                            Log.e("********","**********")
                            Log.e("responce",k.id.toString())
                            Log.e("responce",k.sportName)
                            val i = MediaObject(
                                k.id,
                                k.coverMediaUrl,
                                k.profileImage,
                                k.sportName,
                                k.eventTypeName,
                                k.eventName,
                                k.locationName,
                                k.rating,
                                k.totalMemberCount,
                                k.isLiked,
                                k.profileImage)
                            xList.add(i)
                        }
                    }else{
                        Log.e("responce ","Null object")
                    }


                    mediaObjectList.value = xList
                }
            }
        })
    }
}