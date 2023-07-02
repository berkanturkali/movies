package com.example.movies.feature.details.movie.usecases

import androidx.compose.ui.graphics.Color
import timber.log.Timber
import javax.inject.Inject

class CalculateColorCodeFromScoreUseCase @Inject constructor() {

    operator fun invoke(score: Float?): Color? {
        return score?.let {
            val red = (255 - (score * 255)) * 2
            val green = (score * 255 * 2)
            val blue = 0f
            Timber.d("$red $green $blue")
            return Color(minOf(255, red.toInt()), minOf(255,green.toInt()), blue.toInt())
        }
    }
}