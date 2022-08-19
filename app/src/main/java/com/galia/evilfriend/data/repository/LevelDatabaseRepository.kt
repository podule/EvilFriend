package com.galia.evilfriend.data.repository

import com.galia.evilfriend.data.dao.LevelDao
import javax.inject.Inject

class LevelDatabaseRepository @Inject constructor(
    private val levelDao: LevelDao
) {

    fun getLevels() = levelDao.getLevels()
}