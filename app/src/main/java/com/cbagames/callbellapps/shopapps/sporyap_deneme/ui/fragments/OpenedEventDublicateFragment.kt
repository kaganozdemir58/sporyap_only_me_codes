package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.cbagames.callbellapps.shopapps.sporyap_deneme.R
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.FragmentOpenedEventDublicateBinding
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter.OpenedEventParentRVAdapter
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.viewmodel.openEvents.OpenedEventPageViewModel

class OpenedEventDublicateFragment : Fragment() {
    private lateinit var design: FragmentOpenedEventDublicateBinding
    private lateinit var viewModel: OpenedEventPageViewModel
    private lateinit var textViewSelected: TextView
    private var textViewList = ArrayList<TextView>()
    private lateinit var eventType:String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_opened_event_dublicate, container, false)
        design.fragment = this

        textViewList.add(design.textView3)
        textViewList.add(design.textView2)
        textViewList.add(design.textView5)
        textViewList.add(design.textView6)

        getTextViewForSelectButton(eventType)

        viewModel.mList.observe(viewLifecycleOwner){
            val  adapter = OpenedEventParentRVAdapter(requireContext(),it,"dublicate")
            design.adapter = adapter
            //Log.e("it",it.toString())
        }

        // tümü seçimi defauld olarak ekliyoruz
        //textViewSelected = design.textView3


        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // gelen verinin değeri alınacak.
        // alınan değer viewModelRun ile gönderilecek.

        val bundle :OpenedEventFragmentArgs by navArgs()
        eventType = bundle.eventType


        viewModelRun(eventType)

    }

    fun viewModelRun(eventType:String){
        val tempViewModel : OpenedEventPageViewModel by viewModels()
        tempViewModel.eventType = eventType.toString()
        tempViewModel.getAllViewModel()
        viewModel = tempViewModel
    }

    fun selectButton(textView:TextView){

        if (textView != textViewSelected){
            // diğer sayfaya geçiş yapılacak.
            goto(textView,getTextForSelectButton(textView))
        }

    }

    fun goto (it:View,eventType:String){
        val translater = OpenedEventDublicateFragmentDirections
            .actionOpenedEventDublicateFragmentToOpenedEventFragment(eventType)

        Navigation.findNavController(it).navigate(translater)
    }

    fun getTextForSelectButton(textView:TextView):String{
        var text = "all"
        if (textView.text == "Tumu")
            text = "all"
        if (textView.text == "Etkinlik")
            text = "event"
        if (textView.text == "Eğitim")
            text = "education"
        if (textView.text == "Antrenman")
            text = "trainer"
        return text
    }

    fun getTextViewForSelectButton(eventType:String){
        for (indexTextView in textViewList){
            indexTextView.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.white))
            indexTextView.setTextSize(15f)
            indexTextView.setTypeface(Typeface.DEFAULT)
        }
        var i = 0;
        when(eventType){
            "all" -> i=0;
            "event" -> i=1;
            "education" -> i=2;
            "trainer" -> i=3;
        }
        textViewList[i].setTextColor(Color.parseColor("#0DB70E"))
        textViewList[i].setTextSize(14f)
        textViewList[i].setTypeface(Typeface.DEFAULT)

        val typeFace = ResourcesCompat.getFont(requireContext(),R.font.montserrat_bold)
        textViewList[i]!!.setTypeface(typeFace)


        textViewSelected = textViewList[i]
    }

    fun selectedButtonColorsSetting(textView:TextView){
        for (indexTextView in textViewList){
            if (indexTextView == textView){
                textView.setTextColor(Color.parseColor("#0DB70E"))
                textView.setTextSize(17f)
                textView.setTypeface(Typeface.DEFAULT_BOLD)
            }else{
                textView.setTextColor(ContextCompat.getColor(this.requireContext(), R.color.white))
                textView.setTextSize(16f)
                textView.setTypeface(Typeface.DEFAULT)
            }
        }
    }




}