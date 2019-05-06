package edu.washington.zlin2016.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.Intent
import kotlinx.android.synthetic.main.fragment_activity_quiz_intro.*



class QuizIntroActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_intro)

        var quiz = getIntent().getExtras().getParcelable("quiz") as Quiz
        val quiz_intro = QuizIntroFragment.newInstance(quiz)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, quiz_intro, "QUIZ_INTRO_FRAGMENT")
            .commit()
//
//
//        start.setOnClickListener{
//            Log.i("press Button", "presssssssss")
//            this.StartOnClick(quiz.questions, 0)
////            val intent = Intent(this, QuizActivity::class.java)
////            intent.putExtra("quiz", quiz)
////            intent.putExtra("position", 0)
////            intent.putExtra("correctCount", 0)
////            startActivity(intent)
//        }
    }

//    override fun StartOnClick(questions: Array<Question>, position: Int) {
//        val quizDetail = QuizDetailFragment.newInstance(questions, position)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.container, quizDetail, "QUIZ_DETAIL_FRAGMENT")
//            .commit()
//    }


}

