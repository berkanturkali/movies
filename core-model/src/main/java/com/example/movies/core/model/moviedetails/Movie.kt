package com.example.movies.core.model.moviedetails

data class Movie(
    val title: String? = null,
    val image: String? = null,
    val releaseDate: String? = null,
    val tagLine: String? = null,
    val genres: List<String?>? = null,
    val score: Float? = null,
    val languages: List<String?>? = null,
    val status: String? = null,
    val revenue:String? = null,
    val overview:String? = null,
)