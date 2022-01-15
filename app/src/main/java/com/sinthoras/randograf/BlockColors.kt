package com.sinthoras.randograf

import androidx.annotation.ColorRes

enum class BlockColors(val colorId: Int) {
    VILLAGE(R.color.village),
    FOREST(R.color.forest),
    RIVER(R.color.river),
    FIELD(R.color.fields),
    MONSTER(R.color.monster),
    ALL(R.color.all);

    @ColorRes
    fun getColor() = colorId
}
