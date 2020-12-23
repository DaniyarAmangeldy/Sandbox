package com.example.sandbox

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager

class ConstraintLayoutAnimationSample: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val image = findViewById<ImageView>(R.id.image)
        val set = ConstraintSet().apply {
            clone(constraintLayout)
            setVisibility(R.id.image, View.GONE)
            connect(R.id.name, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
        }

        Handler().postDelayed({
            val transition = AutoTransition()
            transition.duration = 10_000
            transition.interpolator = AccelerateDecelerateInterpolator()
            TransitionManager.beginDelayedTransition(constraintLayout, transition)
            set.applyTo(constraintLayout)
        }, 2000)
    }
}