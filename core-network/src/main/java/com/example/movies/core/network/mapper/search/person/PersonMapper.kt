package com.example.movies.core.network.mapper.search.person

import com.example.movies.core.model.search.person.Person
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.model.search.people.PersonDTO
import javax.inject.Inject

class PersonMapper @Inject constructor(
    private val imagePathMapper: ImagePathMapper
) : RemoteResponseModelMapper<PersonDTO, Person> {
    override fun mapFromModel(model: PersonDTO): Person {
        return Person(
            id = model.id,
            name = model.name,
            path = imagePathMapper.mapPath(model.profilePath)
        )
    }
}