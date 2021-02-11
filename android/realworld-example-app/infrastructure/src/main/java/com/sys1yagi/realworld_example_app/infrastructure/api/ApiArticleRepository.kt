package com.sys1yagi.realworld_example_app.infrastructure.api

import com.sys1yagi.realworld_example_app.domain.article.Article
import com.sys1yagi.realworld_example_app.domain.article.ArticleRepository

class ApiArticleRepository: ArticleRepository {
    override suspend fun getGlobalArticles(
        offset: Int,
        limit: Int,
        tag: String?,
        favorited: String?,
        author: String?
    ): List<Article> {
        TODO("Not yet implemented")
    }

    override suspend fun getFeedArticles(offset: Int, limit: Int): List<Article> {
        TODO("Not yet implemented")
    }
}
