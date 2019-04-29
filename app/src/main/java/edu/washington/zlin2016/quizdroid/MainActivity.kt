package edu.washington.zlin2016.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {


    private val math = Quiz(title="Math",
        desc = "Did you pass the third grade?",
        questions = arrayOf(
            Question(text = "What is 2+2?", answer = 1, answers= arrayOf(
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
                answer = 1,
                answers= arrayOf(
                    "Tony Stark",
                    "Obadiah Stane",
                    "A rock hit by Megadeth",
                    "Nobody knows"
                )
            ),
            Question(
                text = "Who founded the X-Men?",
                answer = 2,
                answers= arrayOf(
                    "Tony Stark",
                    "Professor X",
                    "The X-Institute",
                    "Erik Lensherr"
                )
            ),
            Question(
                text = "How did Spider-Man get his powers?",
                answer = 1,
                answers= arrayOf(
                    "He was bitten by a radioactive spider",
                    "He ate a radioactive spider",
                    "He is a radioactive spider",
                    "He looked at a radioactive spider"
                )
            )
        )
    )
    private val quizes = arrayOf(marvel, math)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = QuizRecyclerAdapter(quizes)
        quizRecyclerView.adapter = adapter
        quizRecyclerView.setHasFixedSize(true)

        adapter.onQuizClickedListener = { position, name ->
            Toast.makeText(this, "$name clicked!", Toast.LENGTH_SHORT).show()
        }


    }



}


class Quiz(val title:String, val desc: String, val questions : Array<Question>)

class Question(val text: String, val answers: Array<String>, val answer: Int)
