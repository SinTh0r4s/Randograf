package com.sinthoras.randograf

import android.os.Build

enum class PhaseColors(val colorId: Int) {
    GAME_START(R.color.game_start),
    SPRING(R.color.spring),
    SUMMER(R.color.summer),
    AUTUMN(R.color.autumn),
    WINTER(R.color.winter),
    GAME_END(R.color.game_end);

    fun toArgb() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            MainActivity.getAppContext().resources.getColor(colorId, null)
        else
            MainActivity.getAppContext().resources.getColor(colorId) // Deprecated in API level 23
}