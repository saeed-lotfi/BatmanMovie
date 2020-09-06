package com.bilgiland.batmanmovie.data.network

import com.bilgiland.batmanmovie.data.model.MovieSearchModel
import com.bilgiland.batmanmovie.utility.ConstValue.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("")
    suspend fun getBatmanMovies(
        @Query("apikey") apiKey: String = API_KEY,
        @Query("s") name: String = "batman"
    ): MovieSearchModel

}
