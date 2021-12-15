package ru.kirillag.hunterio.controller

import com.badlogic.gdx.math.Vector2
import ru.kirillag.hunterio.model.Player
import ru.kirillag.hunterio.model.World
import kotlin.math.abs
import kotlin.math.atan2

class WorldController(val world: World) {
    val player = world.player;

    init {

    }

    fun update(delta: Float) {
        player.update(delta);
    }

    fun updateDirection(direction: Vector2) {

        var rotation = atan2(
            (direction.y - player.velocity.y).toDouble(),
            (direction.x - player.velocity.x).toDouble()
        ) - 1 //* (180.0 / Math.PI);

//        if(rotation < 0){
//            rotation = 360 - abs(rotation)
//        }

//        println("rotation: $rotation)")

        if (direction.x == 0.0f && direction.y == 0.0f) {
            player.velocity.lerp(direction, 0.05f)
        } else {
            player.velocity.set(direction.cpy().scl(Player.SPEED))
        }

        player.rotation = rotation.toFloat()
    }

}
