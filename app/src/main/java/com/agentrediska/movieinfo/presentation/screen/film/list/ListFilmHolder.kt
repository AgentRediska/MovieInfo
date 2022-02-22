package com.agentrediska.movieinfo.presentation.screen.film.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.movieinfo.data.model.Film
import com.agentrediska.movieinfo.databinding.FilmHolderBinding

class ListFilmHolder(item: View) : RecyclerView.ViewHolder(item) {

    private val binding = FilmHolderBinding.bind(item)

    fun bind(film: Film) {
        //binding
    }
}