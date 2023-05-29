package com.strength.guessit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val Words = ArrayList<String>()
    private val timeForPlay : Long = 300000; // 5 mins

    private lateinit var timerTextView : TextView
    private lateinit var skipWordButton: Button
    private lateinit var nextWordButton: Button
    private lateinit var gameWordTextView: TextView
    private lateinit var gameScoreTextView: TextView

    private var score = 0
    private var currentGameWordIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Words.add("Time")
        Words.add("Book")
        Words.add("Watch")
        Words.add("Movie")
        Words.add("Table")
        Words.add("Water")
        Words.add("Glass")
        Words.add("Phone")
        Words.add("Computer")
        Words.add("Laptop")

        timerTextView = findViewById(R.id.timer_text_view_MA)
        skipWordButton = findViewById(R.id.skip_word_button_MA)
        nextWordButton = findViewById(R.id.next_word_button_MA)
        gameWordTextView = findViewById(R.id.word_to_guess_text_view_MA)
        gameScoreTextView = findViewById(R.id.score_text_view_MA)

        //start game time
        countdownTimer.start()

        gameWordTextView.text = Words[currentGameWordIndex]

        nextWordButton.setOnClickListener {
            currentGameWordIndex++

            if(currentGameWordIndex == 10) {
                //finish game
                GameFinished()
            }

            if(currentGameWordIndex >= 9) { currentGameWordIndex = 9 }

            gameWordTextView.text = Words[currentGameWordIndex]
            score += 10

            gameScoreTextView.text = score.toString()
        }

        skipWordButton.setOnClickListener {
            currentGameWordIndex++

            if(currentGameWordIndex == 10) {
                //finish game
                GameFinished()
            }

            if(currentGameWordIndex >= 9) { currentGameWordIndex = 9 }

            gameWordTextView.text = Words[currentGameWordIndex]
        }
    }

    private val countdownTimer = object : CountDownTimer(timeForPlay, 1000) {
        override fun onTick(p0: Long) {
            timerTextView.text = "0" + (p0 /(60000) % 60).toString() + " : "
            if(((p0 / 1000) % 60) < 10) {
                timerTextView.append("0" + ((p0 / 1000) % 60).toString())
            }
            else {
                timerTextView.append(((p0 / 1000) % 60).toString())
            }
        }

        override fun onFinish() {
            //result activity
            GameFinished()
        }
    }

    private fun GameFinished() {
        val resultActivityIntent = Intent(this@MainActivity, ResultActivity::class.java)
        resultActivityIntent.putExtra("KEY_SCORE", score)
        startActivity(resultActivityIntent)
        finish()
    }
}