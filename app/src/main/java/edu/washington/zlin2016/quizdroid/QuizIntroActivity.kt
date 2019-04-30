package edu.washington.zlin2016.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.Intent
import kotlinx.android.synthetic.main.activity_quiz_intro.*



class QuizIntroActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_intro)

        var quiz = getIntent().getExtras().getSerializable("quiz") as? Quiz
        quizName.text = quiz!!.title.toString()
        quiz_intro.text = quiz!!.desc.toString()
        var ques = quiz.questions

        start.setOnClickListener{
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("quiz", quiz)
            intent.putExtra("position", 0)
            intent.putExtra("correctCount", 0)
            startActivity(intent)
        }

    }


}
