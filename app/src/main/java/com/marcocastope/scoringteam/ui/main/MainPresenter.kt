package com.marcocastope.scoringteam.ui.main

import com.marcocastope.scoringteam.data.networking.RemoteApi
import com.marcocastope.scoringteam.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter(
    private val view: MainContract.ViewInterface,
    private val remoteDataSource: RemoteApi
) : MainContract.PresenterInterface {
    override fun getEvents() {
        GlobalScope.launch(Dispatchers.Main) {
            val result = remoteDataSource.getEvents()
            if (result is Result.Success) {
                view.displayEvents(result.data)
            } else {
                view.displayEventsError()
            }
        }
    }

    override fun getTeams() {
        GlobalScope.launch(Dispatchers.Main) {
            val result = remoteDataSource.getTeams()
            if (result is Result.Success) {
                view.displayTeams(result.data)
            } else {
                view.displayTeamsError()
            }
        }
    }

}