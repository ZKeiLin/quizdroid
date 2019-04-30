package edu.washington.zlin2016.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable



class MainActivity : AppCompatActivity() {


    private val physics = Quiz(title="Physics",
        desc = "Because Physics!",
        questions = arrayOf(
            Question(text = "What is fire?",
                answer = 0,
                answers= arrayOf(
                    "One of the four classical elements",
                    "A magical reaction given to us by God",
                    "A band that hasn't yet been discovered",
                    "Fire! Fire! Fire! heh-heh"
                )
            )))

    private val math = Quiz(title="Math",
        desc = "Did you pass the third grade?",
        questions = arrayOf(
            Question(text = "What is 2+2?", answer = 0, answers= arrayOf(
                "4",
                "22",
                "An irrational number",
                "Nobody knows"
            )
        )))

    private val marvel = Quiz(title="Marvel Super Heroes",
        desc = "Avengers, Assemble!",
        questions = arrayOf(
            Question(
                text = "Who is Iron Man?",
                answer = 0,
                answers= arrayOf(
                    "Tony Stark",
                    "Obadiah Stane",
                    "A rock hit by Megadeth",
                    "Nobody knows"
                )
            ),
            Question(
                text = "Who founded the X-Men?",
                answer = 1,
                answers= arrayOf(
                    "Tony Stark",
                    "Professor X",
                    "The X-Institute",
                    "Erik Lensherr"
                )
            ),
            Question(
                text = "How did Spider-Man get his powers?",
                answer = 0,
                answers= arrayOf(
                    "He was bitten by a radioactive spider",
                    "He ate a radioactive spider",
                    "He is a radioactive spider",
                    "He looked at a radioactive spider"
                )
            )
        )
    )

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


class Quiz (val title:String, val desc: String, val questions : Array<Question>) : Serializable

class Question(val text: String, val answers: Array<String>, val answer: Int) : Serializable
