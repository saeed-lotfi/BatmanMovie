package com.bilgiland.batmanmovie.data.repository

import com.bilgiland.batmanmovie.data.model.MovieModel
import com.bilgiland.batmanmovie.data.model.ResultWrapper
import com.bilgiland.batmanmovie.data.network.ApiService
import com.bilgiland.batmanmovie.data.network.safeApiCall
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(private val api: ApiService) :
    MovieDetailRepositoryInterface {

    override suspend fun getMovieDetail(movieId: String): ResultWrapper<MovieModel> {
        return safeApiCall(Dispatchers.Main) {
            api.getMovieDetail(movieId = movieId)
        }
    }

}

