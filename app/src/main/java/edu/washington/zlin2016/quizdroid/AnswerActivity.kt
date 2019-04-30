package edu.washington.zlin2016.quizdroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_answer.*
import android.content.Intent
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_intro.*


class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_answer)
//        if(savedInstanceState != null){
//            correctCount = savedInstanceState.getInt("correctCount")
//        }

        val quiz = getIntent().getExtras().getSerializable("quiz") as? Quiz
        val position = getIntent().getIntExtra("curpos", 0 )
        val correct = quiz!!.questions[position].answer

        val userInput = getIntent().getIntExtra("input", 0)
        var correctCount = getIntent().getIntExtra("correctCount", 0)
        val total = quiz!!.questions.size


        if (userInput == correct){
            correctCount = correctCount+1
        }

        userAns.text = "Your Selection:  "+ quiz!!.questions[position].answers[userInput]
        correctAns.text = "Correct Answer :  "+ quiz!!.questions[position].answers[correct]
        ratio.text = "You won "+ correctCount + " of  "+ total

        if(position >= total-1){
            next.text = "Finish"
        }else {
            next.text = "Next"
        }

        next.setOnClickListener {
            if(position >= total-1){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra("position", position+1)
                intent.putExtra("quiz", quiz)
                intent.putExtra("correctCount", correctCount)
                startActivity(intent)
            }
        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("correctCount", 0)
//        outState.putString("quizName", "")
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
//        super.onRestoreInstanceState(savedInstanceState)
//        correctCount = savedInstanceState?.getInt("correctCount") ?:0
////        corr.setText(userText)
//
//    }

}
