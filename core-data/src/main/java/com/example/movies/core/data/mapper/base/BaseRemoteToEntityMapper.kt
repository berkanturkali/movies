package com.example.movies.core.data.mapper.base

interface BaseRemoteToEntityMapper<M, E> {

    fun mapFromModel(model: M): E

    fun mapFromModelList(modelList: List<M>): List<E> {
        return modelList.map(::mapFromModel)
    }
}