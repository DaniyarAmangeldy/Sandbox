package com.example.sandbox

import android.app.Activity
import android.content.Context
import android.widget.Toast
import java.lang.StringBuilder


fun <T: Activity> T.printClass() {
    print(this)
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun doWork(param: String, action: (name: String) -> String) {
    action.invoke(param)

    val smth = "asd".apply { "dsa" } // asd
    val let = "asd".let { "dsa" } // dsa
    val run = "asd".run { return@run "dsa" } // dsa
    val also = "asd".also {  "dsa" } // asd
}

// Kotlin DSL  - Domain Specified Language

class MyClass {

    companion object {
        @JvmStatic
        fun main(vararg args: String): Unit {
            val myString = createString {
                append("Text")
                appendLn("TextLn")
            }
            print(myString)  //  MyClass Text\nTextLn

        }
    }
}

class MyStringBuilder {

    val result = StringBuilder()

    fun append(text: String) {
        result.append(text)
    }

    fun appendLn(text: String) {
        result.append("\n$text")
    }
}

fun <T> T.createString(builder: MyStringBuilder.() -> Unit): String {

    fun anotherFuntion() {

    }

    anotherFuntion()
    val myBuilder = MyStringBuilder()
    myBuilder.builder()

    return myBuilder.result.toString()
}