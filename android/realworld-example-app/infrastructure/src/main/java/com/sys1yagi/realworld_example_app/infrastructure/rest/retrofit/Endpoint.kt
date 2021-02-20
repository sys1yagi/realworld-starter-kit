package com.sys1yagi.realworld_example_app.infrastructure.rest

import io.realworld.api.models.responses.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {
    @GET("articles")
    suspend fun getArticles(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("author") author: String? = null,
        @Query("favourited") favourited: String? = null,
        @Query("tag") tag: String? = null
    ): Response<ArticlesResponse>
}
