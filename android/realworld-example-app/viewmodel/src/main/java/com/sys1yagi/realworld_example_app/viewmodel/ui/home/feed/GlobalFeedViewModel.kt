package com.sys1yagi.realworld_example_app.viewmodel.ui.home.feed

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.sys1yagi.realworld_example_app.domain.article.ArticleRepository
import javax.inject.Inject

class GlobalFeedViewModel
@Inject constructor(
    private val articleRepository: ArticleRepository
) : ViewModel() {
    val globalFeedPager = Pager(
        PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
        ),
        initialKey = 0,
    ) {
        GlobalFeedPagingSource(articleRepository)
    }.flow
}
