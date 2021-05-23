package com.biodun.connectingyourapptotheinternet.api

class Repository (private val apiService: ApiService) {

    suspend fun getCharacters() = apiService.getCharacters()
}