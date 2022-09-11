package com.example.movieapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movieapplication.R
import com.example.movieapplication.data.entity.Movie
import com.example.movieapplication.data.entity.MovieNowPlaying
import com.example.movieapplication.databinding.FragmentMainBinding
import com.example.movieapplication.ui.adapter.MovieAdapter
import com.example.movieapplication.ui.adapter.SliderAdapter
import com.example.movieapplication.viewmodel.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main ,container, false)

        viewModel.npList.observe(viewLifecycleOwner){
            val adapter2 = SliderAdapter(requireContext(),it,viewModel)
            binding.sliderAdapter =adapter2
        }


       viewModel.movieList.observe(viewLifecycleOwner){
           val adapter = MovieAdapter(requireContext(),it,viewModel)
           binding.movieAdapter =adapter

       }

        binding.swipe.setOnClickListener{

        }

            return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

}