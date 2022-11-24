package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.OpenedEvent
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.OpenedEventCategory
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.CardDesignOpenedEventParentBinding
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.fragments.OpenedEventDublicateFragmentDirections
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.fragments.OpenedEventFragment
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.fragments.OpenedEventFragmentDirections


class OpenedEventParentRVAdapter (private val mContext: Context,
                                  private val mList: List<OpenedEventCategory>,
                                  private val typeClass:String  )
    : RecyclerView.Adapter<OpenedEventParentRVAdapter.CardDesignHolder>(){

    inner class CardDesignHolder (design: CardDesignOpenedEventParentBinding)
        : RecyclerView.ViewHolder(design.root){

        var design: CardDesignOpenedEventParentBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cardDesignHolder = CardDesignOpenedEventParentBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(cardDesignHolder)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val listObject = mList.get(position)
        holder.design.listeSayisi = listObject.OpenedEventList.size
        if( listObject.OpenedEventList.size > 0){
            holder.design.textViewGroupName.setText(listObject.categoryTitle)
        }

        var aList = listObject.OpenedEventList

        holder.design.textViewTumu.setOnClickListener{

            if (typeClass == "opened"){
                val translater = OpenedEventFragmentDirections
                    .actionOpenedEventFragmentToAllOpenedEvendFragment(aList.toTypedArray(),listObject.categoryTitle)

                Navigation.findNavController(it).navigate(translater)
            }

            if (typeClass == "dublicate"){
                val translater = OpenedEventDublicateFragmentDirections.actionOpenedEventDublicateFragmentToAllOpenedEvendFragment(aList.toTypedArray(),listObject.categoryTitle)

                Navigation.findNavController(it).navigate(translater)
            }
        }

        when(listObject.photoType){
            "popular" -> {
                val adapter = OpenedEventChildRVAdapter(mContext,listObject.OpenedEventList)
                holder.design.rvSearchChilds.adapter = adapter
            }

            "new" -> {
                val adapter = OpenedEventChildRVAdapters2(mContext,listObject.OpenedEventList)
                holder.design.rvSearchChilds.adapter = adapter
            }

            "missingOnlyOne" -> {
                val adapter = OpenedEventChildRVAdapters3(mContext,listObject.OpenedEventList)
                holder.design.rvSearchChilds.adapter = adapter
            }

            "startSoon" -> {
                val adapter = OpenedEventChildRVAdapters4(mContext,listObject.OpenedEventList)
                holder.design.rvSearchChilds.adapter = adapter
            }

            "recommend" -> {
                val adapter = OpenedEventChildRVAdapters5(mContext,listObject.OpenedEventList)
                holder.design.rvSearchChilds.adapter = adapter
            }
        }


    }

    override fun getItemCount(): Int {
        return mList.size
    }
}

