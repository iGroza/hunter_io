package ru.kirillag.hunterio.model

import com.badlogic.gdx.math.Vector2

class World {
    companion object {
        const val WIDTH = 50f;
        const val HEIGHT = 130f;
    }

    val bricks = ArrayList<Brick>();
    val player = Player(Vector2(3f, 5f));

    init {
        createWorld()
    }

    private fun createWorld() {
        bricks.add(Brick(Vector2(0f, 0f)));
        bricks.add(Brick(Vector2(1f, 0f)));
        bricks.add(Brick(Vector2(2f, 4f)));
        bricks.add(Brick(Vector2(3f, 0f)));
        bricks.add(Brick(Vector2(4f, 0f)));
        bricks.add(Brick(Vector2(5f, 0f)));
        bricks.add(Brick(Vector2(6f, 2f)));
        bricks.add(Brick(Vector2(7f, 0f)));
    }

}
