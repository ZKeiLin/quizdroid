package edu.washington.zlin2016.quizdroid


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class AnswerFragment : Fragment() {

    private var correctCount = 0

    companion object {
        fun newInstance(position: Int, selected: Int, quiz:Quiz): AnswerFragment {
            val args = Bundle().apply {
                putInt("position", position)
                putInt("selected", selected)
                putParcelable("quiz", quiz)
            }

            val fragment = AnswerFragment().apply {
                setArguments(args)
            }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val rootView = inflater.inflate(R.layout.fragment_answer, container, false)

        arguments?.let {
            val position = it.getInt("position") as Int
            val selected = it.getInt("selected") as Int
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

            rootView.findViewById<TextView>(R.id.ratio).text = "You won "+ correctCount + " of  "+ total

            val next = rootView.findViewById<TextView>(R.id.next)
            if(position >= total-1){
                next.text = "Finish"
            }else {
                next.text = "Next"
            }
        }
        return rootView
    }

}
