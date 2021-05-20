package com.example.quiz_app

object Constants {

    const val USER_NAME:String = "user_name"
    const val ALL_QUESTIONS:String = "all_questions"
    const val CORRECT_ANSWERS:String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Кто изображен на фото?",
            R.drawable.messi,
            "Роналду",
            "Пеле",
            "Месси",
            "Марадона",
            3
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "Кто изображен на фото?",
            R.drawable.neymar,
            "Неймар",
            "Суарес",
            "Гризман",
            "Мбаппе",
            1
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "Кто изображен на фото?",
            R.drawable.mbappe,
            "Агуэро",
            "Ибрагимович",
            "Руни",
            "Мбаппе",
            4
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "Кто изображен на фото?",
            R.drawable.salah,
            "Манэ",
            "Салах",
            "Ван Дейк",
            "Канте",
            2
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "Кто изображен на фото?",
            R.drawable.ibra,
            "Левандовски",
            "Торрес",
            "Ибрагимович",
            "Обамеянг",
            3
        )
        questionsList.add(que5)

        val que6 = Question(
            6,
            "Кто изображен на фото?",
            R.drawable.benzema,
            "Бензема",
            "Игуаин",
            "Мертенс",
            "Жезус",
            1
        )
        questionsList.add(que6)

        val que7 = Question(
            7,
            "Кто изображен на фото?",
            R.drawable.sterling,
            "Манэ",
            "Дембеле",
            "Стерлинг",
            "Коутиньо",
            3
        )
        questionsList.add(que7)

        val que8 = Question(
            8,
            "Кто изображен на фото?",
            R.drawable.buffon,
            "Нойер",
            "Касильяс",
            "Куртуа",
            "Буффон",
            4
        )
        questionsList.add(que8)

        val que9 = Question(
            9,
            "Кто изображен на фото?",
            R.drawable.werner,
            "Хаверц",
            "Вернер",
            "Маунт",
            "Жоржиньо",
            2
        )
        questionsList.add(que9)

        val que10 = Question(
            10,
            "Кто изображен на фото?",
            R.drawable.fati,
            "Пуч",
            "Миньеса",
            "Араухо",
            "Фати",
            4
        )
        questionsList.add(que10)

        return questionsList
    }

}