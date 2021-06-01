package com.example.quiz_app

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.net.URL
import com.bumptech.glide.Glide
import com.google.firebase.firestore.CollectionReference
import okhttp3.internal.notifyAll


class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1                  // позиция текущего вопроса
    private var mQuestionList: MutableList<Question>? = null // список вопросов
    private var mSelectedPosition: Int = 1                 // позиция выбранного ответ на вопрос
    private var mCorrectAnswers: Int = 0                   // число правильных ответов
    private var mUserName: String? = null                  // имя пользователя
    private var mThemeNum: Int = 0                  // имя пользователя

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)



        mUserName = intent.getStringExtra(Constants.USER_NAME)  // получаем имя из прошлого активити
        mThemeNum = intent.getIntExtra(Constants.THEME_NUM, 0)  // получаем имя из прошлого активити
        Log.d("TAG", "mThemeNum $mThemeNum")

        when (mThemeNum) {
            0 -> {
                var themeRef = Firebase.firestore.collection("football")
                setThemeQuestions(themeRef)       // инициализируем список вопросов про футбол
            }
            1 -> {
                var themeRef = Firebase.firestore.collection("biathlon")
                setThemeQuestions(themeRef)// инициализируем список вопросов про биатлон
            }
            2 -> {
                var themeRef = Firebase.firestore.collection("swimming")
                setThemeQuestions(themeRef)      // инициализируем список вопросов про плавание
            }
            3 -> {
                var themeRef = Firebase.firestore.collection("hockey")
                setThemeQuestions(themeRef)      // инициализируем список вопросов про хоккей
            }
            4 -> {
                var themeRef = Firebase.firestore.collection("figure skating")
                setThemeQuestions(themeRef)      // инициализируем список вопросов про фигурное катание
            }
            5 -> {
                var themeRef = Firebase.firestore.collection("bicycling")
                setThemeQuestions(themeRef)      // инициализируем список вопросов про фигурное катание
            }
            else -> {
                var themeRef = Firebase.firestore.collection("anime")
                setThemeQuestions(themeRef)     // инициализируем список вопросов про велоспорт
            }
        }

        findViewById<TextView>(R.id.tv_option_one).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_option_two).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_option_three).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_option_four).setOnClickListener(this)
        findViewById<Button>(R.id.submit_button).setOnClickListener(this)
    }

    private fun setThemeQuestions(themeRef: CollectionReference) {
        themeRef.addSnapshotListener { value, error ->

            mQuestionList = (value!!.documents!!.map {

                var mass = listOf(
                    it.getString("FirstAns").toString(),
                    it.getString("SecondAns").toString(),
                    it.getString("ThirdAns").toString(),
                    it.getString("CorrectAns").toString()
                )  // создаем лист из 4 вариантов ответа

                var number = 0 // позиция правильного ответа

                var first = mass!!.random()
                if (first == it.getString("CorrectAns").toString()) {
                    number = 1
                } // присваиваем рандомный ответ переменной и проверяем, является ли он правильным ответом. Убираем элемент из листа

                mass = mass - first

                var second = mass!!.random()
                if (second == it.getString("CorrectAns").toString()) {
                    number = 2
                } // присваиваем рандомный ответ переменной и проверяем, является ли он правильным ответом. Убираем элемент из листа

                mass = mass - second

                var third = mass!!.random()
                if (third == it.getString("CorrectAns").toString()) {
                    number = 3
                } // присваиваем рандомный ответ переменной и проверяем, является ли он правильным ответом. Убираем элемент из листа

                mass = mass - third

                var fourth = mass!!.random()
                if (fourth == it.getString("CorrectAns").toString()) {
                    number = 4
                }// присваиваем рандомный ответ переменной и проверяем, является ли он правильным ответом

                Question(
                    it.getString("Question").toString(),
                    it.getString("image").toString(),
                    first,
                    second,
                    third,
                    fourth,
                    number
                )
            } as MutableList<Question>) // составляем лист всех вопросов
            setQuestion()
        }
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
        progressBar.max = mQuestionList!!.size

        val tvProgress = findViewById<TextView>(R.id.tv_progress)
        tvProgress.text = "$mCurrentPosition" + "/" + mQuestionList!!.size

        val tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        tvOptionOne.text = question.firstOption
        val tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        tvOptionTwo.text = question.secondOption
        val tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        tvOptionThree.text = question.thirdOption
        val tvOptionFour = findViewById<TextView>(R.id.tv_option_four)
        tvOptionFour.text = question.fourthOption

        val tvQuestion = findViewById<TextView>(R.id.tv_question)
        tvQuestion.text = question.question

        var url = URL(question.image)

        val ivImage = findViewById<ImageView>(R.id.iv_img)
        Glide.with(applicationContext).load(url).into(ivImage)
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