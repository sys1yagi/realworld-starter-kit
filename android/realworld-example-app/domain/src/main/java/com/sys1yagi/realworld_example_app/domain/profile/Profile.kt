package com.sys1yagi.realworld_example_app.domain.profile

data class Profile(
    val username: String,
    val bio: String?,
    val image: String,
    val following: Boolean,
)
