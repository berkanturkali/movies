package com.example.movies.core.network.mapper

import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject

class ScoreMapper @Inject constructor() {

    fun mapVoteAverageToScore(voteAverage: Double?): Float? {
        return voteAverage?.let {
            val df = DecimalFormat("#.#")
            df.roundingMode = RoundingMode.FLOOR
            df.format(voteAverage)
                .toFloat() / 10
        }
    }
}