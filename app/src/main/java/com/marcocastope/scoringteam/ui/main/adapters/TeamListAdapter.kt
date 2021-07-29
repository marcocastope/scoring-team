package com.marcocastope.scoringteam.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marcocastope.scoringteam.R
import com.marcocastope.scoringteam.model.Team
import com.squareup.picasso.Picasso

class TeamListAdapter(private val teams: MutableList<Team> = mutableListOf()) : RecyclerView.Adapter<TeamListAdapter.TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_team_main, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    override fun getItemCount(): Int = teams.size

    fun setTeams(teams: List<Team>) {
        this.teams.clear()
        this.teams.addAll(teams)
        notifyDataSetChanged()
    }

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val teamBadge = view.findViewById<ImageView>(R.id.teamBadged)
        private val teamName = view.findViewById<TextView>(R.id.teamName)

        fun bind(team: Team) {
            teamName.text = team.strTeam
            Picasso.get().load(team.strTeamBadge).into(teamBadge)
        }
    }
}