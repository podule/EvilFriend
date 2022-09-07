package com.galia.evilfriend.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.galia.evilfriend.data.model.Notification

@Dao
interface NotificationDao {
    @Insert
    suspend fun insert(notification: Notification): Long

    @Update
    suspend fun update(notification: Notification)
}