package com.bilgiland.batmanmovie.data.repository

import com.bilgiland.batmanmovie.data.model.MovieSearchModel
import com.bilgiland.batmanmovie.data.model.ResultWrapper
import com.bilgiland.batmanmovie.data.model.SearchMovieModel

interface MoviesListRepoInterface {

    /**
     * get all movies from network
     */
    suspend fun getAllFromNetwork(): ResultWrapper<MovieSearchModel>

    /**
     * insert movies to database
     */
    suspend fun insertToDatabase(movies: List<SearchMovieModel>)

    /**
     * get all data from database
     */
    suspend fun getMoviesFromNDatabase(): List<SearchMovieModel>

    /**
     * delete all database entity
     */
    suspend fun deleteAll()

}