package com.marcocastope.scoringteam.model.responses

import com.marcocastope.scoringteam.model.Event

data class EventResponse(
    val events: List<Event> = emptyList()
)
