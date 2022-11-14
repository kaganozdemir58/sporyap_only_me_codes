package com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cbagames.callbellapps.shopapps.sporyap_deneme.R
import com.cbagames.callbellapps.shopapps.sporyap_deneme.data.entity.MediaObject
import com.cbagames.callbellapps.shopapps.sporyap_deneme.databinding.CardDesignMainPageBinding
import com.cbagames.callbellapps.shopapps.sporyap_deneme.ui.viewmodel.main.MainPageViewModel
import com.squareup.picasso.Picasso

class MainPageRVAdapter(var mContext:Context, var mList:List<MediaObject>, var viewModel: MainPageViewModel)
    : RecyclerView.Adapter<MainPageRVAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(design:CardDesignMainPageBinding) : RecyclerView.ViewHolder(design.root){
        var design:CardDesignMainPageBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignMainPageBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val mediaObject = mList.get(position)

        val d = holder.design

        d.textViewEducationName.setText(mediaObject.SportName)
        d.textViewSporName.setText(mediaObject.EventName)
        d.ratingBar.rating = mediaObject.Rating.toFloat()
        d.textViewRating.setText(mediaObject.Rating.toString())
        d.textViewAdress.setText(mediaObject.LocationName)
        d.textViewTotalPerson.setText(mediaObject.TotalMemberCount.toString())
        d.textViewEventTypeName.setText(mediaObject.EventTypeName.toString())
        //Picasso.with(mContext).load(mediaObject.ProfileImage).error(R.drawable.golf_picture).into(d.imageViewProfile)

        if (mediaObject.IsLiked){
            d.imageViewLike.setImageResource(R.drawable.like_full)
        }else{
            d.imageViewLike.setImageResource(R.drawable.like_empty)
        }

       /* var adres = Uri.parse("android.resource://" + mContext.packageName + "/"+ R.raw.futbol_antrenman )

        if (mediaObject.media_url == "buz"){
            adres = Uri.parse("android.resource://" + mContext.packageName + "/"+R.raw.buz_pateni )
        }
        if (mediaObject.media_url == "golf"){
            adres = Uri.parse("android.resource://" + mContext.packageName + "/"+R.raw.golf )
        }
        if (mediaObject.media_url == "kurek"){
            adres = Uri.parse("android.resource://" + mContext.packageName + "/"+R.raw.kurek )
        }
        if (mediaObject.media_url == "yuzme"){
            adres = Uri.parse("android.resource://" + mContext.packageName + "/"+R.raw.yuzme )
        }
        if (mediaObject.media_url == "parasut"){
            adres = Uri.parse("android.resource://" + mContext.packageName + "/"+R.raw.parasut )
        }
        if (mediaObject.media_url == "ruzgar"){
            adres = Uri.parse("android.resource://" + mContext.packageName + "/"+R.raw.ruzgar_sorfu )
        }
        if (mediaObject.media_url == "tennis"){
            adres = Uri.parse("android.resource://" + mContext.packageName + "/"+R.raw.tenis )
        }


        d.videoView.setVideoURI(adres)
        d.videoView.start()
        d.videoView.setOnCompletionListener(MediaPlayer.OnCompletionListener { d.videoView.start() })*/

        d.videoView.setVideoURI((Uri.parse(mediaObject.media_url)))
        d.videoView.start()

        d.cardView.setOnClickListener {
            Toast.makeText(mContext,"Tıklandı",Toast.LENGTH_SHORT).show()
         /*   val translater = MainPageFragmentDirections.navigationTest(mediaObject=mediaObject)
            Navigation.findNavController(it).navigate(translater)*/
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}