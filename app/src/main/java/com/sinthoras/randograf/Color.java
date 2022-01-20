package com.sinthoras.randograf;

import androidx.annotation.ColorRes;

import java.io.Serializable;

public interface Color extends Serializable {

    @ColorRes
    int getColor();
}
