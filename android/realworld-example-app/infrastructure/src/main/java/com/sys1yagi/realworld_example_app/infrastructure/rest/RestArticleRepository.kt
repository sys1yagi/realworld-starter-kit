package com.sys1yagi.realworld_example_app.infrastructure.rest

import com.sys1yagi.realworld_example_app.domain.article.Article
import com.sys1yagi.realworld_example_app.domain.article.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class RestArticleRepository(
    private val endpoint: Endpoint
) : ArticleRepository {
    override suspend fun getGlobalArticles(
        offset: Int,
        limit: Int,
        tag: String?,
        favorited: String?,
        author: String?
    ): List<Article> = withContext(Dispatchers.IO) {
        val response = endpoint.getArticles(offset, limit, author, favorited, tag)
        if (response.isSuccessful) {
            response.body()?.articles ?: emptyList()
        } else {
            throw IOException(response.errorBody()?.string())
        }
    }

    override suspend fun getFeedArticles(offset: Int, limit: Int): List<Article> {
        TODO("Not yet implemented")
    }
}
