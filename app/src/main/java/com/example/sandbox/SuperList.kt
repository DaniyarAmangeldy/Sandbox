package com.example.sandbox

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.os.bundleOf

class SuperList {

    private val bundle: Bundle = bundleOf()

    inline fun <reified T> put(key: String) {
        when (T::class.java) {

        }
    }
}


inline fun <reified T> Context.intentFor(): Intent {
    return Intent(this, T::class.java)
}