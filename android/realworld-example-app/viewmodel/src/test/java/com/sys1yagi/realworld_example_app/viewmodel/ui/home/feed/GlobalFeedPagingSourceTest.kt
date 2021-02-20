package com.sys1yagi.realworld_example_app.viewmodel.ui.home.feed

import androidx.paging.PagingSource
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GlobalFeedPagingSourceTest {
    @Test
    fun success(): Unit = runBlocking {
        val source = GlobalFeedPagingSource(
            mockk {
                coEvery {
                    getGlobalArticles(any(), any())
                } returns listOf(mockk(), mockk())
            }
        )
        val result = source.load(
            PagingSource.LoadParams.Append(0, 20, true)
        )

        Truth.assertThat(result).isInstanceOf(PagingSource.LoadResult.Page::class.java)
    }
}
