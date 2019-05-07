package edu.washington.zlin2016.quizdroid



class Data : TopicRepository {

    var quizes = ArrayList<Quiz>()

    override fun getQuizes(): Array<Quiz> {
        var arr = arrayOfNulls<Quiz>(quizes.size)
        return quizes.toArray(arr)
    }

    override fun add(quiz: Quiz) {
        quizes.add(quiz)
    }

    fun loadData() {
        quizes.add(physics)
        quizes.add(math)
        quizes.add(marvel)
    }
}

val physics = Quiz(title="Physics",
    short = "Physics!",
    desc = "Because Physics!",
    questions = arrayOf(
        Question(text = "What is fire?",
            answer = 0,
            answers= arrayOf(
                "One of the four classical elements",
                "A magical reaction given to us by God",
                "A band that hasn't yet been discovered",
                "Fire! Fire! Fire! heh-heh"
            )
        )))

val math = Quiz(title="Math",
    short = "Math!",
    desc = "Did you pass the third grade?",
    questions = arrayOf(
        Question(text = "What is 2+2?", answer = 0, answers= arrayOf(
            "4",
            "22",
            "An irrational number",
            "Nobody knows"
        )
        )))

val marvel = Quiz(title="Marvel Super Heroes",
    short = "Marvel!",
    desc = "Avengers, Assemble!",
    questions = arrayOf(
        Question(
            text = "Who is Iron Man?",
            answer = 0,
            answers= arrayOf(
                "Tony Stark",
                "Obadiah Stane",
                "A rock hit by Megadeth",
                "Nobody knows"
            )
        ),
        Question(
            text = "Who founded the X-Men?",
            answer = 1,
            answers= arrayOf(
                "Tony Stark",
                "Professor X",
                "The X-Institute",
                "Erik Lensherr"
            )
        ),
        Question(
            text = "How did Spider-Man get his powers?",
            answer = 0,
            answers= arrayOf(
                "He was bitten by a radioactive spider",
                "He ate a radioactive spider",
                "He is a radioactive spider",
                "He looked at a radioactive spider"
            )
        )
    )
)


interface TopicRepository {

    fun add(quiz: Quiz)

    fun getQuizes(): Array<Quiz>

}