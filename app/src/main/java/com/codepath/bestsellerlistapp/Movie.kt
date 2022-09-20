package com.codepath.bestsellerlistapp

import com.google.gson.annotations.SerializedName
import org.json.JSONArray

/**
 * The Model for storing a single book from the NY Times API
 *
 * SerializedName tags MUST match the JSON response for the
 * object to correctly parse with the gson library.
 */

data class Movie(val movieId: Int, private val posterPath: String, val title: String, val overview: String,){
    val posterImageUrl = "https://image.tmdb.org/t/p/w500/$posterPath"
    companion object {
        fun convertJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()){
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")

                    )
                )
            }
            return movies

        }
    }
}