package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    var mCurrentPosition:Int=1
    var mQuestionsList:ArrayList<Questions>?=null
    var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null
    var isSelected=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constant.USER_NAME)
        mQuestionsList=Constant.getQuestion()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }
    private fun setQuestion()
    {

        val questions:Questions?=mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()
        if(mCurrentPosition==mQuestionsList!!.size)
        {
            btn_submit.text="FINISH"
        }
        else
        {
            btn_submit.text="SUBMIT"
        }
        progressBar.progress=mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        tv_question.text = questions!!.question
        iv_img.setImageResource(questions.image)
        tv_option_one.text = questions.optionOne
        tv_option_two.text = questions.optionTwo
        tv_option_three.text = questions.optionThree
        tv_option_four.text = questions.optionFour
    }

    private fun defaultOptionsView()
    {
        isSelected=false
        val options=ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for (option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_opt_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.tv_option_one ->{
                selectedOptionView(tv_option_one,1)
            }
            R.id.tv_option_two->{
                selectedOptionView(tv_option_two,2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tv_option_three,3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(tv_option_four,4)
            }
            R.id.btn_submit ->{

                if(isSelected==true) {
                    if (mSelectedOptionPosition == 0) {
                        mCurrentPosition++

                        when {
                            mCurrentPosition <= mQuestionsList!!.size -> {
                                setQuestion()
                            }
                            else -> {
                                val intent =
                                    Intent(this@QuizQuestionActivity, FinalResultActivity::class.java)
                                intent.putExtra(Constant.USER_NAME, mUserName)
                                intent.putExtra(Constant.CORRECT_ANSWERS, mCorrectAnswers)
                                intent.putExtra(Constant.TOTAL_QUESTIONS, mQuestionsList!!.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                    } else {
                        val question = mQuestionsList?.get(mCurrentPosition - 1)
                        if (question!!.correctAnswer != mSelectedOptionPosition) {
                            answerView(mSelectedOptionPosition, R.drawable.wrong_ans_border_bg)
                        } else {
                            mCorrectAnswers++
                        }
                        answerView(question.correctAnswer, R.drawable.correct_ans_border_bg)

                        if (mCurrentPosition == mQuestionsList!!.size) {
                            btn_submit.text = "FINISH"
                        } else {
                            btn_submit.text = "GO TO NEXT QUESTION"
                        }
                        mSelectedOptionPosition = 0
                    }
                }
                else
                {
                    Toast.makeText(this,"please select the answer", Toast.LENGTH_SHORT).show()

                }

            }
        }
    }

    /**
     * A function to set the view of selected option view.
     */
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()
        isSelected=true
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionActivity,
            R.drawable.selected_ans_border_bg
        )
    }
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
        }
    }
}
