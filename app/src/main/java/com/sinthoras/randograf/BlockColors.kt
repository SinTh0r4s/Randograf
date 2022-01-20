package com.sinthoras.randograf

import androidx.annotation.ColorRes

enum class BlockColors(@ColorRes val colorId: Int): Color {
    VILLAGE(R.color.village),
    FOREST(R.color.forest),
    RIVER(R.color.river),
    FIELD(R.color.fields),
    MONSTER(R.color.monster),
    ALL(R.color.all);

    @ColorRes
    override fun getColor() = colorId
}
