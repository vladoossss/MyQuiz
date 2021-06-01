package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import okhttp3.*
import java.io.IOException
import android.text.Html
import android.view.View
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import okhttp3.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.start_button)        // кнопка перехода
        val name = findViewById<AppCompatEditText>(R.id.user_name)  // имя пользователя

        var firstAns: String = ""
        var secondAns: String = ""
        var thirdAns: String = ""
        var correctAns: String = ""
        var needData: MutableMap<String, Any>? = null

        button.setOnClickListener {
            if (name.text.toString().isEmpty()) {
                Toast.makeText(this@MainActivity, "Введите имя:", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@MainActivity, ThemeActivity::class.java)
                intent.putExtra(
                    Constants.USER_NAME,
                    name.text.toString()
                ) // передаем в следующее активити
                startActivity(intent)
                finish()
            }
        }
//        val db = Firebase.firestore
//
//        val doc = db.collection("questions").document("Doc1")
//
//        doc.addSnapshotListener { snapshot, e ->
//            if (snapshot != null && snapshot.exists()) {
//                needData = snapshot.data as MutableMap<String, Any>
//                firstAns = snapshot.getString("FirstAns").toString()
//                secondAns = snapshot.data!!["SecondAns"].toString()
//                thirdAns = snapshot.data!!["ThirdAns"].toString()
//                correctAns = snapshot.data!!["CorrectAns"].toString()
//                val text = firstAns
//                val duration = Toast.LENGTH_SHORT
//
//                val toast = Toast.makeText(applicationContext, text, duration)
//                toast.show()
//            } else {
//                needData = mutableMapOf<String, Any>("1" to 1)
//            }
//        }
    }
}