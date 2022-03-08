package com.agentrediska.movieinfo.presentation.screen.film

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.agentrediska.movieinfo.data.storage.retrofit.FilmPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListFilmsViewModel : ViewModel() {

     fun hideSplash( callback: () -> Unit) {
         viewModelScope.launch(Dispatchers.Unconfined) {
             callback()
         }

     }
    val filmList = Pager(PagingConfig(pageSize = 10)) {
        FilmPagingSource()
    }.flow.cachedIn(viewModelScope)

}