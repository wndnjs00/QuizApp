package com.example.quizapp


// 실제 들어갈 데이터값 만들기
object Constants {

    // activity_result에 해당하는 정보
    const val USER_NAME : String = "user_name"              // username
    const val TOTAL_QUESTIONS : String = "total_questions"  // 전체질문의 개수
    const val CORRECT_ANSWERS : String = "correct_answers"  // 맞힌질문의 개수


    //이 함수를 실행시켰을때 Question에 담긴 데이터들을 전부 가져오도록
    fun getQuestions() : ArrayList<Question>{
        //questionsList에 각각의 질문에 해당하는 값이 담겨있음
        val questionsList = ArrayList<Question>()

        // que1
        val que1 = Question(
            1, "이 국기는 어느나라의 국기일까요?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria",
            1
        )
        questionsList.add(que1)

        //que2
        val que2 = Question(
            2, "이 국기는 어느나라의 국기일까요?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia",
            3
        )
        questionsList.add(que2)

        //que3
        val que3 = Question(
            3, "이 국기는 어느나라의 국기일까요?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize",
            2
        )
        questionsList.add(que3)

        //que4
        val que4 = Question(
            4, "이 국기는 어느나라의 국기일까요?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia",
            3
        )
        questionsList.add(que4)

        //que5
        val que5 = Question(
            5, "이 국기는 어느나라의 국기일까요?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland",
            3
        )
        questionsList.add(que5)


        //que6
        val que6 = Question(
            6, "이 국기는 어느나라의 국기일까요?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these",
            1
        )
        questionsList.add(que6)


        //que7
        val que7 = Question(
            7, "이 국기는 어느나라의 국기일까요?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India",
            4
        )
        questionsList.add(que7)


        //que8
        val que8 = Question(
            8, "이 국기는 어느나라의 국기일까요?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine",
            1
        )
        questionsList.add(que8)


        //que9
        val que9 = Question(
            9, "이 국기는 어느나라의 국기일까요?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America",
            2
        )
        questionsList.add(que9)




        return questionsList
    }


}