package com.galia.evilfriend.data.repository

import com.galia.evilfriend.data.model.PromptAndNotification
import kotlinx.coroutines.flow.Flow

interface PromptRepository {

    fun getAllPromptAndNotification(): Flow<List<PromptAndNotification>>
}