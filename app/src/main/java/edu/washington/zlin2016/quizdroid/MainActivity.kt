package edu.washington.zlin2016.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable



class MainActivity : AppCompatActivity(){
    private val quizes = arrayOf(marvel, math, physics)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = QuizRecyclerAdapter(quizes)
        quizRecyclerView1.adapter = adapter
        quizRecyclerView1.setHasFixedSize(true)

        adapter.onQuizClickedListener = { position, name ->
            val intent = Intent(this, QuizIntroActivity::class.java)
            intent.putExtra("quiz", quizes[position])
            startActivity(intent)
        }
    }


//    override fun OnQuizSelected(quiz: Quiz) {
//        val quiz_intro = QuizIntroFragment.newInstance(quiz)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.container, quiz_intro, "QUIZ_INTRO_FRAGMENT")
//            .commit()
//    }
}
