package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cbagames.callbellapps.shopapps.sporyap_deneme.R
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.OpenedEvent
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.CardDesignAllOpenedEventBinding
import com.squareup.picasso.Picasso


class AllOpenedRVAdapter(private val mContext: Context, private val mList: List<OpenedEvent>)
    : RecyclerView.Adapter<AllOpenedRVAdapter.CardDesignHolder>() {


    inner class CardDesignHolder(design: CardDesignAllOpenedEventBinding)
        : RecyclerView.ViewHolder(design.root){
        var design: CardDesignAllOpenedEventBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cardDesignHolder = CardDesignAllOpenedEventBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(cardDesignHolder)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val o = mList.get(position)

        holder.design.textViewChild.setText(o.title)
        Picasso.with(mContext).load(o.eventPhoto).error(R.drawable.golf_picture)
            .into(holder.design.Image)



    }

    override fun getItemCount(): Int {
        return mList.size;
    }


}