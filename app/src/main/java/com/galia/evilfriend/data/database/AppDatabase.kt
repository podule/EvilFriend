package com.galia.evilfriend.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.galia.evilfriend.data.converter.PromptTypeConverter
import com.galia.evilfriend.data.dao.PromptDao
import com.galia.evilfriend.data.model.Prompt

const val DATABASE_NAME = "evil-friend-database"

@Database(entities = [Prompt::class], version = 1)
@TypeConverters(PromptTypeConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun promptDao(): PromptDao
}