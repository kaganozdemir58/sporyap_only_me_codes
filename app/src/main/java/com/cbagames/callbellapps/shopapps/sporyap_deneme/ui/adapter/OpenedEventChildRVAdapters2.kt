package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.RecyclerView
import com.cbagames.callbellapps.shopapps.sporyap_deneme.R
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.OpenedEvent
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.CardDesignOpenedEventChild1Binding
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.CardDesignOpenedEventChild2Binding
import com.squareup.picasso.Picasso

class OpenedEventChildRVAdapters2 (private val mContext: Context, private val mList: List<OpenedEvent>)
    : RecyclerView.Adapter<OpenedEventChildRVAdapters2.CardDesignHolder>(){

    inner class CardDesignHolder(design: CardDesignOpenedEventChild2Binding)
        : RecyclerView.ViewHolder(design.root){
        var design: CardDesignOpenedEventChild2Binding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cardDesignHolder = CardDesignOpenedEventChild2Binding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(cardDesignHolder)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {

        val listObjct = mList.get(position)

        holder.design.textViewChild.setText(listObjct.title)
        Picasso.with(mContext).load(listObjct.eventPhoto).error(R.drawable.golf_picture)
            .into(holder.design.Image)

    }

    override fun getItemCount(): Int {
        var size = mList.size
        if(size >10){
            size = 10
        }
        return size;
    }

}