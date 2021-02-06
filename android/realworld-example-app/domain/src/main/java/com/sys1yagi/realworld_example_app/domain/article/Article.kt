package com.sys1yagi.realworld_example_app.domain.article

import com.sys1yagi.realworld_example_app.domain.profile.Profile

data class Article(
    val author: Profile,
    val body: String,
    val createdAt: String,
    val description: String,
    val favorited: Boolean,
    val favoritesCount: Int,
    val slug: String,
    val tagList: List<String>,
    val title: String,
    val updatedAt: String
)
