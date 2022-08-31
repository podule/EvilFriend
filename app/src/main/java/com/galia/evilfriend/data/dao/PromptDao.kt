package com.galia.evilfriend.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
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

    @Insert
    fun insert(prompt: Prompt)

    @Update
    fun update(prompt: Prompt)
}