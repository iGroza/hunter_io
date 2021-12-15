package ru.kirillag.hunterio.model

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad
import com.badlogic.gdx.scenes.scene2d.utils.Drawable

class TouchpadController {
    var touchpad: Touchpad? = null
    var touchpadStyle: Touchpad.TouchpadStyle? = null
    var touchpadSkin: Skin? = null
    var touchBackground: Drawable? = null
    var touchKnob: Drawable? = null

    init {
        configureTouchpad()
    }

    private fun configureTouchpad() {
        touchpadSkin = Skin()
        touchpadSkin!!.add("touchBackground", Texture("data/touchBackground.png"))
        touchpadSkin!!.add("touchKnob", Texture("data/touchKnob.png"))
        touchpadStyle = Touchpad.TouchpadStyle()
        touchBackground = touchpadSkin!!.getDrawable("touchBackground")
        touchKnob = touchpadSkin!!.getDrawable("touchKnob")
        touchpadStyle!!.background = touchBackground
        touchpadStyle!!.knob = touchKnob

        touchpad = Touchpad(10f, touchpadStyle)
        val touchpadSize = 400f;
        touchpad!!.setBounds((Gdx.graphics.width / 2) - (touchpadSize / 2), 150f, touchpadSize, touchpadSize)
    }
}
