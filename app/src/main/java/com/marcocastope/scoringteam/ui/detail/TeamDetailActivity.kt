package com.marcocastope.scoringteam.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.marcocastope.scoringteam.App
import com.marcocastope.scoringteam.R
import com.marcocastope.scoringteam.ui.main.MainActivity
import com.squareup.picasso.Picasso

class TeamDetailActivity : AppCompatActivity() {
    private val remoteApi = App.remoteApi
    private lateinit var teamDetailDescription: TextView
    private lateinit var teamDetailName: TextView
    private lateinit var teamDetailCountry: TextView
    private lateinit var teamDetailLeagueName: TextView
    private lateinit var teamDetailStadium: TextView
    private lateinit var teamDetailSport: TextView
    private lateinit var teamDetailStadiumLocation: TextView
    private lateinit var teamDetailStadiumThumb: ImageView
    private lateinit var teamDetailJerseyThumb: ImageView
    private lateinit var teamDetailFormedYear: TextView
    private lateinit var teamDetailBadged: ImageView
    private var id: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)
        initUi()
        id = intent.getStringExtra(MainActivity.DETAIL_ACTIVITY)
        loadTeamDetail(id)
    }

    private fun initUi() {
        teamDetailDescription = findViewById(R.id.teamDetailDescription)
        teamDetailName = findViewById(R.id.teamDetailName)
        teamDetailCountry = findViewById(R.id.teamDetailCountry)
        teamDetailLeagueName = findViewById(R.id.teamDetailLeagueName)
        teamDetailStadium = findViewById(R.id.teamDetailStadium)
        teamDetailSport = findViewById(R.id.teamDetailSport)
        teamDetailStadiumThumb = findViewById(R.id.teamDetailStadiumThumb)
        teamDetailJerseyThumb = findViewById(R.id.teamDetailJerseyThumb)
        teamDetailStadiumLocation = findViewById(R.id.teamDetailStadiumLocation)
        teamDetailFormedYear = findViewById(R.id.teamDetailFormedYear)
        teamDetailBadged = findViewById(R.id.teamDetailBadged)
    }

    private fun loadTeamDetail(id: String?) {
        remoteApi.getTeam(id ?: "") { team, error ->
            if (team != null) {
                teamDetailDescription.text = team.strDescriptionEN
                teamDetailName.text = team.strTeam
                teamDetailCountry.text = team.strCountry
                teamDetailLeagueName.text = team.strLeague
                teamDetailStadium.text = team.strStadium
                teamDetailSport.text = team.strSport
                teamDetailStadiumLocation.text = team.strStadiumLocation
                teamDetailFormedYear.text = team.intFormedYear
                Picasso.get().load(team.strTeamBadge).into(teamDetailBadged)
                Picasso.get().load(team.strStadiumThumb).into(teamDetailStadiumThumb)
                Picasso.get().load(team.strTeamJersey).into(teamDetailJerseyThumb)
            }
        }
    }
}