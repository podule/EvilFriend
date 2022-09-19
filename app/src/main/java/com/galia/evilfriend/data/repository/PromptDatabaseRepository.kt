package com.galia.evilfriend.data.repository

import com.galia.evilfriend.data.dao.NotificationDao
import com.galia.evilfriend.data.dao.PromptDao
import com.galia.evilfriend.data.model.Notification
import com.galia.evilfriend.data.model.Prompt
import javax.inject.Inject


class PromptDatabaseRepository @Inject constructor(
    private val promptDao: PromptDao,
    private val notificationDao: NotificationDao
): PromptRepository {

    override fun getAllPromptAndNotification() = promptDao.getAllPromptAndNotification()

    override fun getPromptAndNotification(id: Int) = promptDao.getPromptAndNotification(id)
    override suspend fun addPromptAndNotification(
        prompt: Prompt,
        notification: Notification
    ): Int {
        return promptDao.addPromptAndNotification(prompt, notification, notificationDao)
    }

    override suspend fun updatePromptAndNotification(
        prompt: Prompt,
        notification: Notification
    ) {
        promptDao.updatePromptAndNotification(prompt, notification, notificationDao)
    }

}