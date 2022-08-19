package com.galia.evilfriend.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.galia.evilfriend.data.model.LevelAndPrompt
import com.galia.evilfriend.data.model.Prompt

@Dao
interface PromptDao {
    @Query("SELECT * FROM prompts")
    fun getAllPrompts(): LiveData<List<Prompt>>

    @Query("SELECT * FROM prompts where id=(:id)")
    fun getPrompt(id: Int): Prompt?

    @Transaction
    @Query("SELECT * FROM prompts where is_active = 1")
    fun getAllLevelAndPrompt(): LiveData<List<LevelAndPrompt>>

    @Insert
    fun insert(prompt: Prompt)

    @Update
    fun update(prompt: Prompt)
}