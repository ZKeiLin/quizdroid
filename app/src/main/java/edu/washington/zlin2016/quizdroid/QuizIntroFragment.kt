package edu.washington.zlin2016.quizdroid


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class QuizIntroFragment : Fragment() {

    companion object {

        val  QUIZ_PARCEL_KEY= "quiz_parcel"

        fun newInstance(quiz: Quiz): QuizIntroFragment {

            val args = Bundle().apply {
                putParcelable(QUIZ_PARCEL_KEY, quiz)
            }
            val fragment = QuizIntroFragment().apply {
                arguments = args
            }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView =  inflater.inflate(R.layout.fragment_activity_quiz_intro, container, false)

        arguments?.let {
            val quiz = it.getParcelable<Quiz>(QUIZ_PARCEL_KEY) as Quiz
            quiz.let {
                var titleView = rootView.findViewById<TextView>(R.id.quizName)
                titleView.text = quiz.title
                rootView.findViewById<TextView>(R.id.quiz_intro).text = quiz.desc
            }

            rootView.findViewById<Button>(R.id.start).setOnClickListener{
                val quizDetail = QuizDetailFragment.newInstance(quiz, 0, 0)
                activity?.supportFragmentManager!!.beginTransaction()
                    .replace(R.id.container, quizDetail, "QUIZ_DETAIL_FRAGMENT")
                    .commit()
            }

        }

        return rootView
    }


}
