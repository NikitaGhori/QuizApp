package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_final_result.*

class FinalResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val userName = intent.getStringExtra(Constant.USER_NAME)
        tv_name.text = userName

        val totalQues = intent.getIntExtra(Constant.TOTAL_QUESTIONS, 0)
        val correctAns = intent.getIntExtra(Constant.CORRECT_ANSWERS, 0)

        tv_score.text = "Your Score is $correctAns out of $totalQues."

        btn_finish.setOnClickListener {
            startActivity(Intent(this@FinalResultActivity, MainActivity::class.java))
            finish()
        }
    }
}
