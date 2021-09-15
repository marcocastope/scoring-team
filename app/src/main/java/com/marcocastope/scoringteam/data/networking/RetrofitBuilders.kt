package com.marcocastope.scoringteam.data.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun buildOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .build()

fun buildRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://www.thesportsdb.com/")
        .addConverterFactory(MoshiConverterFactory.create().asLenient())
        .client(buildOkHttpClient())
        .build()
}

fun buildApiService(): RemoteApiService =
    buildRetrofit().create(RemoteApiService::class.java)