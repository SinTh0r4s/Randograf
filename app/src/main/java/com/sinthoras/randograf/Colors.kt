package com.sinthoras.randograf

import android.content.Context
import android.os.Build

enum class Colors(val colorId: Int) {
    VILLAGE(R.color.village),
    FOREST(R.color.forest),
    RIVER(R.color.river),
    FIELD(R.color.fields),
    MONSTER(R.color.monster),
    ALL(R.color.all);

    fun toArgb() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            MainActivity.getAppContext().resources.getColor(colorId, null)
        else
            MainActivity.getAppContext().resources.getColor(colorId) // Deprecated in API level 23
}