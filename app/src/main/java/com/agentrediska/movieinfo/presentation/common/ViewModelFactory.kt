package com.agentrediska.movieinfo.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.movieinfo.presentation.screen.film.ListFilmsViewModel

class ViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom( ListFilmsViewModel::class.java) ->
                return ListFilmsViewModel() as T
        }
        return modelClass.newInstance()
    }
}