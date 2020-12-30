package com.example.sandbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleItemAdapter(
    val onCheckChanged: (position: Int, checked: Boolean) -> Unit
): RecyclerView.Adapter<SimpleViewHolder>() {

    var list: List<SomeData> = emptyList()

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        return SimpleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_sample, parent, false))
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.bind(list[position])
    }

//    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int, payloads: MutableList<Any>) {
//        super.onBindViewHolder(holder, position, payloads)
//        if (payloads.isEmpty()) return
//        holder.bindPayload(payloads.first() as String)
//    }

    override fun onViewRecycled(holder: SimpleViewHolder) {
        holder.unbind()
        super.onViewRecycled(holder)
    }

    override fun getItemCount(): Int = list.size
}

class SimpleViewHolder(view: View): RecyclerView.ViewHolder(view) {

    init {
        itemView.findViewById<CheckBox>(R.id.name).setOnCheckedChangeListener { buttonView, isChecked -> }
    }

    fun bind(name: SomeData) {
        itemView.findViewById<TextView>(R.id.name).text = name.name
        itemView.findViewById<CheckBox>(R.id.name).isChecked = name.checked
    }

    fun bindPayload(checked: Boolean) {
        itemView.findViewById<CheckBox>(R.id.name).isChecked = checked
    }

    fun unbind() {
        itemView.findViewById<CheckBox>(R.id.name).isChecked = false
        itemView.findViewById<TextView>(R.id.name).text = null
    }
}

data class SomeData(
    val name: String,
    var checked: Boolean = false,
    val id: Int = 0
)