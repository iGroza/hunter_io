package ru.kirillag.hunterio.screens

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL30
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle
import com.badlogic.gdx.scenes.scene2d.utils.Drawable
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.badlogic.gdx.utils.viewport.FillViewport
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.ScreenViewport
import ru.kirillag.hunterio.controller.WorldController
import ru.kirillag.hunterio.model.Player
import ru.kirillag.hunterio.model.TouchpadController
import ru.kirillag.hunterio.model.World
import ru.kirillag.hunterio.utils.VW
import ru.kirillag.hunterio.view.WorldRenderer

class GameScreen : Screen {
    var world: World? = null;
    var controller: WorldController? = null;
    var renderer: WorldRenderer? = null;

    var stage: Stage? = null;
    var touchpadController = TouchpadController()

    var touchpad = touchpadController.touchpad;

    var width = 0f;
    var height = 0f;

    override fun show() {
        world = World();
        controller = WorldController(world!!);
        renderer = WorldRenderer(world!!)

        stage = Stage(ScreenViewport(renderer!!.camera));
        stage!!.addActor(touchpad)
        Gdx.input.inputProcessor = stage;
    }



    override fun render(delta: Float) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        calculateNewPosition();
        controller!!.update(delta);
        renderer!!.render();
        stage!!.draw()
    }

    private fun calculateNewPosition(){
        val offsetX = touchpad!!.knobPercentX;
        val offsetY = touchpad!!.knobPercentY;

        controller!!.updateDirection(Vector2(offsetX, offsetY))
    }

    override fun resize(width: Int, height: Int) {
        renderer?.setSize(width, height);
        this.width = width.toFloat();
        this.height = height.toFloat();

        stage!!.viewport.update(width, height, false);
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }

    override fun dispose() {
    }
}
