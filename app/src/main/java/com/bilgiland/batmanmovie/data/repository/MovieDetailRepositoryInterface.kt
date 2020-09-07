package com.bilgiland.batmanmovie.data.repository

import com.bilgiland.batmanmovie.data.model.MovieModel
import com.bilgiland.batmanmovie.data.model.MovieSearchModel
import com.bilgiland.batmanmovie.data.model.ResultWrapper

/**
 * function if movie detail fragment
 */
interface MovieDetailRepositoryInterface{

    /**
     * get detail of movie
     */
    suspend fun getMovieDetail(movieId:String): ResultWrapper<MovieModel>
}