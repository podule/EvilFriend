package com.galia.evilfriend.data.repository

import com.galia.evilfriend.data.dao.PromptDao
import javax.inject.Inject


class PromptDatabaseRepository @Inject constructor(
    private val promptDao: PromptDao
){
    fun getAllPrompts() = promptDao.getAllPrompts()

    fun getAllLevelAndPrompt() = promptDao.getAllLevelAndPrompt()

    fun getPrompt(id: Int) = promptDao.getPrompt(id)

}