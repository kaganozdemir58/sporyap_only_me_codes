package com.cbagames.callbellapps.shopapps.sporyap_deneme.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiUtils {
    companion object{
        val BASE_URL = "https://mobileapitest.sporyap.app/api/v1/"

        fun searchEventDaoInterface():SearchEventDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(SearchEventDaoInterface::class.java)
        }
        fun openedEventDaoInterface():OpenedEventDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(OpenedEventDaoInterface::class.java)
        }
        fun mainEventDaoInterface():MainEventDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(MainEventDaoInterface::class.java)
        }
    }
}