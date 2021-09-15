package com.marcocastope.scoringteam.ui.main

import com.marcocastope.scoringteam.model.Event
import com.marcocastope.scoringteam.model.Team

class MainContract {

    interface PresenterInterface {
        fun getEvents()
        fun getTeams()
    }

    interface ViewInterface {
        fun displayEvents(events: List<Event>)
        fun displayTeams(teams: List<Team>)
    }
}