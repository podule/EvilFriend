package com.galia.evilfriend.data.repository

import android.content.Context
import androidx.room.Room
import com.galia.evilfriend.data.database.AppDatabase
import com.galia.evilfriend.data.database.DATABASE_NAME


class PromptDatabaseRepository private constructor(context: Context){

    private val database: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val promptDao = database.promptDao()

    fun getAllPrompts() = promptDao.getAllPrompts()

    fun getPrompt(id: Int) = promptDao.getPrompt(id)

    companion object {
        private var instance: PromptDatabaseRepository? = null

        fun initialize(context: Context) {
            if (instance == null) {
                instance = PromptDatabaseRepository(context)
            }
        }

        fun get(): PromptDatabaseRepository {
            return instance ?: throw IllegalStateException("PromptRepository not initialized")
        }
    }
}