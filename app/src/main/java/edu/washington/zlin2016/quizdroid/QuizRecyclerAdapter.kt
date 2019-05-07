package edu.washington.zlin2016.quizdroid

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.quiz_item.view.*


class QuizRecyclerAdapter(var quizes:Array<Quiz>) : RecyclerView.Adapter<QuizRecyclerAdapter.QuizViewHolder>(){

    var onQuizClickedListener: ((position: Int, name: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewHolderType: Int): QuizViewHolder =
        QuizViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.quiz_item, parent, false))


    override fun getItemCount(): Int = quizes.size

    override fun onBindViewHolder(viewHolder: QuizViewHolder, position: Int) {
        viewHolder.bindView(quizes[position].title, quizes[position].short, position)
    }

    inner class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(personName: String, short:String, position: Int) {
            itemView.quizName.text = personName
            itemView.shortDes.text = short
            itemView.setOnClickListener { onQuizClickedListener?.invoke(position, personName) }
        }
    }

}