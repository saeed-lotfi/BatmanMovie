package com.bilgiland.batmanmovie.data.model

import com.google.gson.annotations.SerializedName

data class MovieSearchModel(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: List<Search>,
    val totalResults: String
)