package com.galia.evilfriend.data.repository

import com.galia.evilfriend.data.dao.LevelDao

class LevelDatabaseRepository constructor(
    private val levelDao: LevelDao
) {

    fun getLevels() = levelDao.getLevels()
}