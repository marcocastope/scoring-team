package com.marcocastope.scoringteam.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marcocastope.scoringteam.R
import com.marcocastope.scoringteam.model.Event
import com.squareup.picasso.Picasso

class EventListAdapter(private val events: MutableList<Event> = mutableListOf()) : RecyclerView.Adapter<EventListAdapter.MatchScoreHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchScoreHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_match_score_main, parent, false)
        return MatchScoreHolder(view)
    }

    override fun onBindViewHolder(holder: MatchScoreHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size

    fun setEvents(events: List<Event>) {
        this.events.clear()
        this.events.addAll(events)
        notifyDataSetChanged()
    }

    class MatchScoreHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val homeTeamShield = view.findViewById<ImageView>(R.id.homeTeamShield)
        private val homeTeamName = view.findViewById<TextView>(R.id.homeTeamName)
        private val homeScore = view.findViewById<TextView>(R.id.homeScore)
        private val awayTeamShield = view.findViewById<ImageView>(R.id.awayTeamShield)
        private val awayTeamName = view.findViewById<TextView>(R.id.awayTeamName)
        private val awayScore = view.findViewById<TextView>(R.id.awayScore)
        private val leagueName = view.findViewById<TextView>(R.id.leagueName)
        private val dateEvent = view.findViewById<TextView>(R.id.eventDate)
        private val eventStatus = view.findViewById<TextView>(R.id.eventStatus)

        fun bind(event: Event) {
            homeTeamName.text = event.strHomeTeam
            homeScore.text = event.intHomeScore
            awayTeamName.text = event.strAwayTeam
            awayScore.text = event.intAwayScore
            leagueName.text = event.strLeague
            dateEvent.text = event.dateEvent
            eventStatus.text = event.strStatus
            Picasso.get().load("https://www.thesportsdb.com/images/media/team/jersey/2019-" + event.idHomeTeam +"-Jersey.png").into(homeTeamShield)
            Picasso.get().load("https://www.thesportsdb.com/images/media/team/jersey/2019-" + event.idAwayTeam +"-Jersey.png").into(awayTeamShield)
        }
    }
}