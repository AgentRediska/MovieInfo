package com.agentrediska.movieinfo.data.model

import com.google.gson.annotations.SerializedName

data class FilmList(
    @SerializedName("results")
    val results: List<Film>)
