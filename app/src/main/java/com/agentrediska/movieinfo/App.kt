package com.agentrediska.movieinfo

import android.app.Application
import com.agentrediska.movieinfo.data.storage.retrofit.FilmApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    lateinit var filmApi: FilmApi

    override fun onCreate() {
        super.onCreate()

        configureRetrofit()
    }

    private fun configureRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/movies/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        filmApi = retrofit.create(FilmApi::class.java)
    }
}