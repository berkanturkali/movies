package com.example.movies.core.network.mapper.movie_details

import com.example.movies.core.model.movie_details.Movie
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.model.movie_details.MovieDetailsResponseDTO
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MovieDetailsResponseMapper @Inject constructor(
    private val imageMapper: ImagePathMapper
) : RemoteResponseModelMapper<MovieDetailsResponseDTO, Movie> {
    override fun mapFromModel(model: MovieDetailsResponseDTO): Movie {
        return Movie(
            title = model.title?.let { mapMovieTitle(title = model.title, model.releaseDate) },
            image = imageMapper.mapPath(model.posterPath),
            releaseDate = model.releaseDate,
            tagLine = model.tagline,
            genres = model.genres?.let { list ->
                list.map { dto ->
                    dto?.name
                }
            },
            score = kotlin.run {
                val df = DecimalFormat("#.#")
                df.roundingMode = RoundingMode.FLOOR
                df.format(model.voteAverage)
                    .toFloat() / 10
            },
            languages = model.spokenLanguages?.map {
                it?.iso6391?.uppercase()
            },
            status = model.status?.first()
                .toString()
        )
    }

    private fun mapMovieTitle(title: String, date: String?): String {
        return date?.let {
            val year = extractYearFromGivenDate(date)
            "$title ($year)"
        } ?: title
    }

    private fun extractYearFromGivenDate(dateAsString: String): String? {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return try {
            val date = simpleDateFormat.parse(dateAsString)
            val calender = Calendar.getInstance()
            calender.time = date ?: return null
            calender.get(Calendar.YEAR)
                .toString()
        } catch (e: Exception) {
            null
        }
    }
}