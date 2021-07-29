package com.marcocastope.scoringteam.data.networking

import com.marcocastope.scoringteam.model.Event
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface RemoteApiService {

    @GET("api/v1/json/1/eventspastleague.php?id=4328")
    fun getEvents(): Call<ResponseBody>

    @GET("https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League")
    fun getTeams(): Call<ResponseBody>
}