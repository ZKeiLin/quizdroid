package edu.washington.zlin2016.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_intro.*



class QuizIntroActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_intro)

//        val bundle : Bundle? = intent.extras
        var quiz = getIntent().getExtras().getSerializable("quiz") as? Quiz
        Log.i("passs", quiz!!.title.toString())
        quizName.text = quiz!!.title.toString()
        quiz_intro.text = quiz!!.desc.toString()
    }

}
