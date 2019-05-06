package edu.washington.zlin2016.quizdroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class QuizListFragment : Fragment() {

    private val quizes = arrayOf(marvel, math, physics)

    interface OnQuizSelectedListener{
        fun OnQuizSelected(quiz:Quiz)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_quiz_list, container, false)

        val adapter = QuizRecyclerAdapter(quizes)
        val quizRecyclerView = rootView.findViewById(R.id.quizRecyclerView) as RecyclerView
        quizRecyclerView.adapter = adapter
        quizRecyclerView.setHasFixedSize(true)


        adapter.onQuizClickedListener = { position, _ ->
            (activity as OnQuizSelectedListener).OnQuizSelected(quizes[position])
        }


        return rootView
    }
}
