package com.bilgiland.batmanmovie.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bilgiland.batmanmovie.data.model.SearchModelModel

@Dao
interface MovieSearchDao {

    /**
     * insert all models
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(moviesList: List<SearchModelModel>)

    /**
     * get all data
     */
    @Query("select * from SearchModelModel")
    suspend fun getAll():List<SearchModelModel>

    /**
     * delete all data
     */
    @Query("delete from SearchModelModel")
    suspend fun deleteAll()

}