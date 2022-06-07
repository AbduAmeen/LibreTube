package com.github.libretube.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.libretube.MainCoroutineRule
import com.github.libretube.data.network.PipedApiClient
import com.github.libretube.data.network.obj.SearchResult
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchViewModelTest {

    @get:Rule
    val taskExecuteRule = InstantTaskExecutorRule()
    @get:Rule
    val mockkRule = MockKRule(this)
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @MockK
    private lateinit var apiClient: PipedApiClient

    lateinit var viewModel: SearchViewModel

    @Before
    fun setup() {
        coEvery { apiClient.fetchSearch(any(), any()) } returns SearchResult(listOf())
        coEvery { apiClient.fetchSuggestions(any()) } returns listOf("test")
        viewModel = SearchViewModel(apiClient)
    }
    @Test
    fun searchTermChanged() {
        viewModel.searchTermChanged("test")

        assertEquals("test", viewModel.searchTerm.value)
        assertFalse(viewModel.suggestions.value.isNullOrEmpty())
    }

    @Test
    fun search_defaultSearchFilter_returnSearchResult() {
        viewModel.search("test")

        assertNotNull(viewModel.results.value)
    }
}
