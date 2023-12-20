package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat



class QuizQuestionActivity : AppCompatActivity(), OnClickListener{

    //현재위치를 정함
    private var mCurrentPosition : Int = 1
    //질문의 ArrayList?
    private var mQuestionsList : ArrayList<Question>? = null
    //어떤 옵션을 선택했는지 확인하기위해
    private var mSelectedOptionPosition : Int = 0

    private var mUserName :String? = null   //사용자이름
    private var mCorrectAnswers : Int = 0   //정답개수

    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null
    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null

    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour : TextView? = null
    private var btnSubmit : Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)


        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        // mQuestionsList 로드
        mQuestionsList = Constants.getQuestions()

        setQuestion()

        //추가!!
        // MainActivity에서 보냈던 USER_NAME을 받아옴
        mUserName = intent.getStringExtra(Constants.USER_NAME)

    }

    private fun setQuestion() {

        // Constants.kt에 적은 데이터값이 나오도록 연결
        // index 1번에 해당하는 질문부터 시작하고싶기때문에 1로 설정
//        mCurrentPosition = 1
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        //tvQuestion 들어갈값 표시
        tvQuestion?.text = question.question
        //ivImage 들어갈값 표시 (image를 int값으로 지정했기때문에 setImageResource로 표시)
        ivImage?.setImageResource(question.image)
        //progressBar 들어갈값 표시
        progressBar?.progress = mCurrentPosition
        // tvProgress 들어갈값 표시
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        //tvOption 4개에 들어갈값 표시
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour


        // 마지막화면버튼에는 finish버튼 표시
        // 현재위치랑 mQuestionsList의 사이즈가 같다면 if문 실행
        // 현재위치가 마지막이라면 if문 실행
        if (mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "제출하기"
        }

        // 옵션값 리셋(기본값으로)
        defaultOptionsView()
    }


    // 옵션버튼 누르기전 기본값 (defaultOptionsView변수 생성)
    private fun defaultOptionsView(){
        //옵션버튼의 TextView
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0,it)   //index=0, it=실제 optionOne의 텍스트뷰
        }
        tvOptionTwo?.let {
            options.add(1,it)   //index=1, it=실제 tvOptionTwo의 텍스트뷰
        }
        tvOptionThree?.let {
            options.add(2,it)   //index=1, it=실제 tvOptionThree의 텍스트뷰
        }
        tvOptionFour?.let {
            options.add(3,it)   //index=1, it=실제 tvOptionFour의 텍스트뷰
        }

        // for 반복문으로 option안의 option을 확인
        for(option in options){
            //options(옵션버튼의 TextView)의 색상이 바뀌도록
            option.setTextColor(Color.parseColor("#7A8089"))
            // Typeface를 DEFAULT값으로 설정해서 옵션 선택했을때 바뀌도록
            option.typeface = Typeface.DEFAULT
            //배경
            option.background = ContextCompat.getDrawable(
                this, R.drawable.option
            )
        }
    }


    //옵션을 눌렀을때 보여주는값
    private fun selectedOptionView(tv:TextView, selectedOptionNum : Int){
        //defaultOptionsView를 불러와서 모든버튼을 기본으로 돌아가게함
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        //텍스트뷰 색상,볼드체,배경 설정
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option
        )
    }


    override fun onClick(v: View?) {
        //textview를 눌렀을때
        when(v?.id){
            //tv_option_one를 눌렀을때 실행할옵션
            R.id.tv_option_one -> {
                tvOptionOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option_two -> {
                tvOptionTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option_three -> {
                tvOptionThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_four -> {
                tvOptionFour?.let {
                    selectedOptionView(it,4)
                }
            }



            // btn_submit을 눌렀을때 실행할옵션
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0){   //선택한 옵션의 위치를 기본값인 0으로 두고 (현재위치)
                    mCurrentPosition++               //mCurrentPosition++ 으로 현재위치에 1을 더해서 다음질문으로 넘어가게

                    //다음질문으로
                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                           setQuestion()
                        }
                        else -> {   // 다음질문이 없을때 (마지막 질문일때)
                            val intent = Intent(this, ResultActivity::class.java)
                            // putExtra를 사용해서 ResultActivity로 USER_NAME, CORRECT_ANSWERS, TOTAL_QUESTIONS 값들을 보냄(이름,맞힌질문의개수,전체질문의개수)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)

                    //정답을 선택했는지 아닌지 if문을 통해 확인
                    //정답이 아닌걸 선택했다면
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        // if문으로 선택한 옵션에 빨간배경표시
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option)

                        // 정답을 선택했다면, 정답개수 증가
                    }else{
                        mCorrectAnswers++
                    }
                    // 동시에 선택한 옵션을 초록색으로 바꿈
                    // 정답은 정답을 선택한경우든지 오답을 선택한경우든지 무조건 표시하는거기때문에 else문 나와서 작성
                    answerView(question.correctAnswer, R.drawable.correct_option)


                    //mCurrentPosition이 질문의개수와 같다면(마지막질문이라면)
                    if(mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit?.text = "FINISH"
                    }else{  //마지막 질문이 아니라면
                        btnSubmit?.text = "다음질문"
                    }

                    //선택한 옵션의 위치를 0으로 돌아가게 (이걸 안하면 지금 선택한 옵션이 그대로 남아서 에러뜸)
                    mSelectedOptionPosition = 0
                }


            }
        }
    }


    // 옵션 눌렀을때 정답값
    private fun answerView(answer:Int, drawableView: Int){
        //정답이 1번이면 1로,2번이면 2로,,,
        when(answer){
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}










