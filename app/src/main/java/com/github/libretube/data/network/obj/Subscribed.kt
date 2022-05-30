package com.github.libretube.data.network.obj

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Subscribed(
    var subscribed: Boolean? = null
)
