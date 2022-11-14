package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.cbagames.callbellapps.shopapps.sporyap_deneme.R
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.FragmentOtherPageForNavigationTestBinding

class OtherPageForNavigationTestFragment : Fragment() {

    private lateinit var design: FragmentOtherPageForNavigationTestBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        design = FragmentOtherPageForNavigationTestBinding.inflate(inflater, container, false)

        design.textView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_otherPageForNavigationTestFragment_to_searchFragment)
        }
        design.goToEvent.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_otherPageForNavigationTestFragment_to_mainPageFragment)
        }
        design.goTosearch.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_otherPageForNavigationTestFragment_to_searchFragment)
        }
        design.goToOpened.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_otherPageForNavigationTestFragment_to_openedEventFragment)
        }

        return design.root
    }




}