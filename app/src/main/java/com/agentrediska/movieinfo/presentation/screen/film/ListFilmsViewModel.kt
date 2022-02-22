package com.agentrediska.movieinfo.presentation.screen.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agentrediska.movieinfo.data.model.Film
import com.agentrediska.movieinfo.data.model.FilmList
import com.agentrediska.movieinfo.data.repository.FilmRepository
import com.agentrediska.movieinfo.data.repository.GetFilmsRepository
import com.agentrediska.movieinfo.data.storage.retrofit.FilmApi

class ListFilmsViewModel(
    private val filmRepository: FilmRepository
): ViewModel() {

    private var _splashVisibleLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val splashVisibleLiveData: LiveData<Boolean> = _splashVisibleLiveData
    private var _filmListLiveData: MutableLiveData<List<Film>> = MutableLiveData()
    val filmListLiveData: LiveData<List<Film>> = _filmListLiveData

    fun getFilmList(film: FilmApi) {
        val lambda = { list: List<Film> ->
            _filmListLiveData.value = list
            if(splashVisibleLiveData.value != false) { _splashVisibleLiveData.value = false }
        }
        filmRepository.getFilmList(film, lambda)
    }

}