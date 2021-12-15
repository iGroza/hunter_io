package ru.kirillag.hunterio.model

import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class Player(val position: Vector2) {
    companion object {
        enum class State {
            NONE, WALKING, DEAD
        }

        const val SPEED = 2f;
        const val SIZE = 0.7f
    }

    var rotation: Float = 0f;

    val bounds = Rectangle();
    val velocity = Vector2()
    val state = State.NONE;

    init {
        bounds.width = SIZE;
        bounds.height = SIZE;
    }

    fun update(delta: Float) {
        position.add(velocity.cpy().scl(delta))
    }
}
