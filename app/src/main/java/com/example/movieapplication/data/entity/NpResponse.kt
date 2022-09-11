package com.example.movieapplication.data.entity

import com.google.gson.annotations.SerializedName

data class NpResponse(@SerializedName("dates") val dates : DatesResponse,
                      @SerializedName("page") val page : Int,
                      @SerializedName("results") val resultsNP : List<MovieNowPlaying>,
                      @SerializedName("total_pages") val total_pages : Int,
                      @SerializedName("total_result") val total_result : Int,) {


}