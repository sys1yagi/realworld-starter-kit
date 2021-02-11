package com.sys1yagi.realworld_example_app.domain.article

interface ArticleRepository {
    suspend fun getGlobalArticles(
        offset: Int,
        limit: Int,
        tag: String? = null,
        favorited: String? = null,
        author: String? = null
    ): List<Article>

    suspend fun getFeedArticles(offset: Int, limit: Int): List<Article>
}
