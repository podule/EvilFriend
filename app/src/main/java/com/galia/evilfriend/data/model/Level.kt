package com.galia.evilfriend.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "levels")
data class Level(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val code: String,
    @ColumnInfo(name = "is_active") var isActive: Boolean = true

)
