package com.agentrediska.movieinfo.presentation.screen.film.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.movieinfo.R
import com.agentrediska.movieinfo.data.model.Film

class ListFilmsAdapter(private val list: List<Film>) : RecyclerView.Adapter<ListFilmHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFilmHolder {
        val view = LayoutInflater.from( parent.context)
            .inflate(R.layout.film_holder, parent, false)
        return ListFilmHolder(view)
    }

    override fun onBindViewHolder(holder: ListFilmHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}