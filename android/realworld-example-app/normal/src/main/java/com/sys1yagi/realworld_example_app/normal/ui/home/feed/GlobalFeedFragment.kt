package com.sys1yagi.realworld_example_app.normal.ui.home.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sys1yagi.realworld_example_app.normal.databinding.FragmentGlobalFeedBinding

class GlobalFeedFragment: Fragment() {

    private var _binding: FragmentGlobalFeedBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGlobalFeedBinding.inflate(inflater, container, false)
        return binding.root
    }
}
