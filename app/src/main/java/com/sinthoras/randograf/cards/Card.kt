package com.sinthoras.randograf.cards

import android.view.View
import android.widget.ImageView
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.sinthoras.randograf.R

abstract class Card protected constructor(contentLayerID: Int) : Fragment(contentLayerID) {
    private var drawnWithRuin = false
    fun notifyPriorRuin() {
        drawnWithRuin = true
    }

    abstract fun getDuration(): Int

    @StringRes
    abstract fun getTitle(): Int

    override fun onResume() {
        super.onResume()
        view?.findViewById<ImageView>(R.id.ruinIcon)?.visibility = if(drawnWithRuin) View.VISIBLE else View.GONE
    }
}