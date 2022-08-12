package com.galia.evilfriend.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Prompt(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var title: String,
    @ColumnInfo(name = "is_active") var isActive: Boolean = true,
    @ColumnInfo(name = "created_at") var createdAt: Date = Date()
)