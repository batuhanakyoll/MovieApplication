package com.example.movieapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.data.entity.MovieNowPlaying
import com.example.movieapplication.databinding.CardTasarimBinding
import com.example.movieapplication.databinding.SliderCardBinding
import com.example.movieapplication.viewmodel.MainFragmentViewModel
import com.squareup.picasso.Picasso

class SliderAdapter (var mContex : Context,
                     var mNowPlayingList:List<MovieNowPlaying>,
                     var viewModel : MainFragmentViewModel) :RecyclerView.Adapter<SliderAdapter.Holder>() {

    inner class Holder(binding: SliderCardBinding) : RecyclerView.ViewHolder(binding.root){
        var binding: SliderCardBinding

        init {
            this.binding=binding//shadowing
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val layoutInflater = LayoutInflater.from(mContex)
           val binding = SliderCardBinding.inflate(layoutInflater,parent,false)
           return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val mNowPlaying = mNowPlayingList.get(position)
        val t = holder.binding
        val url = "https://image.tmdb.org/t/p/w500"
        val imageurl = mNowPlaying.slider_poster
        val lasturl = "${url}${imageurl}"
        Picasso.get().load(lasturl).into(t.imageView3)
        t.sliderTittleTextview.text=mNowPlaying.slider_title
        t.textviewSliderDesc.text=mNowPlaying.slider_descirpiton

    }

    override fun getItemCount(): Int {
      return  mNowPlayingList.size
    }
}