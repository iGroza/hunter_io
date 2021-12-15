package ru.kirillag.hunterio.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector3
import ru.kirillag.hunterio.model.World
import ru.kirillag.hunterio.utils.VH
import ru.kirillag.hunterio.utils.VW

val aspectRatio: Float = Gdx.graphics.width.toFloat() / Gdx.graphics.height.toFloat();

class WorldRenderer(private val world: World) {
    val CAMERA_WIDTH = World.WIDTH //* aspectRatio;
    val CAMERA_HEIGHT = World.HEIGHT //* aspectRatio;

    val camera = OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT)

    //    val viewport = ScreenViewport(camera);
    val renderer = ShapeRenderer();

    var width: Float? = 0f;
    var height: Float? = 0f;
    var ppuX: Float? = 0f;
    var ppuY: Float? = 0f;

    init {
        println("---> ${CAMERA_WIDTH} ${CAMERA_HEIGHT} ${aspectRatio}")
        setCamera(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f)
    }

    fun setSize(w: Int, h: Int) {
        width = w.toFloat();
        height = h.toFloat();
        ppuX = width!! / CAMERA_WIDTH;
        ppuY = height!! / CAMERA_HEIGHT;
    }

    fun setCamera(x: Float, y: Float) {
        camera.position.set(x, y, 0f);
        camera.update();
    }

    fun render() {
        drawBricks();
        drawPlayer();
    }

    private fun drawBricks() {
        renderer.projectionMatrix = camera.combined;
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        for (brick in world.bricks) {
            val rect = brick.bounds;
            val x1 = rect.x + brick.position.x;
            val y1 = rect.y + brick.position.y;
            renderer.color = Color.valueOf("#000000");
            renderer.rect(x1, y1, rect.width, rect.height);
        }

        renderer.end();
    }

    private fun drawPlayer() {
        renderer.projectionMatrix = camera.combined;
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        val player = world.player;
        val rect = player.bounds;
        val x1 = rect.x + player.position.x;
        val y1 = rect.y + player.position.y;
        renderer.color = Color.MAROON;
        renderer.circle(x1, y1, (rect.width + rect.height) / 4, 50);
        camera.position.lerp(Vector3(x1, y1, 0f), 0.5f)
//        camera.rotate(player.rotation / 2, 0f, 0f, 1f)

//        val target = Vector3(x1, y1, 0f)
//        val right = Vector3().set(camera.direction).crs(camera.up).nor();
//
//        val deltaAngleX = player.velocity.x;
//        val deltaAngleY = player.velocity.y;

//        camera.rotateAround(target, right, player.rotation);
//        camera.rotate(Vector3.Y, deltaAngleY);

        camera.update()
        renderer.end();
    }
}
