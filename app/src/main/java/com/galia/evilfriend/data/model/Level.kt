package com.galia.evilfriend.data.model

enum class Level {
    NORMAL, HIGH;

    companion object {
        private const val normal = "normal"
        private const val high = "high"

        fun getLevel(code: String): Level {
            return when (code) {
                normal -> NORMAL
                high -> HIGH
                else -> throw Exception("Not supported level")
            }
        }

        fun getStringLevel(level: Level): String {
            return when (level) {
                NORMAL -> normal
                HIGH -> high
            }
        }
    }

}