package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.start_button)        // кнопка перехода
        val name = findViewById<AppCompatEditText>(R.id.user_name)  // имя пользователя

        button.setOnClickListener {
            if (name.text.toString().isEmpty()) {
                Toast.makeText(this@MainActivity, "Введите имя:", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@MainActivity, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, name.text.toString()) // передаем в следующее активити
                startActivity(intent)
                finish()
            }
        }

    }
}