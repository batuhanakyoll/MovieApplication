package com.example.movieapplication.di

import com.example.movieapplication.data.repo.MovieDaoRepo
import com.example.movieapplication.retrofit.ApiUtils
import com.example.movieapplication.retrofit.MoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMovieDaoRepo(mdao:MoviesDao) : MovieDaoRepo{
        return  MovieDaoRepo(mdao) // var mrepo = MovieDaoRepo
    }
    @Provides
    @Singleton
    fun provideMoviesDao(): MoviesDao{
        return  ApiUtils.getMoviesDao()
    }

}