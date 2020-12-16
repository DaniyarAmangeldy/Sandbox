package com.example.sandbox

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class MainActivity(
    private val onClickListener: OnListenerImpl
) : AppCompatActivity(), View.OnClickListener by onClickListener {

    private val value: MyStringBuilder by lazy {
        return@lazy MyStringBuilder()
    }

    private var valueObservable: String? by Delegates.observable(null) { kProperty: KProperty<*>, old: String?, new: String? ->
        toast(new.orEmpty())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast("Hello World!")

        value

        valueObservable = "Hello Danik"


        doWork("asd") { name ->
            name.apply { print(name) }
        }

        val plusResult = 123f + 321

        val isBeforeDate = Date().compareTo(Date())

        val builder = MyStringBuilder()
        builder.invoke()

        inlinedFunction() // <-- print("Hello World")
    }
}