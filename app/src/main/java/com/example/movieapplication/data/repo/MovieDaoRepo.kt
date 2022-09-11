package com.example.movieapplication.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.movieapplication.data.entity.ApiResponse
import com.example.movieapplication.data.entity.Movie
import com.example.movieapplication.data.entity.MovieNowPlaying
import com.example.movieapplication.data.entity.NpResponse
import com.example.movieapplication.retrofit.MoviesDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Dao : Database Acces
class MovieDaoRepo(var mdao:MoviesDao ) {
    var movieList: MutableLiveData<List<Movie>>
    var npList: MutableLiveData<List<MovieNowPlaying>>

    init {
        movieList = MutableLiveData()
        npList = MutableLiveData()
    }

    fun getMovies() : MutableLiveData<List<Movie>> {
        return  movieList
    }

    fun getNPMovie() : MutableLiveData<List<MovieNowPlaying>> {
        return  npList
    }


    fun getAllMovie(){

        mdao.allMovies().enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {

                val list = response.body()!!.result
                movieList.value=list

            }
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

            }
        })



    }
    fun getAllNp(){
        mdao.allNpMovies(5).enqueue(object: Callback<NpResponse>{
            override fun onResponse(call: Call<NpResponse>, response: Response<NpResponse>) {
                println("1111111"+response.body())
                val listNP = response.body()!!.resultsNP
                npList.value=listNP
            }

            override fun onFailure(call: Call<NpResponse>, t: Throwable) {

            }
        } )
    }
}

