package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USER_NAME)
        findViewById<TextView>(R.id.tv_name).text = "Поздравляем, $username"

        val allQuestions = intent.getIntExtra(Constants.ALL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        findViewById<TextView>(R.id.tv_score).text = "Ты ответил правильно на $correctAnswers из $allQuestions вопросов"

        findViewById<TextView>(R.id.btn_finish).setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}