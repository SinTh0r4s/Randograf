package com.sinthoras.randograf

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.sinthoras.randograf.cards.Card
import com.sinthoras.randograf.phases.GameStart
import com.sinthoras.randograf.phases.Phase

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
            phase = phase.nextPhase
            drawCard(phase.cover)
        }
        else {
            drawCard(phase.drawCard())
        }
    }

    fun drawCard(card: Card) {
        findViewById<TextView>(R.id.veryUsefulLabel).setText(card.title)
    }
}