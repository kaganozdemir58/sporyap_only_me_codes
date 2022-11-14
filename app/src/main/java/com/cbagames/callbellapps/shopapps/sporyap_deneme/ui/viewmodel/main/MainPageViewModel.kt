package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.MediaObject
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.repo.MainMediaObjectDaoRepository

class MainPageViewModel : ViewModel() {
    val kRepo = MainMediaObjectDaoRepository()

    var mediaObjectList=  MutableLiveData<List<MediaObject>>()

    init {
        getAllViewModel()
        mediaObjectList = kRepo.getMutableList()
    }

    fun getAllViewModel(){
        kRepo.getAllData()
    }
}