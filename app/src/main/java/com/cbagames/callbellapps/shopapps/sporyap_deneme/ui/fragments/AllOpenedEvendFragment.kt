package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cbagames.callbellapps.shopapps.sporyap_deneme.R
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.OpenedEvent
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.OpenedEventCategory
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.FragmentAllOpenedEvendBinding
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.FragmentOpenedEventBinding
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter.AllOpenedRVAdapter
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter.OpenedEventChildRVAdapter
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter.OpenedEventChildRVAdapters2

class AllOpenedEvendFragment : Fragment() {
    private lateinit var design: FragmentAllOpenedEvendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        design = DataBindingUtil.inflate(inflater,R.layout.fragment_all_opened_evend, container, false)
        design.fragment = this

        val bundle :AllOpenedEvendFragmentArgs by navArgs()

        val mList = bundle.list
        val titleName = bundle.titleName

        design.textViewTitleName.setText(titleName)

        design.rvAllOpened.setHasFixedSize(true)
        design.rvAllOpened.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        val adapter = AllOpenedRVAdapter(requireContext(), mList.toList())
        design.adapter = adapter


        //Log.e("List all opened",mList.toList().toString())

        //design.textViewGoster.setText(mList.toList().toString())

        design.imageViewBack.setOnClickListener{
            goto()
        }

        return design.root
    }

    fun goto (){
        val translater = AllOpenedEvendFragmentDirections
            .actionAllOpenedEvendFragmentToOpenedEventFragment2("all")

        Navigation.findNavController(requireView()).navigate(translater)
    }


}