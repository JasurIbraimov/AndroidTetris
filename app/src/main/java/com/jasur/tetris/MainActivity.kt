package com.jasur.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var tvHighScore: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val exitBtn = findViewById<Button>(R.id.btn_exit)
        val btnNewGame = findViewById<Button>(R.id.btn_new_game)
        val btnResetScore = findViewById<Button>(R.id.btn_reset_score)
        tvHighScore = findViewById<TextView>(R.id.tv_high_score)

        btnNewGame.setOnClickListener(this::handleNewGameBtnClicked)
        supportActionBar?.hide() // hides support action bar
        exitBtn.setOnClickListener(this::handleExitBtnClicked)
    }

    private fun handleExitBtnClicked(view: View) {
        finish()
    }

    private fun handleNewGameBtnClicked(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}