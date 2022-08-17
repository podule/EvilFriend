package com.galia.evilfriend.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.galia.evilfriend.data.model.Prompt

@Dao
interface PromptDao {
    @Query("SELECT * FROM prompts")
    fun getAllPrompts(): List<Prompt>

    @Query("SELECT * FROM prompts where id=(:id)")
    fun getPrompt(id: Int): Prompt?

    @Insert
    fun insert(prompt: Prompt)

    @Update
    fun update(prompt: Prompt)
}