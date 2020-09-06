package com.bilgiland.batmanmovie.ui.movielist

/**
 * function of movie list
 */
interface ViewMovieListFragmentInterface {

    /**
     * initialize the object
     */
    fun initObj()

    /**
     * get Data
     * At first will try network and then try the database to get data
     */
    fun getData()


}