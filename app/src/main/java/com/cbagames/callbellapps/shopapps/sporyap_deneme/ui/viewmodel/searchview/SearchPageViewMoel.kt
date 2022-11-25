package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.viewmodel.searchview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.SearchEventCategory
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.repo.SearchViewEventCategoryDaoRepository

class SearchPageViewMoel : ViewModel() {
    val kRepo = SearchViewEventCategoryDaoRepository()

    var mList=  MutableLiveData<List<SearchEventCategory>>()

    init {
        getAllViewModel()
        mList = kRepo.getMutableList()
    }

    fun getAllViewModel(){
        kRepo.getAllData()
    }
}