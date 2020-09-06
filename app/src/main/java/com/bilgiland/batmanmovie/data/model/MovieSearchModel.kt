package com.bilgiland.batmanmovie.data.model

import com.google.gson.annotations.SerializedName

data class MovieSearchModel(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val searchModelModels: List<SearchModelModel>,
    val totalResults: String
)