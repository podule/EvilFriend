package com.galia.evilfriend.data.repository

import com.galia.evilfriend.data.dao.PromptDao


class PromptDatabaseRepository constructor(
    private val promptDao: PromptDao
){
    fun getAllPrompts() = promptDao.getAllPrompts()

    fun getPrompt(id: Int) = promptDao.getPrompt(id)

}