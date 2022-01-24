package com.sinthoras.randograf.cards

import androidx.annotation.StringRes
import java.io.Serializable

abstract class Card: Serializable {

    private var drawnWithRuin = false

    fun notifyPriorRuin() {
        drawnWithRuin = true
    }

    fun getDrawWithRuin() = drawnWithRuin

    abstract fun getDuration(): Int

    @StringRes
    abstract fun getTitle(): Int
}