package com.sys1yagi.realworld_example_app.domain.article

import com.sys1yagi.realworld_example_app.domain.profile.Profile

data class Article(
    val id: String,
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val favorited: Boolean,
    val favoritesCount: Int,
    val createdAt: String,
    val updatedAt: String,
    val tagList: List<String>,
    val author: Profile
)
