package com.marcocastope.scoringteam.data.networking

import com.google.gson.Gson
import com.marcocastope.scoringteam.model.Event
import com.marcocastope.scoringteam.model.Team
import com.marcocastope.scoringteam.model.responses.EventResponse
import com.marcocastope.scoringteam.model.responses.TeamResponse
import com.marcocastope.scoringteam.model.responses.TeamsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteApi(private val apiService: RemoteApiService) {

    companion object {
        const val API_IMAGES = "https://www.thesportsdb.com/api/v1/json/1/lookupequipment.php?id="
    }

    fun getEvents(onEventsReceived: (List<Event>, Throwable?) -> Unit) {
        apiService.getEvents().enqueue(object : Callback<EventResponse> {
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                val responseData = response.body()
                if (responseData == null || responseData.events.isEmpty()) {
                    onEventsReceived(emptyList(), NullPointerException("no data response."))
                } else {
                    onEventsReceived(responseData.events, null)
                }
            }

            override fun onFailure(call: Call<EventResponse>, error: Throwable) {
                onEventsReceived(emptyList(), error)
            }
        })
    }

    fun getTeams(onTeamReceived: (List<Team>, Throwable?) -> Unit) {
        apiService.getTeams().enqueue(object : Callback<TeamsResponse> {
            override fun onResponse(call: Call<TeamsResponse>, response: Response<TeamsResponse>) {
                val responseData = response.body()
                if (responseData == null || responseData.teams.isEmpty()) {
                    onTeamReceived(emptyList(), NullPointerException("no data available"))
                    return
                } else {
                    onTeamReceived(responseData.teams, null)
                }
            }

            override fun onFailure(call: Call<TeamsResponse>, error: Throwable) {
                onTeamReceived(emptyList(), error)
            }
        })
    }

    fun getTeam(id: String, onTeamReceived: (Team?, Throwable?) -> Unit) {
        apiService.getTeam(id).enqueue(object : Callback<TeamsResponse> {
            override fun onResponse(call: Call<TeamsResponse>, response: Response<TeamsResponse>) {
                val responseData = response.body()
                if (responseData == null) {
                    onTeamReceived(null, NullPointerException("no data response"))
                } else {
                    with(responseData) {
                        onTeamReceived(Team(
                            idTeam = teams[0].idTeam,
                            strTeam = teams[0].strTeam,
                            intFormedYear = teams[0].intFormedYear,
                            strLeague = teams[0].strLeague,
                            strStadium = teams[0].strStadium,
                            strStadiumThumb = teams[0].strStadiumThumb,
                            strStadiumLocation = teams[0].strStadiumLocation,
                            intStadiumCapacity = teams[0].intStadiumCapacity,
                            strDescriptionEN = teams[0].strDescriptionEN,
                            strCountry = teams[0].strCountry,
                            strTeamBadge = teams[0].strTeamBadge,
                            strTeamJersey = teams[0].strTeamJersey,
                            strTeamLogo = teams[0].strTeamLogo,
                            strSport = teams[0].strSport), null)
                    }
                }
            }

            override fun onFailure(call: Call<TeamsResponse>, error: Throwable) {
                onTeamReceived(null, error)
            }
        })
    }
}