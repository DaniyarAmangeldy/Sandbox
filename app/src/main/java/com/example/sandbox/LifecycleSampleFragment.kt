package com.example.sandbox

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe

class LifecycleSampleFragment: Fragment() {

    private val viewModel: LifecycleSampleViewModel by viewModels()
    private val activityViewModel: LifecycleSampleViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.myLiveData.observe(viewLifecycleOwner) {

        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
    }
}