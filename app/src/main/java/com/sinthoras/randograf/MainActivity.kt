package com.sinthoras.randograf

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.sinthoras.randograf.cards.Card
import com.sinthoras.randograf.phases.GameStart
import com.sinthoras.randograf.phases.Phase
import com.sinthoras.randograf.phases.seasons.Summer

class MainActivity : AppCompatActivity() {
    companion object {
        private lateinit var instance: MainActivity

        fun getAppContext(): Context = instance.applicationContext
        fun getResourceString(name: Int) : String = instance.applicationContext.resources.getString(name)
    }
    var phase: Phase = GameStart()

    override fun onCreate(savedInstanceState: Bundle?) {
        instance = this
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onActionButtonClicked(view: View) {
        if(phase.isOver) {
            updatePhase(phase.nextPhase)
        }
        else {
            drawCard(phase.drawCard())
        }
        displayElapsedTime(phase.elapsedTime)
    }

    fun onNewGameClicked(view: View) {
        updatePhase(GameStart())
        displayElapsedTime(phase.elapsedTime)
    }

    fun drawCard(card: Card) {
        findViewById<TextView>(R.id.veryUsefulLabel).setText(card.title)
        findViewById<CardView>(R.id.cardView).setCard(card);
    }

    fun displayElapsedTime(elapsedTime: String) {
        findViewById<TextView>(R.id.progressCounter).setText("Progress: " + elapsedTime)
    }

    fun updatePhase(phase: Phase) {
        this.phase = phase
        findViewById<View>(R.id.background).setBackgroundColor(phase.phaseColor.toArgb())
        drawCard(phase.cover)
    }
}