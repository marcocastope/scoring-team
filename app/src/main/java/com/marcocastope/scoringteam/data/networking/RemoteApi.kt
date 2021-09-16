package com.marcocastope.scoringteam.data.networking

import com.marcocastope.scoringteam.model.Event
import com.marcocastope.scoringteam.model.Result
import com.marcocastope.scoringteam.model.Result.Failure
import com.marcocastope.scoringteam.model.Result.Success
import com.marcocastope.scoringteam.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteApi(private val apiService: RemoteApiService) {

    companion object {
        const val API_IMAGES = "https://www.thesportsdb.com/api/v1/json/1/lookupequipment.php?id="
    }

    suspend fun getEvents(): Result<List<Event>> = withContext(Dispatchers.IO) {
        try {
            val data = apiService.getEvents().execute().body()
            if (data == null || data.events.isEmpty()) {
                Failure(NullPointerException("no data response."))
            } else {
                Success(data.events)
            }

        } catch (error: Throwable) {
            Failure(error)
        }
    }

    suspend fun getTeams(): Result<List<Team>> = withContext(Dispatchers.IO) {
        try {
            val data = apiService.getTeams().execute().body()
            if (data == null || data.teams.isEmpty()) {
                Failure(NullPointerException("no data available"))
            } else {
                Success(data.teams)
            }
        } catch (error: Throwable) {
            Failure(error)
        }
    }

    suspend fun getTeam(id: String): Result<Team> = withContext(Dispatchers.IO) {
        try {
            val data = apiService.getTeam(id).execute().body()
            if (data == null) {
                Failure(NullPointerException("no data response"))
            } else {
                val team = with(data) {
                    Team(
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
                        strSport = teams[0].strSport
                    )
                }
                Success(team)
            }
        } catch (error: Throwable) {
            Failure(error)
        }
    }
}