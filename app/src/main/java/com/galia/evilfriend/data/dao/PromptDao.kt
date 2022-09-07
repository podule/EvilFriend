package com.galia.evilfriend.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.galia.evilfriend.data.model.Notification
import com.galia.evilfriend.data.model.PromptAndNotification
import com.galia.evilfriend.data.model.Prompt
import kotlinx.coroutines.flow.Flow

@Dao
interface PromptDao {
    @Query("SELECT * FROM prompts")
    fun getAllPrompts(): LiveData<List<Prompt>>

    @Query("SELECT * FROM prompts where id=(:id)")
    fun getPrompt(id: Int): Prompt?

    @Transaction
    @Query("SELECT * FROM prompts where is_active = 1")
    fun getAllPromptAndNotification(): Flow<List<PromptAndNotification>>

    @Transaction
    @Query("SELECT * FROM prompts where id=(:id)")
    fun getPromptAndNotification(id: Int): Flow<PromptAndNotification>

    @Transaction
    suspend fun addPromptAndNotification(prompt: Prompt, notification: Notification, daoNotificationDao: NotificationDao) {
        val pk = insert(prompt)
        notification.fidPrompt = pk.toInt()
        daoNotificationDao.insert(notification)
    }

    @Transaction
    suspend fun updatePromptAndNotification(prompt: Prompt, notification: Notification, daoNotificationDao: NotificationDao) {
        update(prompt)
        daoNotificationDao.update(notification)
    }

    @Insert
    suspend fun insert(prompt: Prompt): Long

    @Update
    suspend fun update(prompt: Prompt)
}