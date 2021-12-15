package ru.kirillag.hunterio.model

import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class Brick(val position: Vector2) {
    companion object {
        const val SIZE = 1f;
    }

    val bounds = Rectangle();

    init {
        bounds.width = SIZE;
        bounds.height = SIZE;
    }
}
