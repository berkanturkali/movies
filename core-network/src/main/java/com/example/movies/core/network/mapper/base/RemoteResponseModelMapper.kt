package com.example.movies.core.network.mapper.base

/**
 * Mapper that maps out remote models into ui models.
 */
interface RemoteResponseModelMapper<M, D> {

    fun mapFromModel(model: M): D

    fun mapFromModelList(modelList: List<M>): List<D> {
        return modelList.map(::mapFromModel)
    }
}