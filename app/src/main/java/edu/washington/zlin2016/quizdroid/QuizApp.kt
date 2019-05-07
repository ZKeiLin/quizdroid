package edu.washington.zlin2016.quizdroid

import android.app.Application
import android.content.res.Configuration
import android.util.Log

class QuizApp : Application() {

    val data = Data()

    override fun onCreate() {
        super.onCreate()

        Log.i("Applciation", "QuizApp was loaded successfully.")
    }

    companion object{
        private var INSTANCE: QuizApp? = null

        fun getSingletonInstance(): QuizApp {
            if(INSTANCE == null){
                INSTANCE = QuizApp()
            }
            return INSTANCE!!
        }
    }


}

