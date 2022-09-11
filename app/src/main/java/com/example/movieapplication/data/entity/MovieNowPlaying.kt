package com.example.movieapplication.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieNowPlaying(@SerializedName("id") var slider_id : String,
                           @SerializedName("title") var slider_title:String,
                           @SerializedName("poster_path") var slider_poster: String,
                           @SerializedName("overview") var slider_descirpiton: String,
                          ) : Serializable {




}