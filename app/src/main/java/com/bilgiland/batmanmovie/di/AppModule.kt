package com.bilgiland.batmanmovie.di

import android.content.Context
import androidx.room.Room
import com.bilgiland.batmanmovie.data.database.MovieDatabase
import com.bilgiland.batmanmovie.utility.ConstValue.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun createDatabase(@ApplicationContext context: Context): MovieDatabase =
        Room.databaseBuilder(context, MovieDatabase::class.java, DATABASE_NAME).build()


    @Provides
    @Singleton
    fun getMovieSearchDao(db: MovieDatabase) = db.getMovieSearchDao()


}