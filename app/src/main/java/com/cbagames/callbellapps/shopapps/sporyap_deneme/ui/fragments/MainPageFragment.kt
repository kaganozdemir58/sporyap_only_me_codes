package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.cbagames.callbellapps.shopapps.sporyap_deneme.R
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.MediaObject
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.FragmentMainPageBinding
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter.MainPageRVAdapter
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.viewmodel.main.MainPageViewModel

class MainPageFragment : Fragment() {

    private lateinit var design: FragmentMainPageBinding
    private lateinit var viewModel: MainPageViewModel
    //private lateinit var mList : ArrayList<MediaObject>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_main_page, container, false)
        design.mainPageFragment = this

        viewModel.mediaObjectList.observe(viewLifecycleOwner){
            val  adapter = MainPageRVAdapter(requireContext(),it,viewModel)
            design.adapter = adapter
        }


        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainPageViewModel by viewModels()
        viewModel = tempViewModel
    }


}