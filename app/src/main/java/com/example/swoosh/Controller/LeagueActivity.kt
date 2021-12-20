package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.EXTRA_PLAYER
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    //if we change orientation we did not save the instance for the object
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!

    }

        fun onMensClicked(view: View) {
            womensLeagueButton.isChecked = false
            coedLeagueButton.isChecked = false
            player.league = "mens"
        }

        fun onWomensClicked(view: View) {
            mensLeagueButton.isChecked = false
            coedLeagueButton.isChecked = false
            player.league = "womens"
        }

        fun onCoedClicked(view: View) {
            mensLeagueButton.isChecked = false
            womensLeagueButton.isChecked = false
            player.league = "co-ed"
        }

        fun leagueNextClicked(view: View) {
            if (player.league != "") {
                val skillIntent = Intent(this, SkillActivity::class.java)
                skillIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(skillIntent)
            } else {
                Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
            }
        }
}