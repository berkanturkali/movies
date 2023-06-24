package com.example.movies.core.model.movie_details

data class Movie(
    val title: String? = null,
    val image: String? = null,
    val releaseDate: String? = null,
    val tagLine: String? = null,
    val genres: List<String?>? = null,
    val score: Float? = null,
    val languages: List<String?>? = null,
    val status: String? = null,
)