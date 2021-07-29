package com.marcocastope.scoringteam.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marcocastope.scoringteam.App
import com.marcocastope.scoringteam.R
import com.marcocastope.scoringteam.ui.main.adapters.EventListAdapter
import com.marcocastope.scoringteam.ui.main.adapters.TeamListAdapter

class MainActivity : AppCompatActivity() {
    private val remoteApi = App.remoteApi
    private val eventAdapter by lazy { EventListAdapter() }
    private val teamAdapter by lazy { TeamListAdapter() }
    private lateinit var eventListRecyclerView: RecyclerView
    private lateinit var teamListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
        remoteApi.getEvents { events, error ->
            eventAdapter.setEvents(events)
        }

        remoteApi.getTeams { teams, error ->
            teamAdapter.setTeams(teams)
        }
    }

    private fun initUi() {
        eventListRecyclerView = findViewById(R.id.eventsRecyclerview)
        eventListRecyclerView.layoutManager = LinearLayoutManager(this)
        eventListRecyclerView.adapter = eventAdapter

        teamListRecyclerView = findViewById(R.id.teamRecyclerview)
        teamListRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        teamListRecyclerView.adapter = teamAdapter
    }
}