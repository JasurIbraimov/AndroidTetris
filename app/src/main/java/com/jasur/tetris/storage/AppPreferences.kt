package com.jasur.tetris.storage

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {
    // SharedPreference instance
    private val data: SharedPreferences = context.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)

    fun saveHighScore(highScore: Int) {
        // Editing sharedPreferences and applying changes
        data.edit().putInt("HIGH_SCORE", highScore).apply()
    }

    fun getHighScore(): Int {
        // Get HighScore if not 0 will be return
        return data.getInt("HIGH_SCORE", 0)
    }

    fun clearHighScore() {
        data.edit().putInt("HIGH_SCORE", 0).apply()
    }
}