package com.bilgiland.batmanmovie.data.repository

import com.bilgiland.batmanmovie.data.database.MovieSearchDao
import com.bilgiland.batmanmovie.data.model.MovieSearchModel
import com.bilgiland.batmanmovie.data.model.ResultWrapper
import com.bilgiland.batmanmovie.data.model.SearchMovieModel
import com.bilgiland.batmanmovie.data.network.ApiService
import com.bilgiland.batmanmovie.data.network.safeApiCall
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MoviesListRepo @Inject constructor(
    private val movieSearchDao: MovieSearchDao,
    private val api: ApiService
) : MoviesListRepoInterface {

    override suspend fun getAllFromNetwork(): ResultWrapper<MovieSearchModel> {
        return safeApiCall(Dispatchers.IO)
        {
            api.getBatmanMovies()
        }
    }

    override suspend fun insertToDatabase(movies: List<SearchMovieModel>) {
        movieSearchDao.insertAll(movies)
    }

    override suspend fun getMoviesFromNDatabase(): List<SearchMovieModel> =
         movieSearchDao.getAll()

    override suspend fun deleteAll() {
        movieSearchDao.deleteAll()
    }


}