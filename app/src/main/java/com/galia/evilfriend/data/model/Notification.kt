package com.galia.evilfriend.data.model

import androidx.room.*
import java.util.*

@Entity(
    tableName = "notifications",
    foreignKeys = [
        ForeignKey(entity = Prompt::class, parentColumns = ["id"], childColumns = ["fid_prompt"])
    ]
)
data class Notification(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "fid_prompt") val fidPrompt: Int,
    @ColumnInfo(name = "wake_at") var wakeAt: Date = Date(),
    @ColumnInfo(name = "is_active") var isActive: Boolean = true
)
