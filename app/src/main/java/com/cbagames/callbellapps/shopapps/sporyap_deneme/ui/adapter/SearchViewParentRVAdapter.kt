package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.SearchEventCategory
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.CardDesignSearchviewParentCardBinding

class SearchViewParentRVAdapter(private val mContext: Context
                                , private val mList: List<SearchEventCategory>)
    :RecyclerView.Adapter<SearchViewParentRVAdapter.CardDesignHolder>(){

    inner class CardDesignHolder (design:CardDesignSearchviewParentCardBinding)
        :RecyclerView.ViewHolder(design.root){

        var design:CardDesignSearchviewParentCardBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cardDesignHolder = CardDesignSearchviewParentCardBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(cardDesignHolder)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val eventCategory = mList.get(position)
        holder.design.textViewGroupName.setText(eventCategory.categoryTitle)

        val adapter = SearchViewChildRVAdapter(mContext,eventCategory.searchEventList)
        //holder.design.rvSearchChilds.layoutManager = StaggeredGridLayoutManager(mContext)
        holder.design.rvSearchChilds.adapter = adapter

    }

    override fun getItemCount(): Int {
        return mList.size
    }


}