package com.example.sandbox

import android.view.View

class OnListenerImpl: View.OnClickListener {
    override fun onClick(v: View?) {
        print(v.toString())
    }
}

