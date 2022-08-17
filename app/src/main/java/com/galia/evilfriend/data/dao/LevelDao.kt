package com.galia.evilfriend.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.galia.evilfriend.data.model.Level

@Dao
interface LevelDao {
    @Query("SELECT * FROM levels")
    fun getLevels(): List<Level>
}