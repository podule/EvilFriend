package com.galia.evilfriend.di

import android.content.Context
import com.galia.evilfriend.data.dao.LevelDao
import com.galia.evilfriend.data.dao.PromptDao
import com.galia.evilfriend.data.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @AppScope
    @Provides
    fun getAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun getPromptDao(appDatabase: AppDatabase): PromptDao {
        return appDatabase.promptDao()
    }

    @Provides
    fun getLevelDao(appDatabase: AppDatabase): LevelDao {
        return appDatabase.levelDao()
    }

}