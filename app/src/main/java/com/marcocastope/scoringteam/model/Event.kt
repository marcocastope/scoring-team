package com.marcocastope.scoringteam.model

data class Event(
    val idEvent: String,
    val strEvent: String,
    val strLeague: String,
    val strDescriptionEn: String,
    val strHomeTeam: String,
    val strAwayTeam: String,
    val intHomeScore: String,
    val intAwayScore: String,
    val intRound: String,
    val dateEvent: String,
    val strTimeLocal: String,
    val strVenue: String,
    val strStatus: String,
    val idHomeTeam: String,
    val idAwayTeam: String
)

