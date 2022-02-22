package com.agentrediska.movieinfo.data.repository

import com.agentrediska.movieinfo.data.model.Film
import com.agentrediska.movieinfo.data.storage.retrofit.FilmApi
import com.agentrediska.movieinfo.data.storage.retrofit.PagingSource

interface FilmRepository {

    fun getFilmList(filmApi: FilmApi, lambda: (List<Film>) -> Unit)
}