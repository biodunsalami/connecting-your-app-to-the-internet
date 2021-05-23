package com.biodun.connectingyourapptotheinternet.api

import com.squareup.moshi.Json

data class CharacterResponse(

    @Json(name = "results")
    val character : List<Character>
)