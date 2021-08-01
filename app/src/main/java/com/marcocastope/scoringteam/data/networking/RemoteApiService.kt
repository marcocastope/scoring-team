package com.marcocastope.scoringteam.data.networking

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApiService {

    @GET("api/v1/json/1/eventspastleague.php?id=4328")
    fun getEvents(): Call<ResponseBody>

    @GET("api/v1/json/1/search_all_teams.php?l=English%20Premier%20League")
    fun getTeams(): Call<ResponseBody>

    @GET("api/v1/json/1/lookupteam.php")
    fun getTeam(@Query("id") id: String): Call<ResponseBody>
}