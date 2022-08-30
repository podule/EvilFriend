package com.galia.evilfriend.data.model

import androidx.room.*
import java.util.*

@Entity(
    tableName = "prompts"
)
data class Prompt(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var title: String,
    val level: String,
    @ColumnInfo(name = "is_active") var isActive: Boolean = true,
    @ColumnInfo(name = "created_at") var createdAt: Date = Date()
)