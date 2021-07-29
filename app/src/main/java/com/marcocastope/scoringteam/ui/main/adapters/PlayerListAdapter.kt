package com.marcocastope.scoringteam.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marcocastope.scoringteam.R
import com.marcocastope.scoringteam.model.Player

class PlayerListAdapter(private val players: MutableList<Player>) : RecyclerView.Adapter<PlayerListAdapter.PlayerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_player_main, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount(): Int = players.size

    class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val playerName = view.findViewById<TextView>(R.id.playerName)
        private val playerTeam = view.findViewById<TextView>(R.id.playerTeam)
        private val playerImage = view.findViewById<TextView>(R.id.playerImage)

        fun bind(player: Player) {
            playerName.text = player.name
            playerTeam.text = player.team
        }
    }
}