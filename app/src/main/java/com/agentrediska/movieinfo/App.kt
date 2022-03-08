package com.agentrediska.movieinfo

import android.app.Application
import com.agentrediska.movieinfo.data.storage.retrofit.RetrofitStorage

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        createRetrofitStorage()
    }

    private fun createRetrofitStorage() {
        RetrofitStorage.initialize()
    }
}