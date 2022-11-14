package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.cbagames.callbellapps.shopapps.sporyap_deneme.R
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.FragmentOpenedEventBinding
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter.OpenedEventParentRVAdapter
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.viewmodel.openEvents.OpenedEventPageViewModel

class OpenedEventFragment : Fragment() {

    private lateinit var design: FragmentOpenedEventBinding
    private lateinit var viewModel: OpenedEventPageViewModel
    private lateinit var textViewSelected:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_opened_event, container, false)
        design.fragment = this

        viewModel.mList.observe(viewLifecycleOwner){
            val  adapter = OpenedEventParentRVAdapter(requireContext(),it)
            design.adapter = adapter
        }

        // tümü seçimi defauld olarak ekliyoruz
        textViewSelected = design.textView3


        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : OpenedEventPageViewModel by viewModels()
        viewModel = tempViewModel
    }


    fun selectButton(textView:TextView){
        if (textViewSelected != textView){
            textView.setTextColor(Color.parseColor("#0DB70E"))
            //textView.setTextSize(17f)
            textView.setTypeface(Typeface.DEFAULT_BOLD)

            textViewSelected.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.white))
            // textViewSelected.setTextSize(16f)
            textViewSelected.setTypeface(Typeface.DEFAULT)
            textViewSelected = textView
        }
    }

}