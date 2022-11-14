package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.cbagames.callbellapps.shopapps.sporyap_deneme.R
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.FragmentSearchBinding
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter.SearchViewParentRVAdapter
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.viewmodel.searchview.SearchPageViewMoel

class SearchFragment : Fragment() {
    private lateinit var design: FragmentSearchBinding
    private lateinit var viewModel:SearchPageViewMoel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        design.searchFragment = this

        viewModel.mList.observe(viewLifecycleOwner){
            val  adapter = SearchViewParentRVAdapter(requireContext(),it)
            design.adapter = adapter
        }

        return design.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : SearchPageViewMoel by viewModels()
        viewModel = tempViewModel
    }


}