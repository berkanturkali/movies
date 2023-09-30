package com.example.movies.core.navigation.args.cast

import android.os.Parcelable
import com.example.movies.core.model.moviedetails.Cast
import kotlinx.parcelize.Parcelize

@Parcelize
data class CastScreenArgs(
    val castList:List<Cast>
) : Parcelable