package com.sys1yagi.realworld_example_app.normal.di

import com.sys1yagi.realworld_example_app.domain.article.ArticleRepository
import com.sys1yagi.realworld_example_app.infrastructure.rest.Endpoint
import com.sys1yagi.realworld_example_app.infrastructure.rest.RestArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class) // Installs FooModule in the generate SingletonComponent.
object SingletonModule {
    @Provides
    fun articleRepository(endpoint: Endpoint): ArticleRepository {
        return RestArticleRepository(endpoint)
    }

    @Provides
    fun endpoint(): Endpoint {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(2, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .client(okHttpClient)
            //            .baseUrl("http://10.0.2.2:8080")
            .baseUrl("https://conduit.productionready.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Endpoint::class.java)
    }
}
