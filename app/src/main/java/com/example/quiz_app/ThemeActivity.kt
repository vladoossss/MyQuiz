package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ThemeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)

        val username = intent.getStringExtra(Constants.USER_NAME)

        // Set the LayoutManager that this RecyclerView will use.
        val res = findViewById<RecyclerView>(R.id.recycler_view_items)
        res.layoutManager = LinearLayoutManager(this)

        // Adapter class is initialized and list is passed in the param.
        val itemAdapter = ThemeAdapter(this, getItemsList(), username.toString())

        // adapter instance is set to the recyclerview to inflate the items.
        res.adapter = itemAdapter


    }

    private fun getItemsList(): ArrayList<String> {
        val list = ArrayList<String>()

        list.add("Футбол")
        list.add("Биатлон")
        list.add("Плавание")
        list.add("Хоккей")
        list.add("Фигурное катание")
        list.add("Велоспорт")

        return list
    }



}

