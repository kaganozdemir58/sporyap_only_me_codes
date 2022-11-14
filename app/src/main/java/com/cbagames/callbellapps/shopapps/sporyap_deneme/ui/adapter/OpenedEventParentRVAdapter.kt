package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.OpenedEventCategory
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.CardDesignOpenedEventParentBinding

class OpenedEventParentRVAdapter (private val mContext: Context, private val mList: List<OpenedEventCategory>)
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
        holder.design.textViewGroupName.setText(listObject.categoryTitle)
        holder.design.listeSayisi = listObject.OpenedEventList.size

        holder.design.textViewTumu.setOnClickListener{
            Toast.makeText(mContext,"Tümü gösterilecek sayfaya geçilecek.",Toast.LENGTH_SHORT).show()
        }

        when(listObject.photoType){
            "popular" -> {
                val adapter = OpenedEventChildRVAdapter(mContext,listObject.OpenedEventList)
                holder.design.rvSearchChilds.adapter = adapter}

            "new" -> {
                val adapter = OpenedEventChildRVAdapters2(mContext,listObject.OpenedEventList)
                holder.design.rvSearchChilds.adapter = adapter}

            "missingOnlyOne" -> {
                val adapter = OpenedEventChildRVAdapters3(mContext,listObject.OpenedEventList)
                holder.design.rvSearchChilds.adapter = adapter}

            "startSoon" -> {
                val adapter = OpenedEventChildRVAdapters4(mContext,listObject.OpenedEventList)
                holder.design.rvSearchChilds.adapter = adapter }

            "recommend" -> {
                val adapter = OpenedEventChildRVAdapters5(mContext,listObject.OpenedEventList)
                holder.design.rvSearchChilds.adapter = adapter}
        }


    }

    override fun getItemCount(): Int {
        return mList.size
    }
}