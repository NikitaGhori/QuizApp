package com.example.quizapp

object Constant {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_ques"
    const val CORRECT_ANSWERS: String = "correct_ans"
    fun getQuestion(): ArrayList<Questions> {
        val quesList = ArrayList<Questions>()


        // 1
        val que1 = Questions(
            1,
            "Guess the programming language",
            R.drawable.ic_flutter,
            "PHP",
            "Flutter",
            "Visual Basic",
            "Java",
            2
        )
        quesList.add(que1)

        // 2
        val que2 = Questions(
            2, "Guess the programming language",
            R.drawable.ic_java,
            "Java", "Java Script",
            "Kotlin", "Perl", 1
        )

        quesList.add(que2)

        // 3
        val que3 = Questions(
            3, "Guess the programming language",
            R.drawable.ic_perl,
            "Kotlin", "Ruby",
            "Perl", "PHP", 3
        )

        quesList.add(que3)

        // 4
        val que4 = Questions(
            4, "What country does this flag belong to?",
            R.drawable.ic_kotlin,
            "Java", "Kotlin",
            "Delphi", "Ruby", 2
        )

        quesList.add(que4)

        // 5
        val que5 = Questions(
            5, "What country does this flag belong to?",
            R.drawable.ic_c,
            "C++", "C#",
            "Go", "C", 4
        )

        quesList.add(que5)

        // 6
        val que6 = Questions(
            6, "What country does this flag belong to?",
            R.drawable.ic_python,
            "Swift", "Python",
            "Kotlin", "Java", 2
        )

        quesList.add(que6)

        // 7
        val que7 = Questions(
            7, "What country does this flag belong to?",
            R.drawable.ic_go,
            "Go", "Java",
            "PHP", "Perl", 1
        )

        quesList.add(que7)

        // 8
        val que8 = Questions(
            8, "What country does this flag belong to?",
            R.drawable.ic_delphi,
            "C", "Ruby",
            "Delphi", "Perl", 3
        )

        quesList.add(que8)

        // 9
        val que9 = Questions(
            9, "What country does this flag belong to?",
            R.drawable.ic_ruby,
            "Ruby", "Java",
            "Perl", "Kotlin", 1
        )

        quesList.add(que9)

        // 10
        val que10 = Questions(
            10, "What country does this flag belong to?",
            R.drawable.ic_swift,
            "Kotlin", "Java",
            "Python", "Swift", 4
        )

        quesList.add(que10)
        return quesList

    }
}