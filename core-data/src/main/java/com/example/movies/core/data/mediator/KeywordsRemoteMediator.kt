package com.example.movies.core.data.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.movies.core.cache.dao.KeywordsDao
import com.example.movies.core.cache.dao.RemoteKeyDao
import com.example.movies.core.cache.db.keywords.KeywordsDatabase
import com.example.movies.core.cache.model.KeywordEntity
import com.example.movies.core.cache.model.RemoteKey
import com.example.movies.core.data.mapper.KeywordRemoteToEntityMapper
import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalPagingApi::class)
class KeywordsRemoteMediator constructor(
    private val query: String?,
    private val keywordMapper: KeywordRemoteToEntityMapper,
    private val keywordsDao: KeywordsDao,
    private val remoteKeyDao: RemoteKeyDao,
    private val keywordsDatabase: KeywordsDatabase,
    private val remoteDataSource: SearchRemoteDataSource
) : RemoteMediator<Int, KeywordEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, KeywordEntity>
    ): MediatorResult {


        try {

            val page: Int = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextKey?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevKey = remoteKeys?.prevKey

                    prevKey ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextKey = remoteKeys?.nextKey

                    nextKey ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                }
            }

            val keywords = remoteDataSource.fetchKeywords(query = query, page = page)

            val endOfPaginationReached = keywords.isEmpty()

            keywordsDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    remoteKeyDao.clearRemoteKeys()
                    keywordsDao.clearAll()
                }
                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (endOfPaginationReached) null else page + 1
                val remoteKeys = keywords.map {
                    it.id?.let { id ->
                        RemoteKey(
                            keywordId = id, prevKey = prevKey, currentPage = page,
                            nextKey = nextKey,
                        )
                    } ?: return@withTransaction
                }
                remoteKeyDao.insertAll(remoteKeys)
                keywordsDao.insertAll(keywordMapper.mapFromModelList(keywords))
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)


        } catch (e: Exception) {
            if (e is IOException || e is HttpException) {
                return MediatorResult.Error(e)
            } else {
                return MediatorResult.Error(Error("Something went wrong."))
            }
        }

    }

    override suspend fun initialize(): InitializeAction {
        val cacheTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)

        return if (System.currentTimeMillis() - (remoteKeyDao.getCreationTime() ?: 0) < cacheTimeout) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, KeywordEntity>): RemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                remoteKeyDao.getRemoteKeyByKeywordId(id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, KeywordEntity>): RemoteKey? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()
            ?.let { keyword ->
                keyword.id?.let { id ->
                    remoteKeyDao.getRemoteKeyByKeywordId(id)
                }
            }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, KeywordEntity>): RemoteKey? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.id?.let { id ->
            remoteKeyDao.getRemoteKeyByKeywordId(id)
        }
    }
}