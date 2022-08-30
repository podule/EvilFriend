package com.galia.evilfriend.data.converter

import androidx.room.TypeConverter
import com.galia.evilfriend.data.model.Level

class PromptTypeConverter {

    @TypeConverter
    fun fromLevel(level: Level): String {
        return Level.getStringLevel(level)
    }

    @TypeConverter
    fun toLevel(code: String): Level {
        return Level.getLevel(code)
    }
}