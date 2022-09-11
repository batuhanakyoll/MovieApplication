package com.example.movieapplication.retrofit


import com.example.movieapplication.data.entity.ApiResponse

//import com.example.movieapplication.data.entity.MovieResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesDao {
    @GET("movie/upcoming?api_key=4ad43a4ac9b78df50cf1053d39d4a806")
    fun allMovies(): Call<ApiResponse>

    @GET("movie/now_playing?api_key=4ad43a4ac9b78df50cf1053d39d4a806")
    fun allNpMovies(@Query("page") page: Int )  : Call<ApiResponse>
}