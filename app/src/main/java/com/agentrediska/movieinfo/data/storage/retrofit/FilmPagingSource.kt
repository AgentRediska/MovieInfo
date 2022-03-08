package com.agentrediska.movieinfo.data.storage.retrofit

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.agentrediska.movieinfo.data.model.Film
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_INDEX = 20

class FilmPagingSource : PagingSource<Int, Film>() {

    private val retrofitStorage = RetrofitStorage.get()

    override fun getRefreshKey(state: PagingState<Int, Film>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Film> {
            return try {
                val pageIndex = params.key ?: STARTING_INDEX
                val response = retrofitStorage.getList(pageIndex)
                val nextKey =
                    if (response.isEmpty()) {
                        null
                    } else {
                        pageIndex.plus(20)
                    }
                LoadResult.Page(
                    data = response,
                    prevKey = if (pageIndex == STARTING_INDEX) null else pageIndex,
                    nextKey = nextKey
                )
            } catch (exception: IOException) {
                LoadResult.Error(exception)
            } catch (exception: HttpException) {
                LoadResult.Error(exception)
            }
        }
    }
