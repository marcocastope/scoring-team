package com.marcocastope.scoringteam.data.networking

import com.google.gson.Gson
import com.marcocastope.scoringteam.model.Event
import com.marcocastope.scoringteam.model.Team
import com.marcocastope.scoringteam.model.responses.EventResponse
import com.marcocastope.scoringteam.model.responses.TeamResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteApi(private val apiService: RemoteApiService) {

    companion object {
        const val API_IMAGES = "https://www.thesportsdb.com/api/v1/json/1/lookupequipment.php?id="
    }

    private val gson = Gson()

    fun getEvents(onEventsReceived: (List<Event>, Throwable?) -> Unit) {
        apiService.getEvents().enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val responseData = response.body()?.string()
                if (responseData == null) {
                    onEventsReceived(emptyList(), NullPointerException("no data response."))
                    return
                }
                val responseJson = gson.fromJson(responseData, EventResponse::class.java)
                if (responseJson != null && responseJson.events.isNotEmpty())  {
                    onEventsReceived(responseJson.events, null)
                } else {
                    onEventsReceived(emptyList(), NullPointerException("no data response."))
                }
            }

            override fun onFailure(call: Call<ResponseBody>, error: Throwable) {
                onEventsReceived(emptyList(), error)
            }
        })
    }

    fun getTeams(onTeamReceived: (List<Team>, Throwable?) -> Unit) {
        apiService.getTeams().enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val responseJson = response.body()?.string()
                if (responseJson == null) {
                    onTeamReceived(emptyList(), NullPointerException("no data available"))
                    return
                }
                val data = gson.fromJson(responseJson, TeamResponse::class.java)
                if (data != null && data.teams.isNotEmpty()) {
                    onTeamReceived(data.teams, null)
                } else {
                    onTeamReceived(emptyList(), NullPointerException("no data available"))
                }
            }

            override fun onFailure(call: Call<ResponseBody>, error: Throwable) {
                onTeamReceived(emptyList(), error)
            }

        })
    }
}