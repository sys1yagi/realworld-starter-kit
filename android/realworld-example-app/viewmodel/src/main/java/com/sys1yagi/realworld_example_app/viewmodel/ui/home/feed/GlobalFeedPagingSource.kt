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

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val offset = params.key ?: 0
        val limit = PAGE_SIZE
        return try {
            val result = articleRepository.getGlobalArticles(offset, limit)
            LoadResult.Page(
                data = result,
                prevKey = offset.takeIf { it > 0 }?.let {
                    it - PAGE_SIZE
                },
                nextKey = offset + result.size
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
