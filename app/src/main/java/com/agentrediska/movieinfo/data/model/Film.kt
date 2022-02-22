package com.agentrediska.movieinfo.data.model

import com.google.gson.annotations.SerializedName

data class Film(
    @SerializedName("display_title")
    val title: String,

    @SerializedName("summary_short")
    val summaryShort: String,

    @SerializedName("multimedia")
    val filmMultimedia: FilmMultimedia,
)

data class FilmMultimedia(
    @SerializedName("src")
    val src: String
)