package com.sinthoras.randograf.phases

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.sinthoras.randograf.R

enum class ActionButtonStatus(@ColorRes val colorId: Int, @StringRes val stringId: Int) {
    GAME_START(R.color.button_new_season, R.string.label_start_game),
    NEW_SEASON(R.color.button_new_season, R.string.label_next_season),
    DRAW_CARD(R.color.button_draw_card, R.string.label_draw_card);
}