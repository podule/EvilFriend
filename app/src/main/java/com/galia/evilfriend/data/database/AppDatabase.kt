package com.galia.evilfriend.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.galia.evilfriend.data.converter.PromptTypeConverter
import com.galia.evilfriend.data.dao.LevelDao
import com.galia.evilfriend.data.dao.PromptDao
import com.galia.evilfriend.data.model.Level
import com.galia.evilfriend.data.model.Prompt

const val DATABASE_NAME = "evil-friend-database"

@Database(entities = [Prompt::class, Level::class], version = 1, exportSchema = false)
@TypeConverters(PromptTypeConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun promptDao(): PromptDao
    abstract fun levelDao(): LevelDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }


}