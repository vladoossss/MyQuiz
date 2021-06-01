package com.example.quiz_app

data class Question(
    val question: String,
    val image: String,
    val firstOption: String,
    val secondOption: String,
    val thirdOption: String,
    val fourthOption: String,
    val correctOption: Int
)

