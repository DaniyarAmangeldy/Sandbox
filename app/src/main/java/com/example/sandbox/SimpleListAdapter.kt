package com.example.sandbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class SimpleListAdapter(
    val onCheckChanged: (position: Int, checked: Boolean) -> Unit
): ListAdapter<SomeData, SimpleViewHolder>(SimpleDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        return SimpleViewHolder(
            onCheckChanged,
            LayoutInflater.from(parent.context).inflate(R.layout.item_sample, parent, false))
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun onBindViewHolder(
        holder: SimpleViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        if (payloads.isEmpty()) return
        holder.bindPayload(payloads[position] as Boolean)
    }
}

class SimpleDiffUtil: DiffUtil.ItemCallback<SomeData>() {

    override fun areItemsTheSame(oldItem: SomeData, newItem: SomeData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SomeData, newItem: SomeData): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: SomeData, newItem: SomeData): Any? {
        return newItem.checked
    }
}