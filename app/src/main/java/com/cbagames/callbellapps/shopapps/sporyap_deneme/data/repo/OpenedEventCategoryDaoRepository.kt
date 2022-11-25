package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.OpenedEvent
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.OpenedEventCategory

import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.ApiUtils
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.Constants
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.openedData.GetOpenedEvents
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.openedData.allEventList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OpenedEventCategoryDaoRepository() {

    var objectList: MutableLiveData<List<OpenedEventCategory>>

    var PopulerTitleList = ArrayList<OpenedEvent>()
    var NewTitleList = ArrayList<OpenedEvent>()
    var MissingOnlyOneTitleList = ArrayList<OpenedEvent>()
    var StartSoonTitleList = ArrayList<OpenedEvent>()
    var RecommendedTitleList = ArrayList<OpenedEvent>()

    val categoryList = ArrayList<OpenedEventCategory>()

    init {
        objectList = MutableLiveData()
    }

    fun getMutableList(): MutableLiveData<List<OpenedEventCategory>> {
        return objectList
    }

    fun getAllObjects() {

        val mList = ArrayList<OpenedEventCategory>()

        val i1 = OpenedEventCategory(
            1,
            "Popüler Etkinlikler",
            "popular",
            searchEvent(30, "popular", "https://sporyap.app/photos/arama/arama/arama1.png","event")
        )
        val i2 = OpenedEventCategory(
            1,
            "Yeni Eklnenler",
            "new",
            searchEvent(20, "new", "https://sporyap.app/photos/arama/arama/arama2.png","event")
        )
        val i3 = OpenedEventCategory(
            1,
            "Bir Kişi Eksik Olanlar",
            "missingOnlyOne",
            searchEvent(5, "missingOnlyOne", "https://sporyap.app/photos/arama/arama/arama3.png","trainer")
        )
        val i4 = OpenedEventCategory(
            1,
            "Yakında Başlayacaklar",
            "startSoon",
            searchEvent(8, "startSoon", "https://sporyap.app/photos/arama/arama/arama4.png","trainer")
        )
        val i5 = OpenedEventCategory(
            1,
            "Senin İçin Öneriler",
            "recommend",
            searchEvent(9, "recommend", "https://sporyap.app/photos/arama/arama/arama5.png","education")
        )


        mList.add(i1)
        mList.add(i2)
        mList.add(i3)
        mList.add(i4)
        mList.add(i5)


        objectList.value = mList
    }

    fun searchEvent(i: Int, name: String, photoUrl: String,eventType:String): ArrayList<OpenedEvent> {
        val mList = ArrayList<OpenedEvent>()
        for (index in 1..i) {
            val a = OpenedEvent(index, name, photoUrl,eventType)
            mList.add(a)
        }
        return mList
    }


    fun getAllData(eventType: String){
        val kdi = ApiUtils.openedEventDaoInterface()

        val token = "eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VyTmFtZSI6InRlc3Quc3BvcmN1IiwiRW1haWwiOiJzcG9yY3VAZ21haWwuY29tIiwiUGhvbmUiOiIwNTU1NTU1NTU1NSIsIjAiOiI5MSIsIlJvbGVJZCI6IjMiLCJVc2VyVHlwZSI6IlNwb3JjdSIsIklzTG9naW5Nb2JpbGUiOiIxIiwiZXhwIjoxNjc2NjQ5MDg2fQ.KyjOELtBJoaydCCnWioKHJa0JLT2Hcx-J_GAWn6mMZY"
        val accept =  "application/json"
        kdi.allData(Constants.BEARER_KEY + token, Constants.API_TOKEN,accept).enqueue(object :
            Callback<GetOpenedEvents> {
            override fun onFailure(call: Call<GetOpenedEvents>?, t: Throwable?) {
                Log.e("response ",t.toString())
            }

            override fun onResponse(call: Call<GetOpenedEvents>?, response: Response<GetOpenedEvents>?) {
                if (response != null){
                    clearLists()
                    addToList(response,eventType)
                }
            }
        })

    }

    fun clearLists(){
        PopulerTitleList.clear()
        NewTitleList.clear()
        MissingOnlyOneTitleList.clear()
        StartSoonTitleList.clear()
        RecommendedTitleList.clear()
        categoryList.clear()
    }

    fun addToList(response: Response<GetOpenedEvents>,eventType: String){

        val mList = response.body().result.allEventList

        if (mList != null){

            for (k in mList){
                val i = OpenedEvent(k.id,k.title,k.eventPhoto,k.eventType)

                if (eventType.equals("all")){
                    //Log.e("event type xxx",eventType+k.id)
                    addCategoryAllList(k,i)
                }else {
                    if (i.eventType == eventType){
                        //Log.e("event type xxx",eventType+k.id)
                        addCategoryAllList(k,i)
                    }
                }

            }

        }else{
            Log.e("Liste null ","Null object")
        }
        addCategoryList(response)
    }

    private fun addCategoryAllList(k:allEventList,i:OpenedEvent){
        if (k.isPopuler){
            PopulerTitleList.add(i)
        }
        if(k.isNew){
            NewTitleList.add(i)
        }
        if(k.isMissingOnlyOne){
            MissingOnlyOneTitleList.add(i)
        }
        if(k.isStartSoon){
            StartSoonTitleList.add(i)
        }
        if(k.isRecommended){
            RecommendedTitleList.add(i)
        }
    }

    private fun addCategoryList(response: Response<GetOpenedEvents>) {
        // Category Titles
        val cList = response.body().result.categoryTitleDetails

        var p = OpenedEventCategory(1,cList.isPopulerTitle.toString(),"popular",PopulerTitleList)
        var n = OpenedEventCategory(2,cList.isNewTitle.toString(),"new",NewTitleList)
        var m = OpenedEventCategory(3,cList.isMissingOnlyOneTitle.toString(),"missingOnlyOne",MissingOnlyOneTitleList)
        var s = OpenedEventCategory(4,cList.isStartSoonTitle.toString(),"startSoon",StartSoonTitleList)
        var r = OpenedEventCategory(5,cList.isRecommendedTitle.toString(),"recommend",RecommendedTitleList)

        if (p.OpenedEventList.size>1){
            categoryList.add(p)
        }
        if (n.OpenedEventList.size>1) {
            categoryList.add(n)
        }
        if (m.OpenedEventList.size>1) {
            categoryList.add(m)
        }
        if (s.OpenedEventList.size>1) {
            categoryList.add(s)
        }
        if (r.OpenedEventList.size>1) {
            categoryList.add(r)
        }

        objectList.value = categoryList
    }

}