package com.marcocastope.scoringteam.model.responses

import com.marcocastope.scoringteam.model.Team

data class TeamsResponse(val teams: List<Team> = emptyList())