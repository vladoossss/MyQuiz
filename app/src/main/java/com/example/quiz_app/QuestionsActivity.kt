package com.example.quiz_app

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1                  // позиция текущего вопроса
    private var mQuestionList: ArrayList<Question>? = null // список вопросов
    private var mSelectedPosition: Int = 1                 // позиция выбранного ответ на вопрос
    private var mCorrectAnswers: Int = 0                   // число правильных ответов
    private var mUserName: String? = null                  // имя пользователя

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)  // получаем имя из прошлого активити
        mQuestionList = Constants.getQuestions()                // инициализируем список вопросов
        setQuestion()

        findViewById<TextView>(R.id.tv_option_one).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_option_two).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_option_three).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_option_four).setOnClickListener(this)
        findViewById<Button>(R.id.submit_button).setOnClickListener(this)
    }

    private fun setQuestion() {  // передаем вопрос и ответы

        val question = mQuestionList!![mCurrentPosition - 1]
        defaultOptionsView()

        if (mCurrentPosition == mQuestionList!!.size) {
            findViewById<Button>(R.id.submit_button).text = "Завершить"
        } else {
            findViewById<Button>(R.id.submit_button).text = "Ответить"
        }

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = mCurrentPosition

        val tvProgress = findViewById<TextView>(R.id.tv_progress)
        tvProgress.text = "$mCurrentPosition" + "/" + progressBar.max

        val tvQuestion = findViewById<TextView>(R.id.tv_question)
        tvQuestion.text = question!!.question

        val ivImage = findViewById<ImageView>(R.id.iv_img)
        ivImage.setImageResource(question.image)

        val tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        tvOptionOne.text = question.firstOption
        val tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        tvOptionTwo.text = question.secondOption
        val tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        tvOptionThree.text = question.thirdOption
        val tvOptionFour = findViewById<TextView>(R.id.tv_option_four)
        tvOptionFour.text = question.fourthOption
    }

    private fun defaultOptionsView() {  // внешний вид кнопок по умолчанию
        val options = ArrayList<TextView>()
        options.add(0, findViewById<TextView>(R.id.tv_option_one))
        options.add(1, findViewById<TextView>(R.id.tv_option_two))
        options.add(2, findViewById<TextView>(R.id.tv_option_three))
        options.add(3, findViewById<TextView>(R.id.tv_option_four))

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuestionsActivity,
                R.drawable.option_border
            )
        }
    }

    override fun onClick(v: View?) {  // что происходит по нажатию на кнопку
        when (v?.id) {

            R.id.tv_option_one -> {
                selectedOptionView(findViewById<TextView>(R.id.tv_option_one), 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(findViewById<TextView>(R.id.tv_option_two), 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(findViewById<TextView>(R.id.tv_option_three), 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(findViewById<TextView>(R.id.tv_option_four), 4)
            }
            R.id.submit_button -> {
                if (mSelectedPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.ALL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    // This is to check if the answer is wrong
                    if (question!!.correctOption != mSelectedPosition) {
                        answerView(mSelectedPosition, R.drawable.wrong_option_border)
                    } else {
                        mCorrectAnswers++
                    }
                    // This is for correct answer
                    answerView(question.correctOption, R.drawable.correct_option_border)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        findViewById<Button>(R.id.submit_button).text = "Завершить"
                    } else {
                        findViewById<Button>(R.id.submit_button).text = "Следующий вопрос"
                    }
                    mSelectedPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) { // внешний вид подтвержденного ответа
        when (answer) {
            1 -> {
                findViewById<TextView>(R.id.tv_option_one).background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    drawableView
                )
            }
            2 -> {
                findViewById<TextView>(R.id.tv_option_two).background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    drawableView
                )
            }
            3 -> {
                findViewById<TextView>(R.id.tv_option_three).background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    drawableView
                )
            }
            4 -> {
                findViewById<TextView>(R.id.tv_option_four).background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) { // внешний вид выбранного ответа

        defaultOptionsView()

        mSelectedPosition = selectedOptionNum
        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuestionsActivity,
            R.drawable.select_option_border
        )
    }
}