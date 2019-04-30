package edu.washington.zlin2016.quizdroid
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.LinearLayout.LayoutParams
import android.util.Log
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_quiz.*
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_answer.view.*


class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        var position = intent.getIntExtra("position", 0)
        val quiz = getIntent().getExtras().getSerializable("quiz") as? Quiz
        val quesList = quiz!!.questions
        var correctCount = intent.getIntExtra("correctCount", 0)
        var curQuestion = quesList!![position]
        question.text = curQuestion.text

        for(i in 0..curQuestion.answers.size-1){
            val radioButton = RadioButton(this)
            radioButton.text = curQuestion.answers[i]
            radioButton.id = i
                radioButton.layoutParams = LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            ansOptions.addView(radioButton)
        }

        submit.setOnClickListener{
            if(ansOptions.getCheckedRadioButtonId() != -1){
                val intent = Intent(this, AnswerActivity::class.java)

                intent.putExtra("input", ansOptions.getCheckedRadioButtonId())
                intent.putExtra("curpos", position)
                intent.putExtra("quiz", quiz)
                intent.putExtra("correctCount", correctCount)
                startActivity(intent)
            }
        }
    }
}
