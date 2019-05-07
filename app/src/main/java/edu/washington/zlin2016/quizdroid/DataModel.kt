package edu.washington.zlin2016.quizdroid

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
class Quiz (var title:String, var short: String,  var desc: String, var questions : Array<Question>) : Parcelable

@Parcelize
class Question(val text: String, val answers: Array<String>, val answer: Int) : Parcelable
