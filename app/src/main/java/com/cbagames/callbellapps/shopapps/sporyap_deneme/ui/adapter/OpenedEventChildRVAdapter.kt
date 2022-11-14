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
import com.squareup.picasso.Picasso

class OpenedEventChildRVAdapter (private val mContext: Context, private val mList: List<OpenedEvent>)
    : RecyclerView.Adapter<OpenedEventChildRVAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(design: CardDesignOpenedEventChild1Binding)
        : RecyclerView.ViewHolder(design.root){
        var design: CardDesignOpenedEventChild1Binding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cardDesignHolder = CardDesignOpenedEventChild1Binding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(cardDesignHolder)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {

        val listObjct = mList.get(position)

        holder.design.textViewChild.setText(listObjct.title  )
        Picasso.with(mContext).load(listObjct.eventPhoto).error(R.drawable.golf_picture)
            .into(holder.design.searchChildImage)
        holder.design.cardView2outSide.setCardBackgroundColor(Color.parseColor(randomColorSelect()))

    }

    override fun getItemCount(): Int {
        var size = mList.size
        if(size >10){
            size = 10
        }
        return size;
    }

    // random color for popular picture circle
    var colorSelectPos:Int =4;
    fun randomColorNumberSelect():Int{
        var randomNumber:Int = (1..7).random()
        if (randomNumber == colorSelectPos){
            if (randomNumber == 1 ){
                randomNumber += (1..6).random()
            }else{
                randomNumber -= 1
            }
        }
        colorSelectPos = randomNumber
        Log.e("random",colorSelectPos.toString())
        return colorSelectPos
    }
    fun randomColorSelect():String{
        var color = "#F5CA67"
        when (randomColorNumberSelect()){
            1 -> color = "#F5CA67"
            2 -> color = "#0DD3E9"
            3 -> color = "#DDF17E"
            4 -> color = "#F11E49"
            5 -> color = "#2EA154"
            6 -> color = "#EFE663"
            7 -> color = "#66C46C"
        }
        return color
    }
}