package com.galia.evilfriend.data.repository

import com.galia.evilfriend.data.model.Notification
import com.galia.evilfriend.data.model.Prompt
import com.galia.evilfriend.data.model.PromptAndNotification
import kotlinx.coroutines.flow.Flow

interface PromptRepository {

    fun getAllPromptAndNotification(): Flow<List<PromptAndNotification>>

    fun getPromptAndNotification(id: Int): Flow<PromptAndNotification>

    suspend fun addPromptAndNotification(prompt: Prompt, notification: Notification)

    suspend fun updatePromptAndNotification(prompt: Prompt, notification: Notification)
}