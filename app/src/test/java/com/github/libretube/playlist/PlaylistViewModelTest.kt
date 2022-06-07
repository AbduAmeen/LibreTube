package com.github.libretube.playlist

import androidx.lifecycle.SavedStateHandle
import com.github.libretube.ViewModelTest
import com.github.libretube.data.network.PipedApiClient
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class PlaylistViewModelTest : ViewModelTest() {
    @MockK
    private lateinit var apiClient: PipedApiClient
    @MockK
    private lateinit var savedStateHandle: SavedStateHandle

    private lateinit var viewModel: PlaylistViewModel

    @Before
    fun setup() {
        coEvery { apiClient.fetchPlaylist(any()) } returns null
        every { savedStateHandle.get<String>("id") } returns "url"
        viewModel = PlaylistViewModel(apiClient, savedStateHandle)
    }

    @Test
    fun shuffle() {
        val initialValue = viewModel.shuffleEvent.value
        viewModel.shuffle()
        assertNotEquals(initialValue, viewModel.shuffleEvent.value)
    }

    @Test
    fun playAll() {
        val initialValue = viewModel.playAllEvent.value
        viewModel.playAll()
        assertNotEquals(initialValue, viewModel.playAllEvent.value)
    }
}
