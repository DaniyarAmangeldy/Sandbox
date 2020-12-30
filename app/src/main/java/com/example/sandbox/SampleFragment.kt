package com.example.sandbox

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class SampleFragment: Fragment(R.layout.fragment_sample) {

    private var onFragmentClickListener: OnFragmentClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentClickListener) {
            onFragmentClickListener = context
        }
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
        val childFragment = ChildFragment()
        childFragment.arguments = bundleOf(
            "Key1" to "value1",
            "Key2" to 2
        )
        childFragment.setTargetFragment(this, -1)
        requireFragmentManager().beginTransaction()
            .add(R.id.container, childFragment)
            .commit()
    }

    /*

               Activity                                          Activity
                  |                                                 |                 |
            FragmentSample  (case childFragmentManager)    FragmentSample <--> ChildFragment (case requireFragmentManager)
                  |
            ChildFragment
     */

    override fun onDestroyView() {
        view?.findViewById<RecyclerView>(R.id.recycler_view)?.adapter = null
        super.onDestroyView()
    }

    override fun onDetach() {
        onFragmentClickListener = null
        super.onDetach()
    }
}