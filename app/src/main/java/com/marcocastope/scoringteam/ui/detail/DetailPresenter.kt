package com.marcocastope.scoringteam.ui.detail

import com.marcocastope.scoringteam.data.networking.RemoteApi

class DetailPresenter(
    private val view: DetailContract.ViewInterface,
    private val remoteDataSource: RemoteApi
) : DetailContract.PresenterInterface {
    override fun getTeamDetail(teamId: String) {
        remoteDataSource.getTeam(teamId ?: "") { team, _ ->
            team?.let {
                view.displayTeam(it)
            }
        }
    }
}