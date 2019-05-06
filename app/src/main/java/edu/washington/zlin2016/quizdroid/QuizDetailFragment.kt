package edu.washington.zlin2016.quizdroid


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_quiz_detail.*


class QuizDetailFragment : Fragment() {


    companion object {
        val  QUESTION_PARCEL_KEY= "questions_parcel"

        fun newInstance(quiz: Quiz, position:Int, correctCount:Int): QuizDetailFragment {
            val args = Bundle().apply {
                putParcelable(QUESTION_PARCEL_KEY, quiz)
                putInt("position", position)
                putInt("correctCount", correctCount)
            }

            val fragment = QuizDetailFragment().apply {
                setArguments(args)
            }

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_quiz_detail, container, false)

        arguments?.let {
            val position = it.getInt("position")
            val quiz = it.getParcelable(QuizDetailFragment.QUESTION_PARCEL_KEY) as Quiz
            val questions = quiz.questions
            val correctCount = it.getInt("correctCount")

            questions.let {
                val question = questions[position]
                rootView.findViewById<TextView>(R.id.question).text = question.text

                val ansOptions = rootView.findViewById<RadioGroup>(R.id.ansOptions)

                for(i in 0..question.answers.size-1){
                    val radioButton = RadioButton(rootView.context)
                    radioButton.text = question.answers[i]
                    radioButton.id = i
                    radioButton.layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    ansOptions.addView(radioButton)
                }

                ansOptions.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { _, _ ->
                    submit.visibility = View.VISIBLE
                })

                rootView.findViewById<Button>(R.id.submit).setOnClickListener{
                    val selected = ansOptions.getCheckedRadioButtonId()
                    if(selected != -1){
                        val answerFrag = AnswerFragment.newInstance(position, selected, quiz, correctCount)
                        activity?.supportFragmentManager!!.beginTransaction()
                            .replace(R.id.container, answerFrag, "ANSWER_FRAGMENT")
                            .commit()
                    }
                }
            }
        }

        return rootView
    }


}
