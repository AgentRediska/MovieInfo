package com.agentrediska.movieinfo.data.storage.retrofit

import com.agentrediska.movieinfo.data.model.Film
import com.agentrediska.movieinfo.data.model.FilmList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PagingSource {

    fun getList(filmApi: FilmApi, lambda: (List<Film>) -> Unit) {
        var lastIndexOfList = 0
        filmApi.getFilmList(lastIndexOfList).enqueue(object : Callback<FilmList>{

            override fun onResponse(call: Call<FilmList>, response: Response<FilmList>) {
                val filmList = response.body()?.results
                if(filmList != null) {
                    lambda(filmList)
                }
            }

            override fun onFailure(call: Call<FilmList>, t: Throwable) {
                print("error")
            }

        })

    }}