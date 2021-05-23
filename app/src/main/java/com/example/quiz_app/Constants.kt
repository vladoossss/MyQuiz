package com.example.quiz_app

object Constants {

    const val USER_NAME: String = "user_name"
    const val ALL_QUESTIONS: String = "all_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val THEME_NUM: String = "num_of_theme"

    fun getQuestions_1(): ArrayList<Question> {
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

    fun getQuestions_2(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Кто изображен на фото?",
            R.drawable.fourcade,
            "Фуркад",
            "Свендсен",
            "Грайс",
            "Пайфер",
            1
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "Кто изображен на фото?",
            R.drawable.shipulin,
            "Гараничев",
            "Малышко",
            "Шипулин",
            "Волков",
            3
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "Кто изображен на фото?",
            R.drawable.bjorn,
            "Свендсен",
            "Бьорндаллен",
            "Ханевольд",
            "Бе",
            2
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "Кто изображен на фото?",
            R.drawable.dasha,
            "Юрьева",
            "Домрачева",
            "Слепцова",
            "Кручинкина",
            2
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "Кто изображен на фото?",
            R.drawable.neuner,
            "Бергер",
            "Хенкель",
            "Вильхельм",
            "Нойнер",
            4
        )
        questionsList.add(que5)


        return questionsList
    }

    fun getQuestions_3(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Кто изображен на фото?",
            R.drawable.phelps_michael,
            "Лохте",
            "Фелпс",
            "Дрессел",
            "Милак",
            2
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "Кто изображен на фото?",
            R.drawable.julia,
            "Ефимова",
            "Фесикова",
            "Чимрова",
            "Попова",
            1
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "Кто изображен на фото?",
            R.drawable.peaty,
            "Пити",
            "Кох",
            "Шиманович",
            "Эндрю",
            1
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "Кто изображен на фото?",
            R.drawable.dressel,
            "Манаду",
            "Эдриан",
            "Дрессел",
            "Ле кло",
            3
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "Кто изображен на фото?",
            R.drawable.chupkov,
            "Пригода",
            "Чупков",
            "Финоченко",
            "Векленко",
            2
        )
        questionsList.add(que5)

        return questionsList
    }

    fun getQuestions_4(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Какая страна является родиной хоккея с шайбой?",
            R.drawable.basichockey,
            "США",
            "Канада",
            "СССР",
            "Великобритания",
            2
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "Сколько минут чистого времени длится хоккейный период?",
            R.drawable.hockeyperioud,
            "20 минут",
            "30 минут",
            "40 минут",
            "45 минут",
            1
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "Какая буква на джерси указывает на то, что хоккеист – капитан команды?",
            R.drawable.gersy,
            "A",
            "B",
            "C",
            "K",
            3
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "Кто изображен на фото?",
            R.drawable.gudachek,
            "Гудачек",
            "Беспалов",
            "Никишин",
            "Рылов",
            1
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "Кто изображен на фото?",
            R.drawable.ovechkin,
            "Малкин",
            "Кучеров",
            "Ковальчук",
            "Овечкин",
            4
        )
        questionsList.add(que5)

        return questionsList
    }

    fun getQuestions_5(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Кто изображен на фото?",
            R.drawable.tuktamisheva,
            "Синицина",
            "Щербакова",
            "Туктамышева",
            "Медведева",
            3
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "Когда фигурное катание вошло в программу зимних Олимпийских видов спорта?",
            R.drawable.katanie,
            "1908 г.",
            "1920 г.",
            "1924 г.",
            "1930 г.",
            3
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "Первые соревнования по фигурному катанию проходили среди ...?",
            R.drawable.history,
            "мужчин",
            "женщин",
            "отдельно мужчин и женщин",
            "пар фигуристов",
            1
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "Что представляло из себя самое первое фигурное катание?",
            R.drawable.history1,
            "Гонки на коньках",
            "Изображение фигур на льду",
            "Вычерчивание фигур на льду, сохраняя при этом красивую позу",
            "Катание на льду в красивой позе",
            3
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "Кто самая юная олимпийская чемпионка по фигурному катанию в истории?",
            R.drawable.gerber,
            "Липницкая",
            "Загитова",
            "Гербер",
            "Липински",
            3
        )
        questionsList.add(que5)

        return questionsList
    }

    fun getQuestions_6(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Какой вид спорта изображен на фото?",
            R.drawable.veloball,
            "Фигурная езда на велосипеде",
            "Велогонка",
            "Велохоккей",
            "Велобол",
            4
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "Кто изображен на фото?",
            R.drawable.ekimov,
            "Екимов",
            "Хой",
            "Уиггинс",
            "Балланже",
            1
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "Что такое слипстрим в велогонке?",
            R.drawable.stream,
            "Перемещение из одной полосы в другую",
            "Набор скорости при движении под гору",
            "Езда в завихрённой зоне",
            "Тактика обгона",
            3
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "Как называется самый престижный вид соревнований в шоссейном велоспорте?",
            R.drawable.grand_tour,
            "Гранд Трип",
            "Гранд Тур",
            "Гранд Турне",
            "Гранд Марафон",
            2
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "Какое направление подразумевает прыжки и выполнение трюков?",
            R.drawable.grand_tour,
            "Триал",
            "BMX",
            "Фрирайд",
            "Кросс-кантри",
            2
        )
        questionsList.add(que5)

        return questionsList
    }
}
