package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cbagames.callbellapps.shopapps.sporyap_deneme.R
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.SearchEvent
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.CardDesignSearchviewChildCardBinding
import com.squareup.picasso.Picasso

class SearchViewChildRVAdapter (private val mContext: Context, private val mList: List<SearchEvent>)
    :RecyclerView.Adapter<SearchViewChildRVAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(design:CardDesignSearchviewChildCardBinding)
        :RecyclerView.ViewHolder(design.root){
        var design:CardDesignSearchviewChildCardBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cardDesignHolder = CardDesignSearchviewChildCardBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(cardDesignHolder)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val searchEvent = mList.get(position)
        holder.design.textViewChild.setText(searchEvent.eventType)
        Picasso.with(mContext).load(searchEvent.eventPhoto).error(R.drawable.golf_picture).into(holder.design.searchChildImage)
    }

    override fun getItemCount(): Int {
        return mList.size;
    }
}