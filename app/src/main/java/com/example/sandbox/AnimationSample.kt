package com.example.sandbox

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AnimationSample: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.image)
        val animatorOne = ObjectAnimator.ofInt(0, 1).apply {
            duration = 1000
            addUpdateListener { value ->
                imageView.alpha = (value.animatedValue as Int).toFloat()
            }
        }
        animatorOne
            .addListener(object: Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {
                    TODO("Not yet implemented")
                }

                override fun onAnimationEnd(animation: Animator?) {
                    TODO("Not yet implemented")
                }

                override fun onAnimationCancel(animation: Animator?) {
                    TODO("Not yet implemented")
                }

                override fun onAnimationRepeat(animation: Animator?) {
                    TODO("Not yet implemented")
                }

            })

        imageView.animate()
            .alpha(1F)
            .setDuration(200)

        AnimatorSet().playSequentially(
            animatorOne,
            animatorOne,
            animatorOne
        )
    }
}