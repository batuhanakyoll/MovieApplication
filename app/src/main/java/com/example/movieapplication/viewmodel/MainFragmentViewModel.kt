package com.example.movieapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapplication.data.entity.Movie
import com.example.movieapplication.data.entity.MovieNowPlaying
import com.example.movieapplication.data.repo.MovieDaoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(var mrepo:MovieDaoRepo) :ViewModel() {

    var movieList = MutableLiveData<List<Movie>>()
    var npList = MutableLiveData<List<MovieNowPlaying>>()
    init {
        allMovie()
        allNpMovie()
        npList = mrepo.getNPMovie()
        movieList = mrepo.getMovies()
         }

    fun allMovie(){
        mrepo.getAllMovie()
                             }

    fun allNpMovie(){
        mrepo.getAllNp()
    }
}