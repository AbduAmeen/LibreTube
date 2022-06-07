package com.github.libretube.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.github.libretube.MainCoroutineRule
import com.github.libretube.data.network.PipedApiClient
import com.github.libretube.data.network.obj.StreamItem
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {
    @get:Rule
    val taskExecuteRule = InstantTaskExecutorRule()
    @get:Rule
    val mockkRule = MockKRule(this)
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @MockK
    private lateinit var apiClient: PipedApiClient

    @MockK
    private lateinit var savedStateHandle: SavedStateHandle

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setup() {
        coEvery { apiClient.fetchTrending() } returns listOf(StreamItem())
        homeViewModel = HomeViewModel(savedStateHandle, apiClient)
    }

    @Test
    fun updateFeed_notForcedRefresh_videoFeedIsNotEmpty() {
        homeViewModel.updateFeed(false)

        assertFalse(homeViewModel.videoFeed.value.isNullOrEmpty())
    }

    @Test
    fun updateFeed_forcedRefresh_videoFeedIsNotEmpty() {
        homeViewModel.updateFeed(true)

        assertFalse(homeViewModel.videoFeed.value.isNullOrEmpty())
    }
}
