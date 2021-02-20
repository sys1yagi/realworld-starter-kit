package com.sys1yagi.realworld_example_app.normal.presenter.home.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.sys1yagi.realworld_example_app.normal.databinding.FragmentGlobalFeedBinding
import com.sys1yagi.realworld_example_app.viewmodel.ui.home.feed.GlobalFeedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class GlobalFeedFragment : Fragment() {

    @Inject
    lateinit var globalFeedViewModel: GlobalFeedViewModel

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArticleAdapter()
        binding.articleList.adapter = adapter

        lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest { loadStates ->
                binding.progressCircular.isVisible = loadStates.refresh is LoadState.Loading
            }
        }

        lifecycleScope.launch {
            globalFeedViewModel.globalFeedPager.collect {
                adapter.submitData(it)
            }
        }
    }
}
