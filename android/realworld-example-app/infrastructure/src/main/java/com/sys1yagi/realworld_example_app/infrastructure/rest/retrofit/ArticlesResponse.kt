package io.realworld.api.models.responses


import com.sys1yagi.realworld_example_app.domain.article.Article

data class ArticlesResponse(
    val articles: List<Article>,
    val articlesCount: Int
)
