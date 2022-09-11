package com.example.movieapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentMainBinding
import com.example.movieapplication.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

        private lateinit var  binding: FragmentMovieDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding =FragmentMovieDetailBinding.inflate(inflater, container, false)


        val bundle : MovieDetailFragmentArgs by navArgs()
        val getMovie = bundle.movie

        binding.DetailsTitleTextView.text=getMovie.title
        binding.detailsDateTextview.text=getMovie.release
        binding.rateTextView.text=getMovie.voteAverage.toString()
        binding.descTextView.text=getMovie.descirpiton

        return binding.root
    }

}