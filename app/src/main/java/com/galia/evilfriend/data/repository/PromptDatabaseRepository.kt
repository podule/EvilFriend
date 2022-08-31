package com.galia.evilfriend.data.repository

import com.galia.evilfriend.data.dao.PromptDao
import javax.inject.Inject


class PromptDatabaseRepository @Inject constructor(
    private val promptDao: PromptDao
): PromptRepository {
    fun getAllPrompts() = promptDao.getAllPrompts()

    override fun getAllPromptAndNotification() = promptDao.getAllPromptAndNotification()

    fun getPrompt(id: Int) = promptDao.getPrompt(id)

}