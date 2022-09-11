package com.example.movieapplication.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    @SerializedName("backdrop_path") val backdropPath: String,
                   @SerializedName("genre_ids") val genreIDS: List<Long>,
                   @SerializedName("original_language") val originalLanguage: String,
                   @SerializedName("original_title")  val originalTitle: String,
                   @SerializedName("popularity") val popularity: Double,
                   @SerializedName("video")  val video: Boolean,
                   @SerializedName("vote_average") val voteAverage: Double,
                   @SerializedName("vote_count")  val voteCount: Long,
                    @SerializedName("id") var id : Long,
                 @SerializedName("title") var title:String,
                 @SerializedName("poster_path") var poster: String,
                 @SerializedName("overview") var descirpiton: String,
                 @SerializedName("release_date") var release : String) :Serializable {
}