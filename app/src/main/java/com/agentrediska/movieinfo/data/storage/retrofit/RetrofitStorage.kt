package com.agentrediska.movieinfo.data.storage.retrofit

import com.agentrediska.movieinfo.data.model.Film
import com.agentrediska.movieinfo.data.model.FilmList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalStateException

class RetrofitStorage private constructor() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.nytimes.com/svc/movies/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val filmApi = retrofit.create(FilmApi::class.java)


    suspend fun getList(lastIndex: Int): List<Film> {

        val listOfFilm = mutableListOf<Film>()
        /*filmApi.getFilmList(lastIndex).enqueue(object : Callback<FilmList> {

            override fun onResponse(call: Call<FilmList>, response: Response<FilmList>) {
                val localeFilmList = response.body()?.results
                if(localeFilmList != null) {
                    listOfFilm.addAll(localeFilmList)
                }
            }

            override fun onFailure(call: Call<FilmList>, t: Throwable) {
                print("error")
            }

        })*/
        return filmApi.getFilmList(lastIndex).results
    }

    companion object {
        private var INSTANCE: RetrofitStorage? = null

        fun initialize() {
            if( INSTANCE == null) {
                INSTANCE = RetrofitStorage()
            }
        }

        fun get(): RetrofitStorage {
            return INSTANCE ?:
            throw IllegalStateException("Retrofit storage must be initialized!")
        }
    }
}