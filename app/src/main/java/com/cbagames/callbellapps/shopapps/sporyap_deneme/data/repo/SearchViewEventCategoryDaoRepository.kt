package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.SearchEventCategory
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.SearchEvent
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.ApiUtils
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.Constants
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.searchData.getSearchEvents
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewEventCategoryDaoRepository {
    var mediaObjectList: MutableLiveData<List<SearchEventCategory>>

    init {
        mediaObjectList = MutableLiveData()
    }

    fun getMutableList(): MutableLiveData<List<SearchEventCategory>> {
        return mediaObjectList
    }

    fun getAllObjects() {

        val mList = ArrayList<SearchEventCategory>()
/*
        val i1 = EventCategory(1,"Popüler Aramalar", searchEvent(3,"a","https://sporyap.app/photos/arama/arama/arama1.png"))
        val i2 = EventCategory(1,"Senn İçin Önerilenler", searchEvent(20,"b","https://sporyap.app/photos/arama/arama/arama2.png"))
        val i3 = EventCategory(1,"Popüler Sporcular", searchEvent(5,"c","https://sporyap.app/photos/arama/arama/arama3.png"))
        val i4 = EventCategory(1,"Popüler Eğitmenler", searchEvent(8,"d","https://sporyap.app/photos/arama/arama/arama4.png"))
        val i5 = EventCategory(1,"Popüler Kurumlar", searchEvent(9,"e","https://sporyap.app/photos/arama/arama/arama5.png"))
        val i6 = EventCategory(1,"Popüler Tesisler", searchEvent(10,"f","https://sporyap.app/photos/arama/arama/arama6.png"))
        val i7 = EventCategory(1,"Popüler Gruplar", searchEvent(6,"g","https://sporyap.app/photos/arama/arama/arama7.png"))

        mList.add(i1)
        mList.add(i2)
        mList.add(i3)
        mList.add(i4)
        mList.add(i5)
        mList.add(i6)
        mList.add(i7)
        mList.add(i7)*/


        //mediaObjectList.value = mList
    }

    fun getAllData(){
        val kdi = ApiUtils.searchEventDaoInterface()

        var PopulerSearchList = ArrayList<SearchEvent>()
        var RecommendedList = ArrayList<SearchEvent>()
        var PopulerAtheleteList = ArrayList<SearchEvent>()
        var PopulerTrainerList = ArrayList<SearchEvent>()
        var PopulerCorporateList = ArrayList<SearchEvent>()
        var PopulerFacilitiesList = ArrayList<SearchEvent>()
        var PopulerGroupsList = ArrayList<SearchEvent>()
        var PopulerTeamsList = ArrayList<SearchEvent>()
        val categoryList = ArrayList<SearchEventCategory>()


        val token = "eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VyTmFtZSI6InRlc3Quc3BvcmN1IiwiRW1haWwiOiJzcG9yY3VAZ21haWwuY29tIiwiUGhvbmUiOiIwNTU1NTU1NTU1NSIsIjAiOiI5MSIsIlJvbGVJZCI6IjMiLCJVc2VyVHlwZSI6IlNwb3JjdSIsIklzTG9naW5Nb2JpbGUiOiIxIiwiZXhwIjoxNjc2NjQ5MDg2fQ.KyjOELtBJoaydCCnWioKHJa0JLT2Hcx-J_GAWn6mMZY"
        val accept =  "application/json"
        kdi.allData(Constants.BEARER_KEY + token, Constants.API_TOKEN,accept).enqueue(object :
            Callback<getSearchEvents> {
            override fun onFailure(call: Call<getSearchEvents>?, t: Throwable?) {
                Log.e("response ",t.toString())
            }

            override fun onResponse(call: Call<getSearchEvents>?, response: Response<getSearchEvents>?) {
                if (response != null){
                    val mList = response.body().result.allSearchList
                    Log.e("response ",response.toString())

                    if (mList != null){

                        for (k in mList){
                            Log.e("********","**********")
                            Log.e("kişi ad",k.eventType)
                            Log.e("kişi tel",k.eventPhoto)
                            val i = SearchEvent(k.id,k.eventType,k.eventPhoto)
                            if (k.isPopulerSearch)
                                PopulerSearchList.add(i)
                            if(k.isRecommended)
                                RecommendedList.add(i)
                            if(k.isPopulerAthelete)
                                PopulerAtheleteList.add(i)
                            if(k.isPopulerTrainer)
                                PopulerTrainerList.add(i)
                            if(k.isPopulerCorporate)
                                PopulerCorporateList.add(i)
                            if(k.isPopulerFacilities)
                                PopulerFacilitiesList.add(i)
                            if(k.isPopulerGroups)
                                PopulerGroupsList.add(i)
                            if(k.isPopulerTeams)
                                PopulerTeamsList.add(i)
                        }
                    }else{
                        Log.e("Liste null ","Null object")
                    }

                    // Category Titles
                    val cList = response.body().result.eventSearchCategoryTitleDetails

                    var Populer = SearchEventCategory(1,cList.isPopulerSearchTitle.toString(),PopulerSearchList)
                    var Recommended = SearchEventCategory(1,cList.isRecommendedTitle.toString(),RecommendedList)
                    var Athlette = SearchEventCategory(1,cList.isPopulerAtheleteTitle.toString(),PopulerAtheleteList)
                    var Trainer = SearchEventCategory(1,cList.isPopulerTrainerTitle.toString(),PopulerTrainerList)
                    var Corporate = SearchEventCategory(1,cList.isPopulerCorporateTitle.toString(),PopulerCorporateList)
                    var Facilities = SearchEventCategory(1,cList.isPopulerFacilitiesTitle.toString(),PopulerFacilitiesList)
                    var Groups = SearchEventCategory(1,cList.isPopulerGroupsTitle.toString(),PopulerGroupsList)
                    var Teams = SearchEventCategory(1,cList.isPopulerTeamsTitle.toString(),PopulerTeamsList)

                    categoryList.add(Populer)
                    categoryList.add(Recommended)
                    categoryList.add(Athlette)
                    categoryList.add(Trainer)
                    categoryList.add(Corporate)
                    categoryList.add(Facilities)
                    categoryList.add(Groups)
                    categoryList.add(Teams)

                    Log.e("kategori",Teams.categoryTitle.toString())

                    mediaObjectList.value = categoryList
                }
            }
        })
    }
}

fun searchEvent(i:Int, name:String, photoUrl:String):ArrayList<SearchEvent>{
    val mList = ArrayList<SearchEvent>()
    for (index in 1..i){
        val a = SearchEvent(index,name +" - "+index,photoUrl)
        mList.add(a)
    }
    return mList
}

