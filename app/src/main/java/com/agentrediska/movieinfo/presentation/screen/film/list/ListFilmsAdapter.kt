package com.agentrediska.movieinfo.presentation.screen.film.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.agentrediska.movieinfo.R
import com.agentrediska.movieinfo.data.model.Film

class ListFilmsAdapter : PagingDataAdapter<Film,ListFilmHolder>(FilmDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFilmHolder {
        val view = LayoutInflater.from( parent.context)
            .inflate(R.layout.film_holder, parent, false)
        return ListFilmHolder(view)
    }

    override fun onBindViewHolder(holder: ListFilmHolder, position: Int) {
        holder.bind(film = getItem(position))
    }

    private object FilmDiffItemCallback : DiffUtil.ItemCallback<Film>() {

        override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem == newItem
        }
    }
}