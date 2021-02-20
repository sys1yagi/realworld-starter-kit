package com.sys1yagi.realworld_example_app.viewmodel.ui.home.feed

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sys1yagi.realworld_example_app.domain.article.Article
import com.sys1yagi.realworld_example_app.domain.article.ArticleRepository

class GlobalFeedPagingSource(
    private val articleRepository: ArticleRepository
) : PagingSource<Int, Article>() {

    companion object {
        private const val PAGE_SIZE = 20
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val offset = params.key ?: 0
        return try {
            val result = articleRepository.getGlobalArticles(offset, PAGE_SIZE)
            LoadResult.Page(
                data = result,
                prevKey = offset,
                nextKey = offset + PAGE_SIZE
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
