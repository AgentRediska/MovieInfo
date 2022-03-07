package com.agentrediska.movieinfo

import android.app.Application
import com.agentrediska.movieinfo.data.storage.retrofit.FilmApi
import com.agentrediska.movieinfo.data.storage.retrofit.RetrofitStorage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        createRetrofitStorage()
    }

    private fun createRetrofitStorage() {
        RetrofitStorage.initialize()
    }
}