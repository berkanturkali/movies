package com.example.movies.core.network.mapper.moviedetails

import com.example.movies.core.model.moviedetails.Cast
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.model.credit.CastDTO
import javax.inject.Inject

class CastResponseMapper @Inject constructor(
    private val imageMapper: ImagePathMapper,
) : RemoteResponseModelMapper<CastDTO, Cast> {
    override fun mapFromModel(model: CastDTO): Cast {
        return Cast(
            image = imageMapper.mapPath(model.profilePath),
            name = model.name,
            characterName = mapCharacterName(model.character)
        )
    }

    private fun mapCharacterName(characterName: String?): String? {
        return characterName?.let { name ->
            val slashPattern = "\\s*/\\s*".toRegex()
            val voicePattern = "\\(([^)]+)\\)".toRegex()

            val modifiedName = name.replace(slashPattern, "\n")
                .replace(voicePattern, "\n$0")
                .trim()
            modifiedName
        }
    }
}