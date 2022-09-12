package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.MediaObject
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.repo.MediaObjectDaoRepository

class MainPageViewModel : ViewModel() {
    val kRepo = MediaObjectDaoRepository()

    var mediaObjectList=  MutableLiveData<List<MediaObject>>()

    init {
        getAllViewModel()
        mediaObjectList = kRepo.getMutableList()
    }

    fun getAllViewModel(){
        kRepo.getAllObjects()
    }
}