package com.example.movieapplication.retrofit

class ApiUtils {
    companion object{
        val BASE_URL ="https://api.themoviedb.org/3/"

        fun getMoviesDao() :MoviesDao{
            return RetrofitClient.getClient(BASE_URL).create(MoviesDao::class.java)
        }
    }
}