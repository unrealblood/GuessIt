package com.strength.guessit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    private lateinit var playButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        playButton = findViewById(R.id.play_button_WA)

        playButton.setOnClickListener {
            val mainActivityIntent = Intent(this@WelcomeActivity, MainActivity::class.java)
            startActivity(mainActivityIntent)
            finish()
        }
    }
}