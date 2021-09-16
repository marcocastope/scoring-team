package com.marcocastope.scoringteam.ui.detail

import com.marcocastope.scoringteam.data.networking.RemoteApi
import com.marcocastope.scoringteam.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailPresenter(
    private val view: DetailContract.ViewInterface,
    private val remoteDataSource: RemoteApi
) : DetailContract.PresenterInterface {
    override fun getTeamDetail(teamId: String) {
        GlobalScope.launch(Dispatchers.Main) {
            val result = remoteDataSource.getTeam(teamId ?: "")
            if (result is Result.Success) {
                view.displayTeam(result.data)
            } else {
                view.displayError()
            }
        }
    }
}