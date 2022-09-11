package com.example.movieapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.data.entity.Movie
import com.example.movieapplication.databinding.CardTasarimBinding
import com.example.movieapplication.ui.fragment.MainFragmentDirections
import com.example.movieapplication.viewmodel.MainFragmentViewModel
import com.squareup.picasso.Picasso

class MovieAdapter(var mContex : Context , var movieList:List<Movie> , var viewModel : MainFragmentViewModel)
    : RecyclerView.Adapter<MovieAdapter.CardHolder>() {
    inner class CardHolder(binding: CardTasarimBinding): RecyclerView.ViewHolder(binding.root){
        var binding: CardTasarimBinding
        init {
            this.binding= binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val layoutInflater = LayoutInflater.from(mContex)
        val binding = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val movie =movieList.get(position)
        val t= holder.binding
        t.textViewDate.text=movie.release
        t.textViewTitle.text=movie.title
        t.textViewDescription.text=movie.descirpiton
        val url = "https://image.tmdb.org/t/p/w500"
        val image_url = movie.poster
        val last_url = "${url}${image_url}"
        Picasso.get().load(last_url).into(t.imageView)

        t.cardViewFilm.setOnClickListener {
            val gecis = MainFragmentDirections.dGo(movie = movie)
            Navigation.findNavController(it).navigate(gecis) }

    }


    override fun getItemCount(): Int {
       return movieList.size
    }

}