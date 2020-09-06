package com.bilgiland.batmanmovie.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bilgiland.batmanmovie.data.model.SearchModelModel

@Database(entities = [SearchModelModel::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun getMovieSearchDao(): MovieSearchDao

}