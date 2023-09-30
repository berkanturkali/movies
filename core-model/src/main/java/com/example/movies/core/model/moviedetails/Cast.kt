package com.example.movies.core.model.moviedetails

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cast(
    val image: String? = null,
    val name: String? = null,
    val characterName: String? = null
) : Parcelable