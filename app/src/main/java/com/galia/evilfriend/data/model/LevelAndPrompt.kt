package com.galia.evilfriend.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class LevelAndPrompt(
    @Embedded
    val prompt: Prompt,
    @Relation(parentColumn = "fid_level", entityColumn = "id")
    val level: Level
)