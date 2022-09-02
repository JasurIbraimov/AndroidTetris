package com.jasur.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.jasur.tetris.storage.AppPreferences

class MainActivity : AppCompatActivity() {
    private var tvHighScore: TextView? = null
    private var preferences: AppPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Hide support action bar
        supportActionBar?.hide()

        // Grab things from XML
        val exitBtn = findViewById<Button>(R.id.btn_exit)
        val btnNewGame = findViewById<Button>(R.id.btn_new_game)
        val btnResetScore = findViewById<Button>(R.id.btn_reset_score)
        tvHighScore = findViewById<TextView>(R.id.tv_high_score)

        preferences = AppPreferences(this)

        // Add Listeners To Buttons
        btnNewGame.setOnClickListener(this::handleNewGameBtnClicked)
        exitBtn.setOnClickListener(this::handleExitBtnClicked)
        btnResetScore.setOnClickListener(this::handleResetButtonClicked)
        setHighScoreText()
    }

    private fun handleExitBtnClicked(view: View) {
        finish()
    }

    private fun handleNewGameBtnClicked(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun handleResetButtonClicked(view: View) {
        preferences?.clearHighScore()
        Snackbar.make(view, getString(R.string.score_reset_message), Snackbar.LENGTH_LONG).show()
        setHighScoreText()
    }

    private fun setHighScoreText() {
        tvHighScore?.text = "${getString(R.string.high_score)}${preferences?.getHighScore()}"
    }
}