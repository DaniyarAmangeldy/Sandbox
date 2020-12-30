package com.example.sandbox

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class ChildFragment: Fragment(R.layout.fragment_sample) {

    private var onFragmentClickListener: OnFragmentClickListener? = null
    private val adapter = SimpleListAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onFragmentClickListener = (parentFragment as OnFragmentClickListener)
        onFragmentClickListener = (targetFragment as OnFragmentClickListener)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter
        requireArguments().get("KEY1")
    }

    override fun onDestroyView() {
        view?.findViewById<RecyclerView>(R.id.recycler_view)?.adapter = null
        super.onDestroyView()
    }

    override fun onDetach() {
        onFragmentClickListener = null
        super.onDetach()
    }
}

interface OnFragmentClickListener {
    operator fun invoke()
}