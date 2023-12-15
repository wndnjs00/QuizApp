package com.example.quizapp


//퀴즈에 들어갈 데이터클래스 생성 (데이터클래스의 속성 정하기)
data class Question(
    val id : Int,               //id
    val question : String,      //질문
    val image : Int,            //이미지 (int타입으로 이미지만들수있음)
    val optionOne : String,     //정답체크옵션1
    val optionTwo : String,     //정답체크옵션2
    val optionThree : String,   //정답체크옵션3
    val optionFour : String,    //정답체크옵션4
    val correctAnswer : Int     //정답


)
