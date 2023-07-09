package com.example.movies.core.cache.mapper.base


/**
 * Mapper that maps ui models into entity models.
 */
interface ModelToEntityMapper<E, M> {

    fun mapToEntity(model: M): E
}