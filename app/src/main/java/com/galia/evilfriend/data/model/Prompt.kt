package com.galia.evilfriend.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "prompts",
    foreignKeys = [
        ForeignKey(entity = Level::class, parentColumns = ["id"], childColumns = ["fid_level"])
    ],
    indices = [Index("fid_level")]
)
data class Prompt(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var title: String,
    @ColumnInfo(name = "fid_level") val fidLevel: Int,
    @ColumnInfo(name = "is_active") var isActive: Boolean = true,
    @ColumnInfo(name = "created_at") var createdAt: Date = Date()
)