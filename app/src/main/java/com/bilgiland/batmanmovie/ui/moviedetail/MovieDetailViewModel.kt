package com.bilgiland.batmanmovie.ui.moviedetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bilgiland.batmanmovie.data.model.MovieModel
import com.bilgiland.batmanmovie.data.model.ResultWrapper
import com.bilgiland.batmanmovie.data.repository.MovieDetailRepository

class MovieDetailViewModel @ViewModelInject constructor(private val repository: MovieDetailRepository) :
    ViewModel() {


    // show error
    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean>
        get() = _error

    // get movies list
    private val _movie = MutableLiveData<MovieModel>()
    val movie: LiveData<MovieModel>
        get() = _movie


    suspend fun fetchData(movieId: String) {
        when (val result = repository.getMovieDetail(movieId)) {
            is ResultWrapper.Success -> showSuccess(result.value)
            is ResultWrapper.NetworkError -> setError()
        }
    }

    private fun showSuccess(models: MovieModel) {
        if (models.response == "True")
            _movie.postValue(models)
        else
            setError()
    }

    private fun setError() =
        _error.postValue(true)

}