package com.marcocastope.scoringteam.data.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit

fun buildOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .build()

fun buildRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://www.thesportsdb.com/")
        .client(buildOkHttpClient())
        .build()
}

fun buildApiService(): RemoteApiService =
    buildRetrofit().create(RemoteApiService::class.java)