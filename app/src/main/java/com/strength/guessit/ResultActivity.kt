package com.strength.guessit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var gameScoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        gameScoreTextView = findViewById(R.id.game_score_text_view_RA)

        gameScoreTextView.text = intent.getIntExtra("KEY_SCORE", 0).toString()
    }
}