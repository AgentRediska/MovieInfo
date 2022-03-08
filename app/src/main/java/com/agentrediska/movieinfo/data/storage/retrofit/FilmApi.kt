package com.agentrediska.movieinfo.data.storage.retrofit

import com.agentrediska.movieinfo.data.model.FilmList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FilmApi {

    @GET("./reviews/all.json?api-key=pGjIhbOT4ZTKMGYC3XozImtMgawHi7FJ")
    @Headers("Content-Type: application/json")
   suspend fun getFilmList( @Query("offset") size: Int) : FilmList
}