package com.agentrediska.movieinfo.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.movieinfo.presentation.screen.film.ListFilmViewModel

class ViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom( ListFilmViewModel::class.java) ->
                return ListFilmViewModel() as T
        }
        return modelClass as T
    }
}