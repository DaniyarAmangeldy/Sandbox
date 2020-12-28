package com.example.sandbox

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {

    private val simpleItemAdapter = SimpleItemAdapter(::onCheckChanged)

    private val list = mutableListOf(
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa"),
        SomeData("Hello"),
        SomeData("World"),
        SomeData("Vasya"),
        SomeData("Rasteryawa")
    )

    private fun onCheckChanged(position: Int, checked: Boolean) {
        list[position].checked = checked
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<RecyclerView>(R.id.list_view)
        listView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        listView.adapter = simpleItemAdapter
        listView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        simpleItemAdapter.list = list
        Handler().postDelayed(
            {
                list.drop(1)
                simpleItemAdapter.notifyDataSetChanged()
            }, 3000)
    }
}