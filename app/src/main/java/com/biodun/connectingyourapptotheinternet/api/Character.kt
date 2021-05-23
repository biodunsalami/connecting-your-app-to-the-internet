package com.biodun.connectingyourapptotheinternet.api

import com.squareup.moshi.Json

data class Character (

    @Json(name = "id")
    val characterId : Int,

    @Json(name = "name")
    val characterName : String,

    @Json(name = "status")
    val characterStatus : String,

    @Json(name = "species")
    val characterSpecie : String,

    @Json(name = "image")
    val characterImage : String
)