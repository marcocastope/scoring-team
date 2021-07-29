package com.marcocastope.scoringteam.model.responses

import com.marcocastope.scoringteam.model.Team

data class TeamResponse(val teams: List<Team> = emptyList())