package com.example.sandbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FragmentsSampleActivity
    : AppCompatActivity(R.layout.activity_fragment_sample), OnFragmentClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, SampleFragment())
            .commit()
    }

    override fun invoke() {
        toast("Fragment Clicked!")
    }
}