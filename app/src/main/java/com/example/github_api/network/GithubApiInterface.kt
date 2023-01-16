package com.example.github_api.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface GithubApiInterface {

    @GET("users/yothio/repos")
    suspend fun getRepositories(): Response<List<Repository>>
}


data class Repository(val name: String, var language: String?)