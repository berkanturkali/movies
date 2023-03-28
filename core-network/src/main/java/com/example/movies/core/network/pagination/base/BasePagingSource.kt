package com.example.movies.core.network.pagination.base

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movies.core.network.model.base.BaseDTO
import retrofit2.HttpException
import java.io.IOException

private const val MAX_PAGE = 1000

abstract class BasePagingSource<T : BaseDTO> : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val page = params.key ?: 1
        return try {
            val response = apiFunc(page)
            val prevKey = if (page == 1) null else page - 1
            val nextKey = if (response.isEmpty() || page == MAX_PAGE) {
                null
            } else {
                page + 1
            }

            LoadResult.Page(
                data = response,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            if (e is IOException || e is HttpException) {
                LoadResult.Error(e)
            } else {
                e.printStackTrace()
                LoadResult.Error(Error("Something went wrong"))
            }
        }
    }

    abstract suspend fun apiFunc(page: Int): List<T>
}