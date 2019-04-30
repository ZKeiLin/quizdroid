package edu.washington.zlin2016.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable



class MainActivity : AppCompatActivity() {

    private val quizes = arrayOf(marvel, math, physics)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = QuizRecyclerAdapter(quizes)
        quizRecyclerView.adapter = adapter
        quizRecyclerView.setHasFixedSize(true)

        adapter.onQuizClickedListener = { position, name ->
            val intent = Intent(this, QuizIntroActivity::class.java)
            intent.putExtra("quiz", quizes[position])
            startActivity(intent)
        }
    }
}
