package com.galia.evilfriend.data.model

const val NORMAL_VALUE = "Обычный"
const val HIGH_VALUE = "Важный"

enum class Level {
    NORMAL, HIGH;

    companion object {

        fun getLevel(code: String): Level {
            return when (code) {
                NORMAL_VALUE -> NORMAL
                HIGH_VALUE -> HIGH
                else -> throw Exception("Not supported level")
            }
        }

        fun getStringLevel(level: Level): String {
            return when (level) {
                NORMAL -> NORMAL_VALUE
                HIGH -> HIGH_VALUE
            }
        }

        fun getLevels(): List<String> {
            return mapOf<Level, String>(NORMAL to NORMAL_VALUE, HIGH to HIGH_VALUE).values.toList()
        }
    }

}