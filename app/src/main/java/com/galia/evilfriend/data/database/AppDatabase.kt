package com.galia.evilfriend.data.database

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.galia.evilfriend.data.converter.DateTypeConverter
import com.galia.evilfriend.data.converter.PromptTypeConverter
import com.galia.evilfriend.data.dao.PromptDao
import com.galia.evilfriend.data.model.Notification
import com.galia.evilfriend.data.model.Prompt

const val DATABASE_NAME = "evil-friend-database"

@Database(
    entities = [Prompt::class, Notification::class],
    version = 4,
    autoMigrations = [
        AutoMigration (from = 3, to = 4)
    ]
)
@TypeConverters(DateTypeConverter::class, PromptTypeConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun promptDao(): PromptDao

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
            )
                .addMigrations(MIGRATION_1_2)
                .addMigrations(MIGRATION_2_3)
                .build()
        }
    }


}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("""
            CREATE TABLE `prompts_new` (
            `id` INTEGER NOT NULL,
            `title` TEXT NOT NULL,
            `level` TEXT NOT NULL,
            `is_active` INTEGER NOT NULL,
            `created_at` INTEGER NOT NULL,
            PRIMARY KEY(`id`))"""
            .trimIndent())

        database.execSQL("DROP TABLE prompts")
        database.execSQL("ALTER TABLE prompts_new RENAME TO prompts")

        database.execSQL("DROP TABLE levels")

        database.execSQL("""
            CREATE TABLE `notifications` (
            `id` INTEGER NOT NULL,
            `fid_prompt` INTEGER NOT NULL,
            `is_active` INTEGER NOT NULL,
            `wake_at` INTEGER NOT NULL,
            PRIMARY KEY(`id`),
            FOREIGN KEY(`fid_prompt`) REFERENCES `prompts`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION)"""
            .trimIndent())
    }
}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("""
            CREATE TABLE `notifications_new` (
            `id` INTEGER NOT NULL,
            `fid_prompt` INTEGER NOT NULL,
            `is_active` INTEGER NOT NULL,
            `wake_hour` INTEGER NOT NULL,
            PRIMARY KEY(`id`),
            FOREIGN KEY(`fid_prompt`) REFERENCES `prompts`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION)"""
            .trimIndent())

        database.execSQL("DROP TABLE notifications")
        database.execSQL("ALTER TABLE notifications_new RENAME TO notifications")
    }
}