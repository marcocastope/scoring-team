package com.marcocastope.scoringteam.ui.main

import com.marcocastope.scoringteam.data.networking.RemoteApi

class MainPresenter(private val view: MainContract.ViewInterface, private val remoteDataSource: RemoteApi) : MainContract.PresenterInterface {
    override fun getEvents() {
        remoteDataSource.getEvents { events, error ->
            view.displayEvents(events)
        }
    }

    override fun getTeams() {
        remoteDataSource.getTeams { teams, error ->
            view.displayTeams(teams)
        }
    }

}