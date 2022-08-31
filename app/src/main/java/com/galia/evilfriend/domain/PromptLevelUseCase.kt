package com.galia.evilfriend.domain

import com.galia.evilfriend.R
import com.galia.evilfriend.data.model.Level
import javax.inject.Inject

class PromptLevelUseCase @Inject constructor() {

    operator fun invoke(level: Level): Int {
        return when (level) {
            Level.NORMAL -> R.color.normalLevelColor
            Level.HIGH -> R.color.highLevelColor
        }
    }
}