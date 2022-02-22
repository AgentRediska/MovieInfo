package com.agentrediska.movieinfo.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.movieinfo.data.repository.GetFilmsRepository
import com.agentrediska.movieinfo.presentation.screen.film.ListFilmsViewModel

class ViewModelFactory : ViewModelProvider.Factory {

    private val getFilmRepository = GetFilmsRepository()

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom( ListFilmsViewModel::class.java) ->
                return ListFilmsViewModel( getFilmRepository) as T
        }
        return modelClass.newInstance()
    }
}