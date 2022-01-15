package com.sinthoras.randograf

import androidx.annotation.ColorRes

enum class PhaseColors(val colorId: Int) {
    GAME_START(R.color.game_start),
    SPRING(R.color.spring),
    SUMMER(R.color.summer),
    AUTUMN(R.color.autumn),
    WINTER(R.color.winter),
    GAME_END(R.color.game_end);

    @ColorRes
    fun getColor() = colorId
}
