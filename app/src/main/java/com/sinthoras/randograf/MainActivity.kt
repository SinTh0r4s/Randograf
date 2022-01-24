package com.sinthoras.randograf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.sinthoras.randograf.cards.Card
import com.sinthoras.randograf.cardviews.CardView
import com.sinthoras.randograf.cardviews.CardViewFactory

class MainActivity : AppCompatActivity() {

    lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        game = ViewModelProvider(this).get(Game::class.java)

        game.currentCard.observe(this, {
            showCard(it)
        })

        game.phaseColor.observe(this, {
            findViewById<View>(R.id.background).setBackgroundColor(ContextCompat.getColor(baseContext, it.color))
        })

        game.actionButtonText.observe(this, {
            findViewById<Button>(R.id.buttonAction)?.setText(it);
        })

        game.ellapsedTime.observe(this, {
            findViewById<TextView>(R.id.progressCounter).setText("Progress: " + it)
        })
    }

    fun onActionButtonClicked(view: View) {
        game.drawCard()
    }

    fun onNewGameClicked(view: View) {
        game.newGame()
    }

    fun showCard(card: Card) {
        findViewById<TextView>(R.id.veryUsefulLabel).setText(card.getTitle())

        val arguments = Bundle()
        arguments.putSerializable(CardView.PARAMETER_CARD_KEY, card)

        val cardView: CardView = CardViewFactory[card]
        cardView.arguments = arguments

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.cardLayout, cardView)
            commit()
        }
    }
}
