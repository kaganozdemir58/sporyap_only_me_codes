package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit

import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.openedData.GetOpenedEvents
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit.searchData.getSearchEvents
import retrofit2.Call
import retrofit2.http.*

interface SearchEventDaoInterface {

    /*@POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    fun kisiGuncelle(
        @Field("kisi_id") kisi_id:Int,
        @Field("kisi_ad") kisi_ad:String,
        @Field("kisi_tel") kisi_tel:String):Call<CRUDCevap>*/


    @GET("events/get-search-events")
    fun allData(@Header(Constants.AUTHORIZATION_KEY) token : String,
                @Header(Constants.HEADER_API_KEY) apiKey : String,
                @Header(Constants.ACCEPT) accept : String):Call<getSearchEvents>
}