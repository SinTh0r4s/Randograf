package com.sinthoras.randograf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.sinthoras.randograf.cards.Card
import com.sinthoras.randograf.phases.GameStart
import com.sinthoras.randograf.phases.Phase

class MainActivity : AppCompatActivity() {

    var phase: Phase = GameStart()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onActionButtonClicked(view: View) {
        if(phase.isOver) {
            updatePhase(phase.nextPhase)
        }
        else {
            showCard(phase.drawCard())
        }
        displayElapsedTime(phase.elapsedTime)
    }

    fun onNewGameClicked(view: View) {
        updatePhase(GameStart())
        displayElapsedTime(phase.elapsedTime)
    }

    fun showCard(card: Card) {
        findViewById<TextView>(R.id.veryUsefulLabel).setText(card.title)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.cardLayout, card)
            commit()
        }
    }

    fun displayElapsedTime(elapsedTime: String) {
        findViewById<TextView>(R.id.progressCounter).setText("Progress: " + elapsedTime)
    }

    private fun updatePhase(phase: Phase) {
        this.phase = phase
        findViewById<View>(R.id.background).setBackgroundColor(ContextCompat.getColor(baseContext, phase.phaseColor.getColor()))
        showCard(phase.cover)
    }
}
