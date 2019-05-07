package edu.washington.zlin2016.quizdroid

interface TopicRepository {

    fun add(quiz: Quiz)

    fun getQuizes(): Array<Quiz>

}