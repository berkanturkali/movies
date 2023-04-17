package com.example.movies.core.cache.mapper.base


/**
 * Mapper that maps entity models into ui models.
 */
interface EntityModelMapper<E, D> {

    fun mapFromEntity(entity: E): D

    fun mapFromEntityList(entityList: List<E>): List<D> {
        return entityList.map(::mapFromEntity)
    }
}