package com.github.libretube

import com.github.libretube.data.network.PipedApiDefinition
import com.github.libretube.data.network.obj.Channel
import com.github.libretube.data.network.obj.Instances
import com.github.libretube.data.network.obj.Login
import com.github.libretube.data.network.obj.Message
import com.github.libretube.data.network.obj.Playlist
import com.github.libretube.data.network.obj.SearchResult
import com.github.libretube.data.network.obj.StreamItem
import com.github.libretube.data.network.obj.Streams
import com.github.libretube.data.network.obj.Subscribe
import com.github.libretube.data.network.obj.Subscribed
import com.github.libretube.data.network.obj.Subscription
import com.github.libretube.data.network.obj.Token

class MockPipedApiDefinition : PipedApiDefinition {
    override suspend fun getTrending(region: String): List<StreamItem> {
        return listOf(StreamItem())
    }

    override suspend fun getStreams(videoId: String): Streams {
        return Streams()
    }

    override suspend fun getSearchResults(searchQuery: String, filter: String): SearchResult {
        return SearchResult()
    }

    override suspend fun getSuggestions(query: String): List<String> {
        return listOf(String())
    }

    override suspend fun getChannel(channelId: String): Channel {
        return Channel()
    }

    override suspend fun getChannelNextPage(channelId: String, nextPage: String): Channel {
        return Channel()
    }

    override suspend fun getPlaylist(playlistId: String): Playlist {
        return Playlist()
    }

    override suspend fun getPlaylistNextPage(playlistId: String, nextPage: String): Playlist {
        return Playlist()
    }

    override suspend fun login(login: Login): Token {
        return Token()
    }

    override suspend fun register(login: Login): Token {
        return Token()
    }

    override suspend fun getFeed(token: String?): List<StreamItem> {
        return listOf(StreamItem())
    }

    override suspend fun isSubscribed(channelId: String, token: String): Subscribed {
        return Subscribed()
    }

    override suspend fun subscriptions(token: String): List<Subscription> {
        return listOf(Subscription())
    }

    override suspend fun subscribe(token: String, subscribe: Subscribe): Message {
        return Message()
    }

    override suspend fun unsubscribe(token: String, subscribe: Subscribe): Message {
        return Message()
    }

    override suspend fun getInstances(url: String): List<Instances> {
        return listOf(Instances())
    }
}
