package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit

import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.openedData.GetOpenedEvents
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface OpenedEventDaoInterface {
    @GET("events/get-opened-events")
    fun allData(@Header(Constants.AUTHORIZATION_KEY) token : String,
                @Header(Constants.HEADER_API_KEY) apiKey : String,
                @Header(Constants.ACCEPT) accept : String): Call<GetOpenedEvents>
}