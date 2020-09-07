package com.bilgiland.batmanmovie.ui.movielist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bilgiland.batmanmovie.data.model.MovieSearchModel
import com.bilgiland.batmanmovie.data.model.ResultWrapper
import com.bilgiland.batmanmovie.data.model.SearchMovieModel
import com.bilgiland.batmanmovie.data.repository.MoviesListRepo

class MovieListVieModel @ViewModelInject constructor(private val repository: MoviesListRepo) :
    ViewModel() {

    // show error
    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean>
        get() = _error

    // get movies list
    private val _movies = MutableLiveData<List<SearchMovieModel>>()
    val movies: LiveData<List<SearchMovieModel>>
        get() = _movies


    suspend fun fetchData() {
        when (val result = repository.getAllFromNetwork()) {
            is ResultWrapper.Success -> showSuccess(result.value)
            is ResultWrapper.NetworkError -> getFromDataBase()
        }
    }

    private suspend fun showSuccess(value: MovieSearchModel) {
        if (value.response == "True") {
            _movies.postValue(value.searchMovieModels)
        } else {
            getFromDataBase()
        }
    }

    // get data from
    private suspend fun getFromDataBase() {
    //    if (repository.getMoviesFromNDatabase().isEmpty())
            showError()
    }

    // set error sas true
    private fun showError() =
        _error.postValue(true)


}