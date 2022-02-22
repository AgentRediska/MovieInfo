package com.agentrediska.movieinfo.data.repository

import com.agentrediska.movieinfo.data.model.Film
import com.agentrediska.movieinfo.data.storage.retrofit.FilmApi
import com.agentrediska.movieinfo.data.storage.retrofit.PagingSource


class GetFilmsRepository {

    private val pagingSource = PagingSource()

    fun getFilmList(filmApi: FilmApi, lambda: (List<Film>) -> Unit) {
        pagingSource.getList(filmApi, lambda)
    }
}