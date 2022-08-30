package com.galia.evilfriend.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class PromptAndNotification(
    @Embedded
    val prompt: Prompt,
    @Relation(parentColumn = "id", entityColumn = "fid_prompt")
    val notification: Notification
)