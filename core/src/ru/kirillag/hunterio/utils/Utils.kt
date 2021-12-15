package ru.kirillag.hunterio.utils

import com.badlogic.gdx.Gdx

val aspectRatio = getScreenWidth() / getScreenHeight();

fun VW(percent: Float): Float {
    return (getScreenWidth() / 100f) * percent;
}

fun VH(percent: Float): Float {
    return (getScreenHeight() / 100f) * percent;
}

fun getScreenWidth(): Int {
    return Gdx.graphics.width;
}

fun getScreenHeight(): Int {
    return Gdx.graphics.height;
}

fun byRatio(value: Float): Float {
    return  value * aspectRatio;
}
