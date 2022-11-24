package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.viewmodel.openEvents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.OpenedEventCategory
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.repo.OpenedEventCategoryDaoRepository

class OpenedEventPageViewModel (): ViewModel() {
    val kRepo = OpenedEventCategoryDaoRepository()

    var mList =  MutableLiveData<List<OpenedEventCategory>>()

    var eventType = ""

    init {
        //getAllViewModel()
       // mList = kRepo.getMutableList()
    }

    fun getAllViewModel(){
        kRepo.getAllData(eventType)

        mList = kRepo.getMutableList()
    }

}