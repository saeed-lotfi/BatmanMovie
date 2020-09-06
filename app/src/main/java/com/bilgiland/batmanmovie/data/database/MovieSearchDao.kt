package com.bilgiland.batmanmovie.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bilgiland.batmanmovie.data.model.SearchMovieModel

@Dao
interface MovieSearchDao {

    /**
     * insert all models
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(moviesList: List<SearchMovieModel>)

    /**
     * get all data
     */
    @Query("select * from SearchMovieModel")
    suspend fun getAll():List<SearchMovieModel>

    /**
     * delete all data
     */
    @Query("delete from SearchMovieModel")
    suspend fun deleteAll()

}