package com.agentrediska.movieinfo.data.storage.retrofit

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.agentrediska.movieinfo.data.model.Film
import com.agentrediska.movieinfo.data.model.FilmList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

private const val STARTING_INDEX = 0

class FilmPagingSource(
    private val filmApi: FilmApi,
    private val lambda: (List<Film>) -> Unit
) : PagingSource<Int, Film>() {

   private fun getList(lastIndexOfList: Int): List<Film> {
       val listOfFilm = mutableListOf<Film>()
        filmApi.getFilmList(lastIndexOfList).enqueue(object : Callback<FilmList>{

            override fun onResponse(call: Call<FilmList>, response: Response<FilmList>) {
                val localeFilmList = response.body()?.results
                if(localeFilmList != null) {
                 //   lambda(filmList)
                    listOfFilm.addAll(localeFilmList)
                }
            }

            override fun onFailure(call: Call<FilmList>, t: Throwable) {
                print("error")
            }

        })
        return listOfFilm
    }

    override fun getRefreshKey(state: PagingState<Int, Film>): Int? {
        return state.anchorPosition.let {
            state.anchorPosition?.plus(10)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Film> {
        val index = params.key ?: STARTING_INDEX
        return try {
            val response = getList(index)
            val nextKey = if (response.isEmpty()) {
                null
            } else {
                index + 10
            }
            LoadResult.Page(
                data = response,
                prevKey = if (index == STARTING_INDEX) null else index,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }

        }
    }
