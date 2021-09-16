package com.marcocastope.scoringteam.ui.detail

import com.marcocastope.scoringteam.model.Team

class DetailContract {

    interface PresenterInterface {
        fun getTeamDetail(teamId: String)
    }

    interface ViewInterface {
        fun displayTeam(team: Team)
        fun displayError()
    }
}