package edu.washington.zlin2016.quizdroid

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class AnswerFragment : Fragment() {



    companion object {
        fun newInstance(position: Int, selected: Int, quiz:Quiz, correctCount: Int): AnswerFragment {
            val args = Bundle().apply {
                putInt("position", position)
                putInt("selected", selected)
                putParcelable("quiz", quiz)
                putInt("correctCount", correctCount)
            }

            val fragment = AnswerFragment().apply {
                setArguments(args)
            }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        super.onCreate(savedInstanceState);


        val rootView = inflater.inflate(R.layout.fragment_answer, container, false)

        arguments?.let {
            var position = it.getInt("position")
            val selected = it.getInt("selected")
            var correctCount = it.getInt("correctCount")
            val quiz = it.getParcelable("quiz") as Quiz
            val question = quiz.questions[position]
            val answer = question.answer
            val total = quiz.questions.size
            val corIndicator  = rootView.findViewById<TextView>(R.id.corIndicator)

            if (selected == answer){
                correctCount = correctCount+1
                corIndicator.text = "Correct!"
            }else{
                corIndicator.text = "Oops!"
            }

            rootView.findViewById<TextView>(R.id.userAns).text = "Your Selection:  "+ question.answers[selected]
            rootView.findViewById<TextView>(R.id.correctAns).text = "Correct Answer :  "+  question.answers[answer]
            rootView.findViewById<TextView>(R.id.ratio).text = "You won "+ correctCount + " of  "+ total

            val next = rootView.findViewById<TextView>(R.id.next)
            if(position >= total-1){
                next.text = "Finish"
            }else {
                next.text = "Next"
            }

            next.setOnClickListener {
                if(position >= total-1){
                    val intent = Intent(activity, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    val quizFrag  = QuizDetailFragment.newInstance(quiz, position+1, correctCount)
                    activity?.supportFragmentManager!!.beginTransaction()
                        .replace(R.id.container, quizFrag, "QUIZ_DETAIL_FRAGMENT")
                        .commit()
                }
            }
        }
        return rootView
    }
}


