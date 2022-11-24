package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit

import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.Constants
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.mainData.eventTimeline
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface MainEventDaoInterface {

    @GET("events/event-timeline")
    fun allData(@Header(Constants.AUTHORIZATION_KEY) token : String,
                @Header(Constants.HEADER_API_KEY) apiKey : String,
                @Header(Constants.ACCEPT) accept : String): Call<eventTimeline>
}