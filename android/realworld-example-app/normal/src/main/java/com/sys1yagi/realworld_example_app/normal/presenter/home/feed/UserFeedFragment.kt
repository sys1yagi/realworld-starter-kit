package com.sys1yagi.realworld_example_app.normal.presenter.home.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sys1yagi.realworld_example_app.normal.databinding.FragmentUserFeedBinding

class UserFeedFragment: Fragment() {

    private var _binding: FragmentUserFeedBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserFeedBinding.inflate(inflater, container, false)
        return binding.root
    }
}
