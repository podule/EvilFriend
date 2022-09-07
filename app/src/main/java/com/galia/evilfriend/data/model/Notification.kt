package com.galia.evilfriend.data.model

import androidx.room.*

@Entity(
    tableName = "notifications",
    foreignKeys = [
        ForeignKey(entity = Prompt::class, parentColumns = ["id"], childColumns = ["fid_prompt"])
    ]
)
data class Notification(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "fid_prompt") var fidPrompt: Int,
    @ColumnInfo(name = "wake_hour") var wakeHour: Int = 0,
    @ColumnInfo(name = "wake_minutes", defaultValue = "0") var wakeMinutes: Int = 0,
    @ColumnInfo(name = "is_active") var isActive: Boolean = true
)
