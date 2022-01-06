package com.sinthoras.randograf

import android.graphics.Color
import androidx.core.graphics.toColor

enum class Colors(val color: Color) {
    VILLAGE(R.color.village.toColor()),
    FOREST(R.color.forest.toColor()),
    RIVER(R.color.river.toColor()),
    FIELD(R.color.fields.toColor()),
    JOKER(R.color.joker.toColor());
}