package com.example.movies.core.data.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.movies.core.cache.dao.KeywordsDao
import com.example.movies.core.cache.model.KeywordEntity
import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource

@OptIn(ExperimentalPagingApi::class)
class KeywordsRemoteMediator constructor(
    private val dao: KeywordsDao,
    private val query: String,
    private val remoteDataSource: SearchRemoteDataSource
) : RemoteMediator<Int, KeywordEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, KeywordEntity>
    ): MediatorResult {

//        return try {
//
//            val loadKey = when (loadType) {
//                LoadType.REFRESH -> {
//                    null
//                }
//                LoadType.PREPEND -> {
//                    return  MediatorResult.Success(endOfPaginationReached = true)
//                }
//                LoadType.APPEND -> {
//                    val lastItem = state.lastItemOrNull()
//                    if(lastItem == null){
//                        return  MediatorResult.Success(endOfPaginationReached = true)
//                    }
//                    lastItem.id
//                }
//            }
//
//            val response = remoteDataSource.fetchKeywords(query = query,)
//
//        } catch (e: Exception) {
//
//        }
//
//    }
        TODO( will be implemented )
}