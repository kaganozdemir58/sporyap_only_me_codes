package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.cbagames.callbellapps.shopapps.sporyap_deneme.R
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.FragmentOtherPageForNavigationTestBinding

class OtherPageForNavigationTestFragment : Fragment() {

    private lateinit var design: FragmentOtherPageForNavigationTestBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        design = FragmentOtherPageForNavigationTestBinding.inflate(inflater, container, false)

        val bundle:OtherPageForNavigationTestFragmentArgs by navArgs()
        val mediaObject = bundle.mediaObject

        design.textView.setText(mediaObject.SporName)

        return design.root
    }

}